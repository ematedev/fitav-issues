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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFFieldESFElectronic;
import it.ethica.esf.service.base.ESFFieldESFElectronicLocalServiceBaseImpl;

/**
 * The implementation of the e s f field e s f electronic local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFFieldESFElectronicLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFieldESFElectronicLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil
 */
public class ESFFieldESFElectronicLocalServiceImpl
	extends ESFFieldESFElectronicLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil} to
	 * access the e s f field e s f electronic local service.
	 */
	
	public List<ESFFieldESFElectronic> findByFieldId(long fieldId)
		throws SystemException {
	
		List<ESFFieldESFElectronic> esfFieldESFElectronic =
			esfFieldESFElectronicPersistence.findByFieldId(fieldId);
		
		return esfFieldESFElectronic;
	}
	
	public List<ESFFieldESFElectronic> findByBrandId(long brandId)
		throws SystemException {
	
		List<ESFFieldESFElectronic> esfFieldESFElectronic =
			esfFieldESFElectronicPersistence.findByBrandId(brandId);
		
		return esfFieldESFElectronic;
	}
	
	public ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws SystemException {
	
		ESFFieldESFElectronic esfFieldESFElectronic =
			esfFieldESFElectronicPersistence.fetchByFieldIdBrandIdElectronicId(
				fieldId, brandId, electronicId);
		
		return esfFieldESFElectronic;
	}
	
	public List<ESFFieldESFElectronic> findByElectronicId(long electronicId)
		throws SystemException {
	
		List<ESFFieldESFElectronic> esfFieldESFElectronic =
			esfFieldESFElectronicPersistence.findByElectronicId(electronicId);
		
		return esfFieldESFElectronic;
	}
	
	public ESFFieldESFElectronic addESFFieldESFElectronic(
		long brandId, long electronicId, long fieldId, String description,
		ServiceContext serviceContext)
		throws SystemException {
	
		long esfFieldESFElectronicId = counterLocalService.increment();
		
		ESFFieldESFElectronic esfFieldESFElectronic =
			esfFieldESFElectronicPersistence.create(esfFieldESFElectronicId);
		
		esfFieldESFElectronic.setBrandId(brandId);
		esfFieldESFElectronic.setElectronicId(electronicId);
		esfFieldESFElectronic.setFieldId(fieldId);
		esfFieldESFElectronic.setDescription(description);
		
		esfFieldESFElectronicPersistence.update(esfFieldESFElectronic);
		
		return esfFieldESFElectronic;
	}
	
	public ESFFieldESFElectronic updateESFFieldESFElectronic(
		long esfFieldESFElectronicId, long brandId, long electronicId,
		long fieldId, String description, ServiceContext serviceContext)
		throws SystemException {
	
		ESFFieldESFElectronic esfFieldESFElectronic =
			esfFieldESFElectronicLocalService.fetchESFFieldESFElectronic(esfFieldESFElectronicId);
		
		esfFieldESFElectronic.setBrandId(brandId);
		esfFieldESFElectronic.setElectronicId(electronicId);
		esfFieldESFElectronic.setFieldId(fieldId);
		esfFieldESFElectronic.setDescription(description);
		
		esfFieldESFElectronicPersistence.update(esfFieldESFElectronic);
		
		return esfFieldESFElectronic;
	}
	
	public ESFFieldESFElectronic deleteESFFieldESFElectronic(
		long esfFieldESFElectronicId, ServiceContext serviceContext)
		throws SystemException {
	
		ESFFieldESFElectronic esfFieldESFElectronic =
			esfFieldESFElectronicLocalService.fetchESFFieldESFElectronic(esfFieldESFElectronicId);
		
		esfFieldESFElectronicPersistence.remove(esfFieldESFElectronic);
		
		return esfFieldESFElectronic;
	}
}
