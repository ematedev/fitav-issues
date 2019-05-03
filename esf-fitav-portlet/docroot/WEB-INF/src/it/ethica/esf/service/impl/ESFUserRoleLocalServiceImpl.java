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

package it.ethica.esf.service.impl;

import it.ethica.esf.ESFUserRoleNameException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.base.ESFUserRoleLocalServiceBaseImpl;
import it.ethica.esf.util.ESFKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e s f user role local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFUserRoleLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author ethica
 * @see it.ethica.esf.service.base.ESFUserRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserRoleLocalServiceUtil
 */
public class ESFUserRoleLocalServiceImpl
	extends ESFUserRoleLocalServiceBaseImpl {

	/**
	 * Ricerca tutti gli oggetti ESFUserRole
	 * 
	 * @return List<ESFUserRole> 
	 */
	public List<ESFUserRole> getAllEsfUserRole()
		throws SystemException {

		return esfUserRolePersistence.findAll();
	}

	/**
	 * Ricerca tutti gli oggetti ESFUserRole
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	 * 
	 * @param start
	 * @param end
	 * @return List<ESFUserRole> 
	 */
	public List<ESFUserRole> getAllEsfUserRole(int start, int end)
		throws SystemException {

		return esfUserRolePersistence.findAll(start, end);
	}

	/**
	 * Ricerca tutti gli oggetti ESFUserRole sulla base del tipo di ruolo.
	 * 
	 * @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	 * @return List<ESFUserRole> 
	 */
	public List<ESFUserRole> getAllEsfUserRoleByType(int type)
		throws SystemException {

		return esfUserRolePersistence.findByType(type);
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
	public List<ESFUserRole> getAllEsfUserRoleByType(
		int type, int start, int end)
		throws SystemException {

		return esfUserRolePersistence.findByType(type, start, end);
	}
	
	/**
	 * ricerca dei ruoli non assegnati al tiratore in base al tipo
	 * 
	 */
	public List<ESFUserRole> getAllEsfUserRoleByStateNoAssign(
			 long shooterId, int start, int end)
			throws SystemException {
		
			List<ESFUserRole> userRolesnoAssign = new ArrayList<ESFUserRole>();
			List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();
			List<ESFUserESFUserRole> userRolesAssign = new ArrayList<ESFUserESFUserRole>();
			List<Long> rolesIds = new ArrayList<Long>();
			
			userRoles = ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(ESFKeys.ESFStateType.ENABLE);
			userRolesAssign = ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(shooterId, 0 , Integer.MAX_VALUE);
			
			for(ESFUserESFUserRole a : userRolesAssign){
				rolesIds.add(a.getEsfUserRoleId());
			}
			
			for(ESFUserRole b : userRoles){
				if(!rolesIds.contains(b.getEsfUserRoleId())){
					userRolesnoAssign.add(b);
				}
			}
			
			
			if(end > userRolesnoAssign.size()){
				end = userRolesnoAssign.size();
			}
		
			return userRolesnoAssign.subList(start, end);
		}
	
	public int countAllEsfUserRoleByStateNoAssign(
			 long shooterId)
			throws SystemException {
			
			int tot = 0;
			List<ESFUserRole> userRolesnoAssign = new ArrayList<ESFUserRole>();
			List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();
			List<ESFUserESFUserRole> userRolesAssign = new ArrayList<ESFUserESFUserRole>();
			List<Long> rolesIds = new ArrayList<Long>();
			
			userRoles = ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(ESFKeys.ESFStateType.ENABLE);
			userRolesAssign = ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(shooterId, 0 , Integer.MAX_VALUE);
			
			for(ESFUserESFUserRole a : userRolesAssign){
				rolesIds.add(a.getEsfUserRoleId());
			}
			
			for(ESFUserRole b : userRoles){
				if(!rolesIds.contains(b.getEsfUserRoleId())){
					userRolesnoAssign.add(b);
				}
			}
			
			

		
			return tot = userRolesnoAssign.size();
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
	public List<ESFUserRole> getAllUserRoleByLikeT_N(
		String title, String name, int state, int start, int end) {

		List<ESFUserRole> esfUserRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					Role.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.title").like(
				StringPool.PERCENT + title + StringPool.PERCENT));
			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.name").like(
				StringPool.PERCENT + name + StringPool.PERCENT));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.roleId").in(classPKs));

			List<Role> userRoles =
				RoleLocalServiceUtil.dynamicQuery(userRoleQuery, start, end);

			for (Role userRole : userRoles) {
				ESFUserRole esfUserRole =
					esfUserRolePersistence.fetchByPrimaryKey(userRole.getRoleId());
				esfUserRoles.add(esfUserRole);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRoles;
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
	public List<ESFUserRole> getAllUserRoleByLikeT_N(
		String title, String name, int state) {

		List<ESFUserRole> esfUserRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					Role.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.title").like(
				StringPool.PERCENT + title + StringPool.PERCENT));
			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.name").like(
				StringPool.PERCENT + name + StringPool.PERCENT));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.roleId").in(classPKs));

			List<Role> userRoles =
				RoleLocalServiceUtil.dynamicQuery(userRoleQuery);
			for (Role userRole : userRoles) {
				ESFUserRole esfUserRole =
					esfUserRolePersistence.fetchByPrimaryKey(userRole.getRoleId());
				esfUserRoles.add(esfUserRole);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRoles;
	}

	/**
	 * Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/>.
	 *
	 * @param state stato del ruolo
	 * @return List<ESFUserRole> 
	 */
	public List<ESFUserRole> getEsfUserRoleByState(int state) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles = ESFUserRoleLocalServiceUtil.dynamicQuery(userRoleQuery);
		}
		catch (Exception e) {

		}
		return userRoles;
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
	public List<ESFUserRole> getEsfUserRoleByState(int state, int start, int end) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles =
				ESFUserRoleLocalServiceUtil.dynamicQuery(
					userRoleQuery, start, end);
		}
		catch (Exception e) {

		}
		return userRoles;
	}

	/**
	 * Ricerca tutti gli oggetti ESFUserRole con stato <b>state<b/> sulla base del tipo di ruolo.
	 *
	 * @param state stato del ruolo
	 * @param type tipologia di ruolo [fitav, regioni, province, associazioni]
	 * @return List<ESFUserRole> 
	 */
	public List<ESFUserRole> getAllEsfUserRoleByT_S(int type, int state) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.type").eq(
				type));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles = ESFUserRoleLocalServiceUtil.dynamicQuery(userRoleQuery);
		}
		catch (Exception e) {

		}
		return userRoles;
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
	public List<ESFUserRole> getAllEsfUserRoleByT_S(
		int type, int state, int start, int end) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {

			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state, start, end);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.type").eq(
				type));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles =
				ESFUserRoleLocalServiceUtil.dynamicQuery(
					userRoleQuery, start, end);
		}
		catch (Exception e) {

		}
		return userRoles;
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
	public List<ESFUserRole> getEsfUserRoleByT_S_BDO(
		int type, int state, boolean isBDO) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.isBDO").eq(
				isBDO));
			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.type").eq(
				type));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles = ESFUserRoleLocalServiceUtil.dynamicQuery(userRoleQuery);
		}
		catch (Exception e) {

		}
		return userRoles;
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
	public List<ESFUserRole> getEsfUserRoleByT_S_BDO(
		int type, int state, boolean isBDO, int start, int end) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {
			List<ESFEntityState> entityStates =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
					ESFUserRole.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery userRoleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "userRoleQuery",
					PortletClassLoaderUtil.getClassLoader());

			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.isBDO").eq(
				isBDO));
			userRoleQuery.add(PropertyFactoryUtil.forName("userRoleQuery.type").eq(
				type));
			userRoleQuery.add(PropertyFactoryUtil.forName(
				"userRoleQuery.esfUserRoleId").in(classPKs));

			userRoles =
				ESFUserRoleLocalServiceUtil.dynamicQuery(
					userRoleQuery, start, end);
		}
		catch (Exception e) {

		}
		return userRoles;
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
	public List<ESFUserRole> getEsfUserRoleByT_S_BDO_OrgId(
		int type, int state, boolean isBDO, long esfOrganizationId) {

		List<ESFUserRole> userRoles = new ArrayList<ESFUserRole>();

		try {

			List<ESFUserESFUserRole> esfUserESFUserRoles =
				ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfOrganizzationId(esfOrganizationId);

			List<ESFUserRole> userRolesTmp = getEsfUserRoleByT_S_BDO(type, state, isBDO);
			
			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
				for(ESFUserRole userRoleTmp : userRolesTmp){
					
					if(esfUserESFUserRole.getEsfUserRoleId() == userRoleTmp.getEsfUserRoleId()){
						
						userRoles.add(userRoleTmp);
						
					}
				}
			}
		}
		catch (Exception e) {

		}
		return userRoles;
	}
	
	public int getAllEsfUserRoleCount()
		throws SystemException {

		return esfUserRolePersistence.countAll();
	}

	public ESFUserRole addESFUserRole(
		long userId, long groupId, long companyId, String name,
		String description, Map<Locale, String> descriptionMap,
		Map<Locale, String> titleMap, int type, String subtype, boolean isBDO,
		boolean isLEA, boolean isOrgAdmin, boolean isEditable, int maxUser,
		ESFEntityState esfEntityState)
		throws PortalException, SystemException {

		ESFUserRole esfUserRole = null;
		Role role = null;

		Date now = new Date();

		validate(name);

		try {
			role =
				RoleLocalServiceUtil.addRole(
					userId, companyId, name, titleMap, descriptionMap, type);

			long esfUserRoleId = role.getRoleId();

			ESFEntityStateLocalServiceUtil.addEntityState(
				userId, groupId, companyId, ESFUserRole.class.getName(),
				esfUserRoleId, esfEntityState.getEsfStateId());

			esfUserRole = esfUserRolePersistence.create(esfUserRoleId);

			esfUserRole.setCompanyId(companyId);
			esfUserRole.setGroupId(groupId);
			esfUserRole.setUserId(userId);
			esfUserRole.setUserName("root");
			esfUserRole.setCreateDate(now);
			esfUserRole.setModifiedDate(now);
			esfUserRole.setIsBDO(isBDO);
			esfUserRole.setIsLEA(isLEA);
			esfUserRole.setIsOrgAdmin(isOrgAdmin);
			esfUserRole.setType(type);
			esfUserRole.setMaxUser(maxUser);
			esfUserRole.setIsEditable(isEditable);

			esfUserRolePersistence.update(esfUserRole);

			resourceLocalService.addResources(
				companyId, groupId, userId, ESFUserRole.class.getName(),
				esfUserRoleId, false, true, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRole;
	}

	public ESFUserRole addESFUserRole(
		long userId, String name, String description, String className,
		long classPK, Map<Locale, String> descriptionMap,
		Map<Locale, String> titleMap, int type, String subtype, boolean isBDO,
		boolean isLEA, boolean isOrgAdmin, boolean isEditable, int maxUser,
		ESFEntityState esfEntityState, ServiceContext esfUserRoleServiceContext)
		throws PortalException, SystemException {

		ESFUserRole esfUserRole = null;
		Role role = null;

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();
		esfUserRoleServiceContext.getLocale();
		long groupId = esfUserRoleServiceContext.getScopeGroupId();

		validate(name);

		try {
			role =
				RoleLocalServiceUtil.addRole(
					userId, className, classPK, name, titleMap, descriptionMap,
					1, subtype, esfUserRoleServiceContext);

			long esfUserRoleId = role.getRoleId();

			ESFEntityStateLocalServiceUtil.addEntityState(
				esfUserRoleServiceContext.getUserId(),
				ESFUserRole.class.getName(), esfUserRoleId,
				esfEntityState.getEsfStateId(), esfUserRoleServiceContext);

			esfUserRole = esfUserRolePersistence.create(esfUserRoleId);

			esfUserRole.setCompanyId(esfUserRoleServiceContext.getCompanyId());
			esfUserRole.setGroupId(esfUserRoleServiceContext.getScopeGroupId());
			esfUserRole.setUserId(userId);
			esfUserRole.setUserName(user.getScreenName());
			esfUserRole.setCreateDate(now);
			esfUserRole.setModifiedDate(now);
			esfUserRole.setUuid(esfUserRoleServiceContext.getUuid());
			esfUserRole.setExpandoBridgeAttributes(esfUserRoleServiceContext);
			esfUserRole.setIsBDO(isBDO);
			esfUserRole.setIsLEA(isLEA);
			esfUserRole.setIsOrgAdmin(isOrgAdmin);
			esfUserRole.setType(type);
			esfUserRole.setMaxUser(maxUser);
			esfUserRole.setIsEditable(isEditable);

			esfUserRolePersistence.update(esfUserRole);

			resourceLocalService.addResources(
				user.getCompanyId(), groupId, userId,
				ESFUserRole.class.getName(), esfUserRoleId, false, true, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRole;
	}

	public ESFUserRole deleteESFUserRole(
		long esfUserRoleId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFUserRole esfUserRole = getESFUserRole(esfUserRoleId);

		try {
			resourceLocalService.deleteResource(
				serviceContext.getCompanyId(), ESFUserRole.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, esfUserRoleId);

			esfUserRole = deleteESFUserRole(esfUserRoleId);
			RoleLocalServiceUtil.deleteRole(esfUserRoleId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRole;
	}

	public ESFUserRole updateESFUserRole(
		long userId, long esfUserRoleId, String name, String description,
		String className, Map<Locale, String> descriptionMap,
		Map<Locale, String> titleMap, int type, String subtype, boolean isBDO,
		boolean isLEA, boolean isOrgAdmin, boolean isEditable, int maxUser,
		ServiceContext esfUserRoleServiceContext)
		throws SystemException, PortalException {

		ESFUserRole esfUserRole = null;
		Role role = null;

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();
		esfUserRoleServiceContext.getLocale();
		long groupId = esfUserRoleServiceContext.getScopeGroupId();

		validate(name);

		try {

			role =
				RoleLocalServiceUtil.updateRole(
					esfUserRoleId, name, titleMap, descriptionMap, subtype,
					esfUserRoleServiceContext);

			esfUserRole = getESFUserRole(role.getRoleId());

			esfUserRole.setModifiedDate(now);
			esfUserRole.setExpandoBridgeAttributes(esfUserRoleServiceContext);
			esfUserRole.setIsBDO(isBDO);
			esfUserRole.setIsLEA(isLEA);
			esfUserRole.setIsOrgAdmin(isOrgAdmin);
			esfUserRole.setType(type);
			esfUserRole.setMaxUser(maxUser);
			esfUserRole.setIsEditable(isEditable);

			esfUserRolePersistence.update(esfUserRole);

			resourceLocalService.updateResources(
				user.getCompanyId(), groupId, ESFUserRole.class.getName(),
				esfUserRoleId, esfUserRoleServiceContext.getGroupPermissions(),
				esfUserRoleServiceContext.getGroupPermissions());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfUserRole;
	}

	public Role checkNome(String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(name) && !Validator.isBlank(name)) {
			return RoleLocalServiceUtil.fetchRole(
				serviceContext.getCompanyId(), name);
		}

		return null;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFUserRoleNameException();
		}
	}

}
