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

import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.NoSuchMatchTypeException;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFMatchTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f match type local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFMatchTypeLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFMatchTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFMatchTypeLocalServiceUtil
 */
public class ESFMatchTypeLocalServiceImpl
	extends ESFMatchTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFMatchTypeLocalServiceUtil} to access the
	 * e s f match type local service.
	 */

	public List<ESFMatchType> findAll()
		throws SystemException {

		return esfMatchTypePersistence.findAll();
	}

	public List<ESFMatchType> findAllByNational(boolean isNational)
		throws SystemException {

		return esfMatchTypePersistence.findByIsNational(isNational);
	}
	
	public List<ESFMatchType> findByDescription(String description)
			throws SystemException {
		List<ESFMatchType> matcTypes = null;
		try {
			 matcTypes = (List<ESFMatchType>) esfMatchTypePersistence.findByfindByDescription(description);
		} catch (NoSuchMatchTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matcTypes;
	}

	public ESFMatchType addEsfMatchType(
		String name, boolean isCategoryQualification,
			boolean isNational, ServiceContext serviceContext)
		throws SystemException {

		long matchTypeId = counterLocalService.increment();

		ESFMatchType esfMatchType =
			esfMatchTypeLocalService.createESFMatchType(matchTypeId);

		esfMatchType.setName(name);
		esfMatchType.setIsCategoryQualification(isCategoryQualification);
		esfMatchType.setIsNational(isNational);
		
		esfMatchTypeLocalService.updateESFMatchType(esfMatchType);

		return esfMatchType;
	}

	public ESFMatchType updateEsfMatchType(
		long matchTypeId, String name,
		boolean isCategoryQualification, boolean isNational, 
		ServiceContext serviceContext)
		throws SystemException {

		ESFMatchType esfMatchType =
			esfMatchTypeLocalService.fetchESFMatchType(matchTypeId);

		esfMatchType.setName(name);
		esfMatchType.setIsCategoryQualification(isCategoryQualification);
		esfMatchType.setIsNational(isNational);
		
		ESFMatchTypeLocalServiceUtil.updateESFMatchType(esfMatchType);

		return esfMatchType;
	}

	public ESFMatchType deleteEsfMatchType(long matchTypeId)
		throws SystemException {

		ESFMatchType esfMatchType = null;
		try {
			esfMatchType = ESFMatchTypeLocalServiceUtil.deleteESFMatchType(matchTypeId);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		return esfMatchType;
	}
	
	public HashMap<String, Long> allIdMatchTypeFromName() throws Exception
	{
		HashMap <String,Long> allMatchTypeFromName = new HashMap<String,Long>();
		List<ESFMatchType> allMatchType =  esfMatchTypePersistence.findAll();
		for(ESFMatchType emt:allMatchType)
		{
			String name = emt.getName();
			long id = emt.getEsfMatchTypeId();
			allMatchTypeFromName.put(name,id);
		}
		return allMatchTypeFromName;
	}
	

}
