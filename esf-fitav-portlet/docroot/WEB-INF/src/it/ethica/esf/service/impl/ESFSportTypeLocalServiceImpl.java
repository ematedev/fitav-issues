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
import java.util.HashMap;
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

import it.ethica.esf.ESFSportTypeNameException;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.portlet.ESFSportTypeAdminPortlet;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFSportTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f sport type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFSportTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFSportTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFSportTypeLocalServiceUtil
 */
public class ESFSportTypeLocalServiceImpl
	extends ESFSportTypeLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(ESFSportTypeLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFSportTypeLocalServiceUtil} to access the e s f sport type local service.
	 */

	public List<ESFSportType> getNational(boolean national)
			throws SystemException {
		return esfSportTypePersistence.findByNational(national, false);
	}
	
	public List<ESFSportType> getisOlimpic(boolean isOlimpic)
			throws SystemException {
		return esfSportTypePersistence.findByisOlimpic(isOlimpic);
	}

	public List<ESFSportType> getAllESFSportTypes()
			throws SystemException {
		return esfSportTypePersistence.findAll();
	}

	public List<ESFSportType> getAllESFSportTypes(int start, int end)
			throws SystemException {
		return esfSportTypePersistence.findAll(start, end);
	}

	public List<ESFSportType> getESFSportTypes(long groupId)
			throws SystemException {
		return esfSportTypePersistence.findByGroupId(groupId);
	}
	
	public List<ESFSportType> getESFSportTypesIsChangeCategory(boolean isChangeCategory)
			throws SystemException {
		List<ESFSportType> esfSportType = new ArrayList<ESFSportType>();
		List<ESFSportType> esfSportTypes = esfSportTypePersistence.findAll();
		
		for(ESFSportType SportType : esfSportTypes){
			if(SportType.getIsChangeCategory() == isChangeCategory){
				esfSportType.add(SportType);
			}
		}
		
		return esfSportType;
	}

	public List<ESFSportType> getESFSportTypes(long groupId, int start, int end)
			throws SystemException {
		return esfSportTypePersistence.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId)
			throws SystemException {
		return esfSportTypePersistence.countByGroupId(groupId);
	}
	
	public List<ESFSportType> findByESFFieldId(long esfFieldId)
			throws SystemException, PortalException {

		List<ESFSportType> esfSportTypes = new ArrayList<ESFSportType>();
		
		List<ESFFieldESFSportType> esfFieldEsfSportTypes = 
				esfFieldESFSportTypePersistence.findByesfFieldId(esfFieldId);

		for (ESFFieldESFSportType esfFieldEsfSportType : esfFieldEsfSportTypes) {

			esfSportTypes.add(esfSportTypeLocalService
					.getESFSportType(esfFieldEsfSportType.getEsfSportTypeId()));
		}	
		return esfSportTypes;
	}
	
	public List<ESFSportType> findESFSportTypeByName(String name)
			throws SystemException, PortalException {
		
		DynamicQuery sportTypeQuery = DynamicQueryFactoryUtil.forClass(
				ESFSportType.class, "sportTypeQuery",
				PortletClassLoaderUtil.getClassLoader());

		sportTypeQuery.add(PropertyFactoryUtil.forName("sportTypeQuery.name")
				.like(StringPool.PERCENT + name + StringPool.PERCENT));

		List<ESFSportType> esfSportTypesToSend = ESFSportTypeLocalServiceUtil.dynamicQuery(sportTypeQuery);

		return esfSportTypesToSend;
	}
	
	public ESFSportType addESFSportType(long userId, String name, String code,
			String description, boolean national, boolean isChangeCategory, boolean isOlimpic, ServiceContext serviceContext)
				throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		validate(name);

		long esfSportTypeId = counterLocalService.increment();
		
		ESFSportType esfSportType = esfSportTypePersistence.create(esfSportTypeId);
		
		esfSportType.setUserId(userId);
		esfSportType.setGroupId(groupId);
		esfSportType.setCompanyId(user.getCompanyId());
		esfSportType.setUserName(user.getFullName());
		esfSportType.setCreateDate(serviceContext.getCreateDate(now));
		esfSportType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfSportType.setName(name);
		esfSportType.setCode(code);
		esfSportType.setDescription(description);
		esfSportType.setNational(national);
		esfSportType.setIsChangeCategory(isChangeCategory);
		esfSportType.setIsOlimpic(isOlimpic);
		esfSportType.setExpandoBridgeAttributes(serviceContext);

		esfSportTypePersistence.update(esfSportType);

		/*resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				ESFSportType.class.getName(), esfSportTypeId, false, true, true);*/

		return esfSportType;
	}

	public ESFSportType updateESFSportType(long userId, long esfSportTypeId,
			String name, String code, String description, boolean national, boolean isChangeCategory, boolean isOlimpic,
			ServiceContext serviceContext)
				throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFSportType esfSportType = getESFSportType(esfSportTypeId);
		
		User user = UserLocalServiceUtil.getUser(userId);

		esfSportType.setUserId(userId);
		esfSportType.setUserName(user.getFullName());
		esfSportType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfSportType.setName(name);
		esfSportType.setCode(code);
		esfSportType.setDescription(description);
		esfSportType.setNational(national);
		esfSportType.setIsChangeCategory(isChangeCategory);
		esfSportType.setIsOlimpic(isOlimpic);
		esfSportType.setExpandoBridgeAttributes(serviceContext);

		esfSportTypePersistence.update(esfSportType);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), name, esfSportTypeId,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		return esfSportType;
	}

	public ESFSportType deleteESFSportType(long esfSportTypeId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFSportType esfSportType = getESFSportType(esfSportTypeId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFSportType.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfSportTypeId);

		esfSportType = deleteESFSportType(esfSportTypeId);

		return esfSportType;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ESFSportTypeNameException();
		}
	}
	
	public HashMap<String,Long> findIDSportByName() throws Exception
	{
		HashMap<String,Long> idSportByName = new HashMap<String,Long>();
		List<ESFSportType> allESFSportType = esfSportTypePersistence.findAll();
		for(ESFSportType est:allESFSportType)
		{
			String name = est.getName();
			Long id = est.getEsfSportTypeId();
			idSportByName.put(name, id);
		}
		return idSportByName;
	}
	public long findIDSportByName(String name) throws Exception
	{
		long esfSportId=0;
		List<ESFSportType> allESFSportType = esfSportTypePersistence.findAll();
		for(ESFSportType est:allESFSportType)
		{
			String nameSport = est.getName();
			
			if(nameSport.equalsIgnoreCase(name));
				return est.getEsfSportTypeId();
			
		}
		return esfSportId;
		
	}
	public long findIDSportByCode(String code) throws Exception
	{
		
		List<ESFSportType> esf=esfSportTypePersistence.findByCode(code);
		if (esf.isEmpty())			
			return 0;
		else
			return esf.get(0).getEsfSportTypeId();
		
		
	}
	
}