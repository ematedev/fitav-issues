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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFGunLocalService}.
 *
 * @author Ethica
 * @see ESFGunLocalService
 * @generated
 */
public class ESFGunLocalServiceWrapper implements ESFGunLocalService,
	ServiceWrapper<ESFGunLocalService> {
	public ESFGunLocalServiceWrapper(ESFGunLocalService esfGunLocalService) {
		_esfGunLocalService = esfGunLocalService;
	}

	/**
	* Adds the e s f gun to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun addESFGun(
		it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.addESFGun(esfGun);
	}

	/**
	* Creates a new e s f gun with the primary key. Does not add the e s f gun to the database.
	*
	* @param esfGunId the primary key for the new e s f gun
	* @return the new e s f gun
	*/
	@Override
	public it.ethica.esf.model.ESFGun createESFGun(long esfGunId) {
		return _esfGunLocalService.createESFGun(esfGunId);
	}

	/**
	* Deletes the e s f gun with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun that was removed
	* @throws PortalException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun deleteESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.deleteESFGun(esfGunId);
	}

	/**
	* Deletes the e s f gun from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun deleteESFGun(
		it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.deleteESFGun(esfGun);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfGunLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFGun fetchESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.fetchESFGun(esfGunId);
	}

	/**
	* Returns the e s f gun with the matching UUID and company.
	*
	* @param uuid the e s f gun's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun fetchESFGunByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.fetchESFGunByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun matching the UUID and group.
	*
	* @param uuid the e s f gun's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun fetchESFGunByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.fetchESFGunByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f gun with the primary key.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun
	* @throws PortalException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun getESFGun(long esfGunId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGun(esfGunId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f gun with the matching UUID and company.
	*
	* @param uuid the e s f gun's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun
	* @throws PortalException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun getESFGunByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f gun matching the UUID and group.
	*
	* @param uuid the e s f gun's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun
	* @throws PortalException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun getESFGunByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGuns(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGuns(start, end);
	}

	/**
	* Returns the number of e s f guns.
	*
	* @return the number of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFGunsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunsCount();
	}

	/**
	* Updates the e s f gun in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGun the e s f gun
	* @return the e s f gun that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGun updateESFGun(
		it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.updateESFGun(esfGun);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfGunLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfGunLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfGunLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K(
		java.lang.String code, long esfGunKindId) {
		return _esfGunLocalService.getESFGunByLikeC_K(code, esfGunKindId);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K(
		java.lang.String code, long esfGunKindId, int start, int end) {
		return _esfGunLocalService.getESFGunByLikeC_K(code, esfGunKindId,
			start, end);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return _esfGunLocalService.getESFGunByLikeC_K_U(code, esfGunKindId,
			esfUserId);
	}

	/**
	* Ricerca arma per Produttore Modello e Codice
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeM_C_K_U(
		long esfGunTypeId, java.lang.String code, long esfGunKindId,
		long esfUserId, int start, int end) {
		return _esfGunLocalService.getESFGunByLikeM_C_K_U(esfGunTypeId, code,
			esfGunKindId, esfUserId, start, end);
	}

	@Override
	public int countESFGunByLikeM_C_K_U(long esfGunTypeId,
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return _esfGunLocalService.countESFGunByLikeM_C_K_U(esfGunTypeId, code,
			esfGunKindId, esfUserId);
	}

	/**
	* Ricerca arma per Produttore Modello e Codice
	*
	* @throws SystemException
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeM_K(
		long esfGunTypeId, long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunByLikeM_K(esfGunTypeId,
			esfGunKindId, start, end);
	}

	@Override
	public int countESFGunByLikeM_K(long esfGunTypeId, long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.countESFGunByLikeM_K(esfGunTypeId,
			esfGunKindId);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunsByUserId(esfUserId);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunsByUserId(esfUserId, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGuns()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGuns();
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base della tipologia di arma.
	*
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunsByESFGunKind(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunsByESFGunKind(esfGunKindId);
	}

	/**
	* Ritorna la quantit� di oggetti ESFGun sulla base della tipologia di arma.
	*
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFGun>
	*/
	@Override
	public int getESFGunsByESFGunKindCount(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getESFGunsByESFGunKindCount(esfGunKindId);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	* * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param catridgeName identifica la cartuccia, se � vuoto, indica un arma di tipo fucile
	* @param start
	* @param end
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId, int start,
		int end) {
		return _esfGunLocalService.getESFGunByLikeC_K_U(code, esfGunKindId,
			esfUserId, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	* dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @param catridgeName identifica la cartuccia, se � vuoto, indica un arma di tipo fucile
	* @return List<ESFGun>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGun> getESFGunByLikeC_K_M_U(
		java.lang.String code, long esfGunKindId,
		java.lang.String catridgeName, long esfUserId) {
		return _esfGunLocalService.getESFGunByLikeC_K_M_U(code, esfGunKindId,
			catridgeName, esfUserId);
	}

	@Override
	public it.ethica.esf.model.ESFGun addESFGun(long userId,
		java.lang.String code, long esfGunKindId, long esfOrganizationId,
		long esfUserId, java.lang.String registrationNumber,
		long catridgeCaliber, int typology, java.lang.String measures,
		boolean isFavoriteGun, java.lang.String note, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.addESFGun(userId, code, esfGunKindId,
			esfOrganizationId, esfUserId, registrationNumber, catridgeCaliber,
			typology, measures, isFavoriteGun, note, name, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGun updateESFGun(long userId, long esfGunId,
		java.lang.String code, long esfGunKindId, long esfOrganizationId,
		long esfUserId, java.lang.String registrationNumber,
		long catridgeCaliber, int typology, java.lang.String measures,
		boolean isFavoriteGun, java.lang.String note, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.updateESFGun(userId, esfGunId, code,
			esfGunKindId, esfOrganizationId, esfUserId, registrationNumber,
			catridgeCaliber, typology, measures, isFavoriteGun, note, name,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGun deleteESFGun(long esfGunId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.deleteESFGun(esfGunId, serviceContext);
	}

	@Override
	public java.lang.String getFullName(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getFullName(esfGun);
	}

	@Override
	public it.ethica.esf.model.ESFGun checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.checkCode(code, serviceContext);
	}

	@Override
	public java.lang.String getNameMod(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getNameMod(esfGun);
	}

	@Override
	public java.lang.String getNameM(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getNameM(esfGun);
	}

	@Override
	public java.lang.String getNameT(it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunLocalService.getNameT(esfGun);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFGunLocalService getWrappedESFGunLocalService() {
		return _esfGunLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFGunLocalService(
		ESFGunLocalService esfGunLocalService) {
		_esfGunLocalService = esfGunLocalService;
	}

	@Override
	public ESFGunLocalService getWrappedService() {
		return _esfGunLocalService;
	}

	@Override
	public void setWrappedService(ESFGunLocalService esfGunLocalService) {
		_esfGunLocalService = esfGunLocalService;
	}

	private ESFGunLocalService _esfGunLocalService;
}