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

package com.ethica.esf.service.impl;

import com.ethica.esf.model.ESFStockist;
import com.ethica.esf.service.base.ESFStockistLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s f stockist local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFStockistLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFStockistLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFStockistLocalServiceUtil
 */
public class ESFStockistLocalServiceImpl
	extends ESFStockistLocalServiceBaseImpl {

	@Override
	public ESFStockist addESFStockist(
		String name, String email, String phone, String address,
		String nameReference, String lastNameReference, String emailReference,
		String phoneReference, String description, String other)
		throws PortalException, SystemException {

		long esfStockistId = counterLocalService.increment();
		ESFStockist esfStockist = esfStockistPersistence.create(esfStockistId);
		esfStockist.setName(name);
		esfStockist.setEmail(email);
		esfStockist.setPhone(phone);
		esfStockist.setAddress(address);
		esfStockist.setNameReference(nameReference);
		esfStockist.setEmailReference(emailReference);
		esfStockist.setPhoneReference(phoneReference);
		esfStockist.setLastNameReference(lastNameReference);
		esfStockist.setDescription(description);
		esfStockist.setOther(other);

		esfStockistPersistence.update(esfStockist);

		return esfStockist;
	}

	@Override
	public ESFStockist updateESFStockist(
		long esfStockistId, String name, String email, String phone,
		String address, String nameReference, String lastNameReference,
		String emailReference, String phoneReference, String description,
		String other)
		throws PortalException, SystemException {

		ESFStockist esfStockist = getESFStockist(esfStockistId);

		esfStockist.setName(name);
		esfStockist.setEmail(email);
		esfStockist.setPhone(phone);
		esfStockist.setAddress(address);
		esfStockist.setNameReference(nameReference);
		esfStockist.setEmailReference(emailReference);
		esfStockist.setPhoneReference(phoneReference);
		esfStockist.setLastNameReference(lastNameReference);
		esfStockist.setDescription(description);
		esfStockist.setOther(other);

		esfStockistPersistence.update(esfStockist);

		return esfStockist;
	}
}
