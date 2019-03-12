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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.NoSuchConfigurationException;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.base.ESFConfigurationLocalServiceBaseImpl;

/**
 * The implementation of the e s f configuration local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFConfigurationLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFConfigurationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFConfigurationLocalServiceUtil
 */
public class ESFConfigurationLocalServiceImpl
	extends ESFConfigurationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFConfigurationLocalServiceUtil} to access
	 * the e s f configuration local service.
	 */
	public List<ESFConfiguration> getAllEsfConfigurations()
		throws SystemException {

		return esfConfigurationPersistence.findAll();
	}

	public List<ESFConfiguration> getAllEsfConfigurations(int start, int end)
		throws SystemException {

		return esfConfigurationPersistence.findAll(start, end);
	}

	public List<ESFConfiguration> getAllEsfConfigurations(long groupId)
		throws SystemException {

		return esfConfigurationPersistence.findByGroupId(groupId);
	}

	public List<ESFConfiguration> getAllEsfConfigurations(
		long groupId, int start, int end)
		throws SystemException {

		return esfConfigurationPersistence.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId)
		throws SystemException {

		return esfConfigurationPersistence.countByGroupId(groupId);
	}

	public List<ESFConfiguration> findESFConfigurationTypeByKey(String key)
		throws SystemException, PortalException {

		DynamicQuery configurationQuery =
			DynamicQueryFactoryUtil.forClass(
				ESFConfiguration.class, "configurationQuery",
				PortletClassLoaderUtil.getClassLoader());

		configurationQuery.add(PropertyFactoryUtil.forName(
			"configurationQuery.key").like(
			StringPool.PERCENT + key + StringPool.PERCENT));

		List<ESFConfiguration> esfConfigurationsToSend =
			ESFConfigurationLocalServiceUtil.dynamicQuery(configurationQuery);
		return esfConfigurationsToSend;
	}

	public ESFConfiguration addESFConfiguration(
		long userId, String key, String value, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfConfigurationId = counterLocalService.increment();

		ESFConfiguration esfConfiguration =
			esfConfigurationPersistence.create(esfConfigurationId);

		esfConfiguration.setUserId(userId);
		esfConfiguration.setGroupId(groupId);
		esfConfiguration.setCompanyId(user.getCompanyId());
		esfConfiguration.setUserName(user.getFullName());
		esfConfiguration.setCreateDate(serviceContext.getCreateDate(now));
		esfConfiguration.setModifiedDate(serviceContext.getModifiedDate(now));
		esfConfiguration.setKey(key);
		esfConfiguration.setValue(value);

		esfConfigurationPersistence.update(esfConfiguration);

		try {
			resourceLocalService.addResources(
				user.getCompanyId(), groupId, userId,
				ESFConfiguration.class.getName(), esfConfigurationId, false,
				true, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfConfiguration;
	}

	public ESFConfiguration updateESFConfiguration(
		long userId, long esfConfigurationId, String value,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		ESFConfiguration esfConfiguration =
			getESFConfiguration(esfConfigurationId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfConfiguration.setUserId(userId);
		esfConfiguration.setUserName(user.getFullName());
		esfConfiguration.setModifiedDate(serviceContext.getModifiedDate(now));
		esfConfiguration.setValue(value);

		esfConfigurationPersistence.update(esfConfiguration);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			value, esfConfigurationId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return esfConfiguration;
	}

	public ESFConfiguration deleteESFConfiguration(
		long esfConfigurationId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFConfiguration esfConfiguration =
			getESFConfiguration(esfConfigurationId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFConfiguration.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfConfigurationId);

		esfConfiguration = deleteESFConfiguration(esfConfigurationId);
		return esfConfiguration;
	}

	
	public HashMap<String,Integer> findAgeByName() throws Exception{
		HashMap<String,Integer> ageByName = new HashMap<String,Integer>();
		List<ESFConfiguration> allEsfConfiguration =
				(List<ESFConfiguration>) ESFConfigurationLocalServiceUtil.getAllEsfConfigurations();
		for(ESFConfiguration ec: allEsfConfiguration){
			int age = 0;
			boolean validate = true ;
			try {
				Integer.parseInt(ec.getValue());
				
			}catch(NumberFormatException nfe){
				_log.info("errore sulle key");
				validate = false;
			}
			
			if(validate){
			String name= ec.getKey();
			age= Integer.parseInt(ec.getValue());
			ageByName.put(name, age);
			}
		}
		return ageByName;
	}
	
	
	public ESFConfiguration getESFConfigurationByESFKey ( String key)
			throws SystemException, NoSuchConfigurationException {
			ESFConfiguration conf = (ESFConfiguration) esfConfigurationPersistence.findByESFKey(key);
			return conf;
			
		}
	private static Log _log = LogFactoryUtil.getLog(ESFConfigurationLocalServiceImpl.class);
}
