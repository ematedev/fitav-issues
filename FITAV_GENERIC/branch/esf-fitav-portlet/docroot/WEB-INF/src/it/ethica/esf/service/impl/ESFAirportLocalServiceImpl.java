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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFAirport;
import it.ethica.esf.service.ESFAirportLocalServiceUtil;
import it.ethica.esf.service.base.ESFAirportLocalServiceBaseImpl;

/**
 * The implementation of the e s f airport local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFAirportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFAirportLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFAirportLocalServiceUtil
 */
public class ESFAirportLocalServiceImpl extends ESFAirportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFAirportLocalServiceUtil} to access the e s f airport local service.
	 */
	
	public List<ESFAirport> getAllESFAirport() throws SystemException {
		return esfAirportPersistence.findAll();
	}
	

	public List<ESFAirport> getAllESFAirport(int start, int end)
			throws SystemException {
		return esfAirportPersistence.findAll(start, end);
	}
	
	public void adESFAirport(String name,String city,String country) throws SystemException
	{
		ESFAirport esfA = ESFAirportLocalServiceUtil.createESFAirport(
				CounterLocalServiceUtil.increment(ESFAirport.class.getName()));
		esfA.setCity(city);
		esfA.setName(name);
		esfA.setCountry(country);
		ESFAirportLocalServiceUtil.addESFAirport(esfA);
	}
}