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
 * Provides the local service interface for ESFGun. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFGunLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFGunLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFGunLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFGunLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFGunLocalServiceUtil} to access the e s f gun local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFGunLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f gun to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGun addESFGun(
		it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f gun with the primary key. Does not add the e s f gun to the database.
	*
	* @param esfGunId the primary key for the new e s f gun
	* @return the new e s f gun
	*/
	public it.ethica.esf.model.ESFGun createESFGun(long esfGunId);

	/**
	* Deletes the e s f gun with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun that was removed
	* @throws PortalException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGun deleteESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f gun from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGun deleteESFGun(
		it.ethica.esf.model.ESFGun esfGun)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public it.ethica.esf.model.ESFGun fetchESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun with the matching UUID and company.
	*
	* @param uuid the e s f gun's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFGun fetchESFGunByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun matching the UUID and group.
	*
	* @param uuid the e s f gun's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFGun fetchESFGunByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun with the primary key.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun
	* @throws PortalException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFGun getESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun with the matching UUID and company.
	*
	* @param uuid the e s f gun's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun
	* @throws PortalException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFGun getESFGunByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun matching the UUID and group.
	*
	* @param uuid the e s f gun's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun
	* @throws PortalException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFGun getESFGunByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f guns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGuns(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f guns.
	*
	* @return the number of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFGunsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f gun in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGun updateESFGun(
		it.ethica.esf.model.ESFGun esfGun)
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
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K(
		java.lang.String code, long esfGunKindId);

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param start
	* @param end
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K(
		java.lang.String code, long esfGunKindId, int start, int end);

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice dell'arma, della tipologia
	* dell'arma e dell'utente.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	* e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId);

	/**
	* Ricerca arma per Produttore Modello e Codice
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeM_C_K_U(
		long esfGunTypeId, java.lang.String code, long esfGunKindId,
		long esfUserId, int start, int end);

	public int countESFGunByLikeM_C_K_U(long esfGunTypeId,
		java.lang.String code, long esfGunKindId, long esfUserId);

	/**
	* Ricerca arma per Produttore Modello e Codice
	*
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeM_K(
		long esfGunTypeId, long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countESFGunByLikeM_K(long esfGunTypeId, long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFGun.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGuns()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base della tipologia di arma.
	*
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByESFGunKind(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ritorna la quantitï¿½ di oggetti ESFGun sulla base della tipologia di arma.
	*
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFGunsByESFGunKindCount(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	* * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param catridgeName identifica la cartuccia, se ï¿½ vuoto, indica un arma di tipo fucile
	* @param start
	* @param end
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId, int start,
		int end);

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param catridgeName identifica la cartuccia, se ï¿½ vuoto, indica un arma di tipo fucile
	* @return List<ESFGun>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_M_U(
		java.lang.String code, long esfGunKindId,
		java.lang.String catridgeName, long esfUserId);

	public it.ethica.esf.model.ESFGun addESFGun(long userId,
		java.lang.String code, long esfGunKindId, long esfOrganizationId,
		long esfUserId, java.lang.String registrationNumber,
		long catridgeCaliber, int typology, java.lang.String measures,
		boolean isFavoriteGun, java.lang.String note, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFGun updateESFGun(long userId, long esfGunId,
		java.lang.String code, long esfGunKindId, long esfOrganizationId,
		long esfUserId, java.lang.String registrationNumber,
		long catridgeCaliber, int typology, java.lang.String measures,
		boolean isFavoriteGun, java.lang.String note, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFGun deleteESFGun(long esfGunId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFullName(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFGun checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameMod(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameM(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getNameT(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}