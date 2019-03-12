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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.ESFGunKindNameException;
import it.ethica.esf.NoSuchGunTypeException;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFGunKindLocalServiceBaseImpl;

/**
 * The implementation of the e s f gun kind local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFGunKindLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFGunKindLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFGunKindLocalServiceUtil
 */
public class ESFGunKindLocalServiceImpl extends ESFGunKindLocalServiceBaseImpl {

	public List<ESFGunKind> getESFGunKindsByLikeN_D_M(
		String name, String description, String model, long esfGunTypeId) {

		List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();

		try {

			DynamicQuery gunkindQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGunKind.class, "gunkindQuery",
					PortletClassLoaderUtil.getClassLoader());

			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.name").like(
				StringPool.PERCENT + name + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.description").like(
				StringPool.PERCENT + description + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.model").like(
				StringPool.PERCENT + model + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.esfGunTypeId").eq(esfGunTypeId));

			esfGunKinds = ESFGunKindLocalServiceUtil.dynamicQuery(gunkindQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGunKinds;
	}
	
	public List<ESFGunKind> getESFGunKindsByLikeN_D_M(
		String name, String description, String model, long esfGunTypeId,
		int start, int end) {

		List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();

		try {

			DynamicQuery gunkindQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGunKind.class, "gunkindQuery",
					PortletClassLoaderUtil.getClassLoader());

			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.name").like(
				StringPool.PERCENT + name + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.description").like(
				StringPool.PERCENT + description + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.model").like(
				StringPool.PERCENT + model + StringPool.PERCENT));
			gunkindQuery.add(PropertyFactoryUtil.forName("gunkindQuery.esfGunTypeId").eq(esfGunTypeId));
			
			esfGunKinds = ESFGunKindLocalServiceUtil.dynamicQuery(gunkindQuery, start, end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGunKinds;
	}
	
	public List<ESFGunKind> getESFGunKinds()
		throws SystemException {

		return esfGunKindPersistence.findAll();
	}

	public List<ESFGunKind> getESFGunKinds(int start, int end)
		throws SystemException {

		return esfGunKindPersistence.findAll(start, end);
	}

	public List<ESFGunKind> getESFGunKindsByESFGunType(long esfGunTypeId)
		throws SystemException {
		
		List<ESFGunKind> gunKinds = new ArrayList<ESFGunKind>();
		if(esfGunTypeId > 0){
			gunKinds = esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId);
		}else{
			gunKinds = ESFGunKindLocalServiceUtil.getESFGunKinds();
		}
		return gunKinds;
	}

	public ESFGunKind getESFGunKindsById(long esfGunKindId)
		throws SystemException {

		return esfGunKindPersistence.fetchByEsfGunKindId(esfGunKindId);
	}

	public List<ESFGunKind> getESFGunKindsByESFGunType(
		long esfGunTypeId, int start, int end)
		throws SystemException {

		List<ESFGunKind> gunKinds = new ArrayList<ESFGunKind>();
		if(esfGunTypeId > 0){
			gunKinds = esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId);
		}else{
			gunKinds = ESFGunKindLocalServiceUtil.getESFGunKinds();
		}
		
		if(end > gunKinds.size()){
			end = gunKinds.size();
		}
		
		return gunKinds.subList(start, end);
	}
	
	public List<ESFGunKind> getESFRifle( int start, int end)
			throws SystemException, NoSuchGunTypeException {
		
		List<ESFGunKind> gunKinds = new ArrayList<ESFGunKind>();
		List<ESFGunType> gunTypes = new ArrayList<ESFGunType>();
		gunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
		
		for(ESFGunType gunType :  gunTypes){
			gunKinds.addAll(ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(gunType.getEsfGunTypeId()));
			
		}
		if(end > gunKinds.size()){
			end = gunKinds.size();
		}
		
		
		return gunKinds.subList(start, end);
	}
	
	public int countESFRifle( )throws SystemException, NoSuchGunTypeException {
		
		int tot = 0;
		List<ESFGunKind> gunKinds = new ArrayList<ESFGunKind>();
		List<ESFGunType> gunTypes = new ArrayList<ESFGunType>();
		gunTypes = ESFGunTypeLocalServiceUtil.getisCatridgeProductor(false);
		
		for(ESFGunType gunType :  gunTypes){
			gunKinds.addAll(ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(gunType.getEsfGunTypeId()));
			
		}
		tot = gunKinds.size();
		
		
		return tot;
	}
	

	public int getESFGunKindCountByESFGunType(long esfGunTypeId)
		throws SystemException {

		return esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId).size();
	}

	public ESFGunKind addESFGunKind(
		long userId, String name, String description, 
		long esfGunTypeId,ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		//validate(name);
		long esfGunKindId = counterLocalService.increment();
		ESFGunKind esfGunKind = esfGunKindPersistence.create(esfGunKindId);
		esfGunKind.setUserId(userId);
		esfGunKind.setGroupId(groupId);
		esfGunKind.setCompanyId(user.getCompanyId());
		esfGunKind.setUserName(user.getFullName());
		esfGunKind.setCreateDate(serviceContext.getCreateDate(now));
		esfGunKind.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunKind.setName(name);
		esfGunKind.setDescription(description);
		esfGunKind.setEsfGunTypeId(esfGunTypeId);
		
		esfGunKind.setExpandoBridgeAttributes(serviceContext);
		esfGunKindPersistence.update(esfGunKind);
		
		/*resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFGunKind.class.getName(),
			esfGunKindId, false, true, true);*/
		
		return esfGunKind;

	}

	public ESFGunKind updateESFGunKind(
		long userId, long esfGunKindId, String name, String description, long esfGunTypeId, 
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFGunKind esfGunKind = getESFGunKind(esfGunKindId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfGunKind.setUserId(userId);
		esfGunKind.setUserName(user.getFullName());
		esfGunKind.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunKind.setName(name);
		esfGunKind.setDescription(description);
		esfGunKind.setEsfGunTypeId(esfGunTypeId);
		esfGunKind.setExpandoBridgeAttributes(serviceContext);
		
		esfGunKindPersistence.update(esfGunKind);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfGunKindId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return esfGunKind;
	}

	public ESFGunKind deleteESFGunKind(
		long esfGunKindId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFGunKind esfGunKind = getESFGunKind(esfGunKindId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFGunKind.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfGunKindId);

		esfGunKind = deleteESFGunKind(esfGunKindId);

		return esfGunKind;
	}

	public ESFGunKind checkNome(String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(name) && !Validator.isBlank(name)) {
			return esfGunKindPersistence.fetchByname(name);
		}

		return null;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFGunKindNameException();
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ESFGunKindLocalServiceImpl.class);
}
