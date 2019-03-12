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
import java.util.List;

//import org.docx4j.docProps.variantTypes.Array;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.service.base.ESFFieldESFSportTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f field e s f sport type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFFieldESFSportTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFieldESFSportTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFieldESFSportTypeLocalServiceUtil
 */
public class ESFFieldESFSportTypeLocalServiceImpl
	extends ESFFieldESFSportTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFFieldESFSportTypeLocalServiceUtil} to access the e s f field e s f sport type local service.
	 */
	
	public List<ESFFieldESFSportType> findByesfFieldId(long fieldId)
					throws SystemException {
		List<ESFFieldESFSportType> fieldSportType = new ArrayList<ESFFieldESFSportType>();
		
		fieldSportType = esfFieldESFSportTypePersistence.findByesfFieldId(fieldId);
		return fieldSportType;
		
	}
}