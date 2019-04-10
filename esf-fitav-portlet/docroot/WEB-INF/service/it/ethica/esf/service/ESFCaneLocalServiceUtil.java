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
 * Provides the local service utility for ESFCane. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFCaneLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFCaneLocalService
 * @see it.ethica.esf.service.base.ESFCaneLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFCaneLocalServiceImpl
 * @generated
 */
public class ESFCaneLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFCaneLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f cane to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCane addESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFCane(esfCane);
	}

	/**
	* Creates a new e s f cane with the primary key. Does not add the e s f cane to the database.
	*
	* @param esfCaneId the primary key for the new e s f cane
	* @return the new e s f cane
	*/
	public static it.ethica.esf.model.ESFCane createESFCane(long esfCaneId) {
		return getService().createESFCane(esfCaneId);
	}

	/**
	* Deletes the e s f cane with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane that was removed
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFCane(esfCaneId);
	}

	/**
	* Deletes the e s f cane from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCane deleteESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFCane(esfCane);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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

	public static it.ethica.esf.model.ESFCane fetchESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFCane(esfCaneId);
	}

	/**
	* Returns the e s f cane with the primary key.
	*
	* @param esfCaneId the primary key of the e s f cane
	* @return the e s f cane
	* @throws PortalException if a e s f cane with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCane getESFCane(long esfCaneId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCane(esfCaneId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCanes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCanes(start, end);
	}

	/**
	* Returns the number of e s f canes.
	*
	* @return the number of e s f canes
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFCanesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCanesCount();
	}

	/**
	* Updates the e s f cane in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCane the e s f cane
	* @return the e s f cane that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCane updateESFCane(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFCane(esfCane);
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

	public static it.ethica.esf.model.ESFCane addESFCane(long userId,
		long esfGunKindId, long esgGunTypeId, long esfUserId,
		long esfOrganizationId, java.lang.String code, long caneCaliber,
		int typology, java.lang.String measures, boolean isFavoriteGun,
		long shooterId, java.lang.String shooter_note,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFCane(userId, esfGunKindId, esgGunTypeId, esfUserId,
			esfOrganizationId, code, caneCaliber, typology, measures,
			isFavoriteGun, shooterId, shooter_note, serviceContext);
	}

	public static it.ethica.esf.model.ESFCane updateESFCane(long userId,
		long esfCaneId, long esfGunKindId, long esgGunTypeId, long esfUserId,
		java.lang.String code, long caneCaliber, int typology,
		java.lang.String measures, boolean isFavoriteGun, long shooterId,
		java.lang.String shooter_note, long gunUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFCane(userId, esfCaneId, esfGunKindId,
			esgGunTypeId, esfUserId, code, caneCaliber, typology, measures,
			isFavoriteGun, shooterId, shooter_note, gunUserId, serviceContext);
	}

	public static it.ethica.esf.model.ESFCane deleteESFCane(long esfCaneId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFCane(esfCaneId, serviceContext);
	}

	/**
	* Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFCane>
	*/
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCanesByUserId(esfUserId);
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCanesByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCanesByUserId(esfUserId, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFCane.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFCane>
	*/
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCanes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFCanes();
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId) {
		return getService().getESFCaneByLikeC_K(code, esfGunKindId);
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFCaneByLikeC_K(
		java.lang.String code, long esfGunKindId, int start, int end) {
		return getService().getESFCaneByLikeC_K(code, esfGunKindId, start, end);
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return getService().getESFGunByLikeC_K_U(code, esfGunKindId, esfUserId);
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
	public static java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeC_K_U(
		java.lang.String code, long esfGunKindId, long esfUserId, int start,
		int end) {
		return getService()
				   .getESFGunByLikeC_K_U(code, esfGunKindId, esfUserId, start,
			end);
	}

	public static java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_C_K_U(
		long esfGunTypeId, java.lang.String code, long esfGunKindId,
		long esfUserId, int start, int end) {
		return getService()
				   .getESFGunByLikeT_C_K_U(esfGunTypeId, code, esfGunKindId,
			esfUserId, start, end);
	}

	public static int countESFGunByLikeT_C_K_U(long esfGunTypeId,
		java.lang.String code, long esfGunKindId, long esfUserId) {
		return getService()
				   .countESFGunByLikeT_C_K_U(esfGunTypeId, code, esfGunKindId,
			esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT_K(
		long esfGunTypeId, long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFGunByLikeT_K(esfGunTypeId, esfGunKindId, start, end);
	}

	public static int countESFGunByLikeT_K(long esfGunTypeId, long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countESFGunByLikeT_K(esfGunTypeId, esfGunKindId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCane> getESFGunByLikeT(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFGunByLikeT(esfGunTypeId, start, end);
	}

	public static int countESFGunByLikeT(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countESFGunByLikeT(esfGunTypeId);
	}

	public static java.lang.String getFullName(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFullName(esfCane);
	}

	public static java.lang.String getNameMod(
		it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameMod(esfCane);
	}

	public static java.lang.String getNameM(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameM(esfCane);
	}

	public static java.lang.String getNameT(it.ethica.esf.model.ESFCane esfCane)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameT(esfCane);
	}

	public static it.ethica.esf.model.ESFCane checkCode(java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkCode(code, serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFCane> getCanebyK(
		long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCanebyK(gunKindId);
	}

	public static java.util.List<it.ethica.esf.model.ESFCane> getCanebyKindId(
		long gunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCanebyKindId(gunKindId, start, end);
	}

	public static int countCanebyKindId(long gunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countCanebyKindId(gunKindId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFCaneLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFCaneLocalService.class.getName());

			if (invokableLocalService instanceof ESFCaneLocalService) {
				_service = (ESFCaneLocalService)invokableLocalService;
			}
			else {
				_service = new ESFCaneLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFCaneLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFCaneLocalService service) {
	}

	private static ESFCaneLocalService _service;
}