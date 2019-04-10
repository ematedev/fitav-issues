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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFCaneLocalService}.
 *
 * @author Ethica
 * @see ESFCaneLocalService
 * @generated
 */
public class ESFCaneLocalServiceWrapper implements ESFCaneLocalService,
	ServiceWrapper<ESFCaneLocalService> {
	public ESFCaneLocalServiceWrapper(ESFCaneLocalService esfCaneLocalService) {
		_esfCaneLocalService = esfCaneLocalService;
	}

	/**
	* Adds the e s f cane to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCane addESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.addESFCane(esfCane);
	}

	/**
	* Creates a new e s f cane with the primary key. Does not add the e s f cane to the database.
	*
	* @param esfCaneId the primary key for the new e s f cane
	* @return the new e s f cane
	*/
	@Override
	public it.ethica.esf.model.ESFCane createESFCane(long esfCaneId) {
		return _esfCaneLocalService.createESFCane(esfCaneId);
	}

	/**
	* Deletes the e s f cane with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane that was removed
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.deleteESFCane(esfCaneId);
	}

	/**
	* Deletes the e s f cane from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCane deleteESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.deleteESFCane(esfCane);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfCaneLocalService.dynamicQuery();
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
		return _esfCaneLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfCaneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfCaneLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFCane fetchESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.fetchESFCane(esfCaneId);
	}

	/**
	* Returns the e s f cane with the primary key.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCane getESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCane(esfCaneId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanes(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCanes(start, end);
	}

	/**
	* Returns the number of e s f canes.
	*
	* @return the number of e s f canes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFCanesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCanesCount();
	}

	/**
	* Updates the e s f cane in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCane updateESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.updateESFCane(esfCane);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCaneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCaneLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCaneLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.ethica.esf.model.ESFCane addESFCane(long userId,
		long esfGunKindId, long esgGunTypeId, long esfUserId,
		long esfOrganizationId, java.lang.String code, long caneCaliber,
		int typology, java.lang.String measures, boolean isFavoriteGun,
		long shooterId, java.lang.String shooter_note,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.addESFCane(userId, esfGunKindId,
			esgGunTypeId, esfUserId, esfOrganizationId, code, caneCaliber,
			typology, measures, isFavoriteGun, shooterId, shooter_note,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFCane updateESFCane(long userId,
		long esfCaneId, long esfGunKindId, long esgGunTypeId, long esfUserId,
		java.lang.String code, long caneCaliber, int typology,
		java.lang.String measures, boolean isFavoriteGun, long shooterId,
		java.lang.String shooter_note, long gunUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.updateESFCane(userId, esfCaneId,
			esfGunKindId, esgGunTypeId, esfUserId, code, caneCaliber, typology,
			measures, isFavoriteGun, shooterId, shooter_note, gunUserId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.deleteESFCane(esfCaneId, serviceContext);
	}

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFCane>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCanesByUserId(esfUserId);
	}

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFCane>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCanesByUserId(esfUserId, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFCane.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFCane>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCanes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFCanes();
	}

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base del codice e della tipologia
	* dell'arma.
	* Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	*
	* @param code il codice dell'arma
	* @param esfGunKindId l'identificativo del tipo di arma
	* @return List<ESFCane>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId) {
		return _esfCaneLocalService.getESFCaneByLikeC_K(code, esfGunKindId);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId, int start, int end) {
		return _esfCaneLocalService.getESFCaneByLikeC_K(code, esfGunKindId,
			start, end);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return _esfCaneLocalService.getESFGunByLikeC_K_U(code, esfGunKindId,
			esfUserId);
	}

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
	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId, int start,
		int end) {
		return _esfCaneLocalService.getESFGunByLikeC_K_U(code, esfGunKindId,
			esfUserId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_C_K_U(
		long esfGunTypeId, java.lang.String code, long esfGunKindId,
		long esfUserId, int start, int end) {
		return _esfCaneLocalService.getESFGunByLikeT_C_K_U(esfGunTypeId, code,
			esfGunKindId, esfUserId, start, end);
	}

	@Override
	public int countESFGunByLikeT_C_K_U(long esfGunTypeId,
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return _esfCaneLocalService.countESFGunByLikeT_C_K_U(esfGunTypeId,
			code, esfGunKindId, esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_K(
		long esfGunTypeId, long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFGunByLikeT_K(esfGunTypeId,
			esfGunKindId, start, end);
	}

	@Override
	public int countESFGunByLikeT_K(long esfGunTypeId, long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.countESFGunByLikeT_K(esfGunTypeId,
			esfGunKindId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getESFGunByLikeT(esfGunTypeId, start, end);
	}

	@Override
	public int countESFGunByLikeT(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.countESFGunByLikeT(esfGunTypeId);
	}

	@Override
	public java.lang.String getFullName(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getFullName(esfCane);
	}

	@Override
	public java.lang.String getNameMod(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getNameMod(esfCane);
	}

	@Override
	public java.lang.String getNameM(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getNameM(esfCane);
	}

	@Override
	public java.lang.String getNameT(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getNameT(esfCane);
	}

	@Override
	public it.ethica.esf.model.ESFCane checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.checkCode(code, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getCanebyK(
		long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getCanebyK(gunKindId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCane> getCanebyKindId(
		long gunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.getCanebyKindId(gunKindId, start, end);
	}

	@Override
	public int countCanebyKindId(long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCaneLocalService.countCanebyKindId(gunKindId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCaneLocalService getWrappedESFCaneLocalService() {
		return _esfCaneLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCaneLocalService(
		ESFCaneLocalService esfCaneLocalService) {
		_esfCaneLocalService = esfCaneLocalService;
	}

	@Override
	public ESFCaneLocalService getWrappedService() {
		return _esfCaneLocalService;
	}

	@Override
	public void setWrappedService(ESFCaneLocalService esfCaneLocalService) {
		_esfCaneLocalService = esfCaneLocalService;
	}

	private ESFCaneLocalService _esfCaneLocalService;
}