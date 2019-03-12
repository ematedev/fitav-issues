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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.service.base.ESFPhoneLocalServiceBaseImpl;

/**
 * The implementation of the e s f phone local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFPhoneLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFPhoneLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFPhoneLocalServiceUtil
 */
public class ESFPhoneLocalServiceImpl extends ESFPhoneLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFPhoneLocalServiceUtil} to access the e s
	 * f phone local service.
	 */

	public ESFPhone addESFPhone(
		long userId, String className, long classPk, String number,
		String extension, int listTypeId, int typeId, boolean primary,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		Phone phone =
			PhoneLocalServiceUtil.addPhone(
				userId, className, classPk, number, extension, typeId, primary,
				serviceContext);

		long esfPhoneId = phone.getPhoneId();

		ESFPhone esfPhone = esfPhonePersistence.create(esfPhoneId);

		esfPhone.setListTypeId(listTypeId);;
		esfPhonePersistence.update(esfPhone);
		return esfPhone;
	}

	public ESFPhone deleteESFPhone(
		long esfPhoneId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		PhoneLocalServiceUtil.deletePhone(esfPhoneId);

		ESFPhone esfPhone = esfPhonePersistence.remove(esfPhoneId);

		return esfPhone;
	}
	private static Log _log = LogFactoryUtil.getLog(ESFPhone.class);
}
