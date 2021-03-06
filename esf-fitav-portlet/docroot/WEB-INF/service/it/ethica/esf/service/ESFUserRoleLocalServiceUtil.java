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
 * Provides the local service utility for ESFUserRole. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFUserRoleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFUserRoleLocalService
 * @see it.ethica.esf.service.base.ESFUserRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserRoleLocalServiceImpl
 * @generated
 */
public class ESFUserRoleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f user role to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserRole the e s f user role
	* @return the e s f user role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole addESFUserRole(
		it.ethica.esf.model.ESFUserRole esfUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFUserRole(esfUserRole);
	}

	/**
	* Creates a new e s f user role with the primary key. Does not add the e s f user role to the database.
	*
	* @param esfUserRoleId the primary key for the new e s f user role
	* @return the new e s f user role
	*/
	public static it.ethica.esf.model.ESFUserRole createESFUserRole(
		long esfUserRoleId) {
		return getService().createESFUserRole(esfUserRoleId);
	}

	/**
	* Deletes the e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserRoleId the primary key of the e s f user role
	* @return the e s f user role that was removed
	* @throws PortalException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole deleteESFUserRole(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserRole(esfUserRoleId);
	}

	/**
	* Deletes the e s f user role from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserRole the e s f user role
	* @return the e s f user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole deleteESFUserRole(
		it.ethica.esf.model.ESFUserRole esfUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserRole(esfUserRole);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFUserRole fetchESFUserRole(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserRole(esfUserRoleId);
	}

	/**
	* Returns the e s f user role with the matching UUID and company.
	*
	* @param uuid the e s f user role's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole fetchESFUserRoleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserRoleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f user role matching the UUID and group.
	*
	* @param uuid the e s f user role's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole fetchESFUserRoleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFUserRoleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f user role with the primary key.
	*
	* @param esfUserRoleId the primary key of the e s f user role
	* @return the e s f user role
	* @throws PortalException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole getESFUserRole(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRole(esfUserRoleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f user role with the matching UUID and company.
	*
	* @param uuid the e s f user role's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f user role
	* @throws PortalException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole getESFUserRoleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRoleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f user role matching the UUID and group.
	*
	* @param uuid the e s f user role's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f user role
	* @throws PortalException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole getESFUserRoleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRoleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getESFUserRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRoles(start, end);
	}

	/**
	* Returns the number of e s f user roles.
	*
	* @return the number of e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFUserRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFUserRolesCount();
	}

	/**
	* Updates the e s f user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUserRole the e s f user role
	* @return the e s f user role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserRole updateESFUserRole(
		it.ethica.esf.model.ESFUserRole esfUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFUserRole(esfUserRole);
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

	/**
	* Ricerca tutti gli oggetti ESFUserRole
	*
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRole()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfUserRole();
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRole(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfUserRole(start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole sulla base del tipo di ruolo.
	*
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRoleByType(
		int type) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfUserRoleByType(type);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole sulla base del tipo di ruolo.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRoleByType(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfUserRoleByType(type, start, end);
	}

	/**
	* ricerca dei ruoli non assegnati al tiratore in base al tipo
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRoleByStateNoAssign(
		long shooterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAllEsfUserRoleByStateNoAssign(shooterId, start, end);
	}

	public static int countAllEsfUserRoleByStateNoAssign(long shooterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAllEsfUserRoleByStateNoAssign(shooterId);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state</b> sulla base del titolo e nome.
	* I parametri di <b>title</b> e <b>name</b> sono in LIKE.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param title titolo del ruolo
	* @param name nome del ruolo
	* @param state stato del ruolo
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllUserRoleByLikeT_N(
		java.lang.String title, java.lang.String name, int state, int start,
		int end) {
		return getService()
				   .getAllUserRoleByLikeT_N(title, name, state, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state</b> sulla base del titolo e nome.
	* I parametri di <b>title</b> e <b>name</b> sono in LIKE.
	*
	* @param title titolo del ruolo
	* @param name nome del ruolo
	* @param state stato del ruolo
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllUserRoleByLikeT_N(
		java.lang.String title, java.lang.String name, int state) {
		return getService().getAllUserRoleByLikeT_N(title, name, state);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/>.
	*
	* @param state stato del ruolo
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getEsfUserRoleByState(
		int state) {
		return getService().getEsfUserRoleByState(state);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/>.
	* parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param state stato del ruolo
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getEsfUserRoleByState(
		int state, int start, int end) {
		return getService().getEsfUserRoleByState(state, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> sulla base del tipo di ruolo.
	*
	* @param state stato del ruolo
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRoleByT_S(
		int type, int state) {
		return getService().getAllEsfUserRoleByT_S(type, state);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> sulla base del tipo di ruolo.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param state stato del ruolo
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getAllEsfUserRoleByT_S(
		int type, int state, int start, int end) {
		return getService().getAllEsfUserRoleByT_S(type, state, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> sulla base del tipo di ruolo
	* verificando, inoltre, se e' di tipo DBO.
	*
	* @param state stato del ruolo
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @param isDBO 'true' se amministrazione 'false' altrimenti
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getEsfUserRoleByT_S_BDO(
		int type, int state, boolean isBDO) {
		return getService().getEsfUserRoleByT_S_BDO(type, state, isBDO);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> sulla base del tipo di ruolo
	* verificando, inoltre, se e' di tipo DBO.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param state stato del ruolo
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @param isDBO 'true' se amministrazione 'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getEsfUserRoleByT_S_BDO(
		int type, int state, boolean isBDO, int start, int end) {
		return getService()
				   .getEsfUserRoleByT_S_BDO(type, state, isBDO, start, end);
	}

	/**
	* Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> associati ad una organizzazione
	* sulla base del tipo di ruolo e verificando se e' di tipo DBO.
	*
	* @param esfOrganizationId l'identificativo dell'organizzazione
	* @param state stato del ruolo
	* @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	* @param isDBO 'true' se amministrazione 'false' altrimenti
	* @return List<ESFUserRole>
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserRole> getEsfUserRoleByT_S_BDO_OrgId(
		int type, int state, boolean isBDO, long esfOrganizationId) {
		return getService()
				   .getEsfUserRoleByT_S_BDO_OrgId(type, state, isBDO,
			esfOrganizationId);
	}

	public static int getAllEsfUserRoleCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfUserRoleCount();
	}

	public static it.ethica.esf.model.ESFUserRole addESFUserRole(long userId,
		long groupId, long companyId, java.lang.String name,
		java.lang.String description,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> titleMap, int type,
		java.lang.String subtype, boolean isBDO, boolean isLEA,
		boolean isOrgAdmin, boolean isEditable, int maxUser,
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserRole(userId, groupId, companyId, name,
			description, descriptionMap, titleMap, type, subtype, isBDO, isLEA,
			isOrgAdmin, isEditable, maxUser, esfEntityState);
	}

	public static it.ethica.esf.model.ESFUserRole addESFUserRole(long userId,
		java.lang.String name, java.lang.String description,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> titleMap, int type,
		java.lang.String subtype, boolean isBDO, boolean isLEA,
		boolean isOrgAdmin, boolean isEditable, int maxUser,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext esfUserRoleServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFUserRole(userId, name, description, className,
			classPK, descriptionMap, titleMap, type, subtype, isBDO, isLEA,
			isOrgAdmin, isEditable, maxUser, esfEntityState,
			esfUserRoleServiceContext);
	}

	public static it.ethica.esf.model.ESFUserRole deleteESFUserRole(
		long esfUserRoleId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFUserRole(esfUserRoleId, serviceContext);
	}

	public static it.ethica.esf.model.ESFUserRole updateESFUserRole(
		long userId, long esfUserRoleId, java.lang.String name,
		java.lang.String description, java.lang.String className,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> titleMap, int type,
		java.lang.String subtype, boolean isBDO, boolean isLEA,
		boolean isOrgAdmin, boolean isEditable, int maxUser,
		com.liferay.portal.service.ServiceContext esfUserRoleServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFUserRole(userId, esfUserRoleId, name, description,
			className, descriptionMap, titleMap, type, subtype, isBDO, isLEA,
			isOrgAdmin, isEditable, maxUser, esfUserRoleServiceContext);
	}

	public static com.liferay.portal.model.Role checkNome(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().checkNome(name, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFUserRoleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFUserRoleLocalService.class.getName());

			if (invokableLocalService instanceof ESFUserRoleLocalService) {
				_service = (ESFUserRoleLocalService)invokableLocalService;
			}
			else {
				_service = new ESFUserRoleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFUserRoleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFUserRoleLocalService service) {
	}

	private static ESFUserRoleLocalService _service;
}