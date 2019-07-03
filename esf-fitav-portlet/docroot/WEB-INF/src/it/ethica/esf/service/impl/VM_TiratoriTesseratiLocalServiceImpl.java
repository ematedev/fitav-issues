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

package it.ethica.esf.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.VM_TiratoriTesserati;
import it.ethica.esf.service.base.VM_TiratoriTesseratiLocalServiceBaseImpl;

/**
 * The implementation of the v m_ tiratori tesserati local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.VM_TiratoriTesseratiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.VM_TiratoriTesseratiLocalServiceBaseImpl
 * @see it.ethica.esf.service.VM_TiratoriTesseratiLocalServiceUtil
 */
public class VM_TiratoriTesseratiLocalServiceImpl
	extends VM_TiratoriTesseratiLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.VM_TiratoriTesseratiLocalServiceUtil} to access the v m_ tiratori tesserati local service.
	 */
	
	public List<VM_TiratoriTesserati> findAllTiratori() throws SystemException {
		return vm_TiratoriTesseratiPersistence.findAll();
	}
}