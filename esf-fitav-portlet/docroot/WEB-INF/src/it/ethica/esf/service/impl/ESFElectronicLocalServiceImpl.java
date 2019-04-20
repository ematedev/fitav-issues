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

import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.service.base.ESFElectronicLocalServiceBaseImpl;

/**
 * The implementation of the e s f electronic local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFElectronicLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFElectronicLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFElectronicLocalServiceUtil
 */
public class ESFElectronicLocalServiceImpl
	extends ESFElectronicLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFElectronicLocalServiceUtil} to access the
	 * e s f electronic local service.
	 */

	public List<ESFElectronic> findAll() throws SystemException{
	
		return esfElectronicPersistence.findAll();
	}
	
	public ESFElectronic addEsfElectronic(
		String name, String description, ServiceContext serviceContext)
		throws SystemException {

		long electronicId = counterLocalService.increment();

		ESFElectronic esfElectronic =
			esfElectronicLocalService.createESFElectronic(electronicId);

		esfElectronic.setName(name);
		esfElectronic.setDescription(description);

		esfElectronicLocalService.updateESFElectronic(esfElectronic);

		return esfElectronic;
	}

	public ESFElectronic updateEsfElectronic(
		long electronicId, String name, String description,
		ServiceContext serviceContext)
		throws SystemException {

		ESFElectronic esfElectronic =
			esfElectronicLocalService.fetchESFElectronic(electronicId);

		esfElectronic.setName(name);
		esfElectronic.setDescription(description);

		esfElectronicLocalService.updateESFElectronic(esfElectronic);

		return esfElectronic;
	}

	public ESFElectronic deleteEsfElectronic(
		long electronicId, ServiceContext serviceContext)
		throws SystemException {

		ESFElectronic esfElectronic =
			esfElectronicLocalService.fetchESFElectronic(electronicId);

		esfElectronicLocalService.deleteESFElectronic(esfElectronic);

		return esfElectronic;
	}
}
