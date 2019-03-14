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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import it.ethica.esf.model.ESFAnnualConiReport;
import it.ethica.esf.model.impl.ESFAnnualConiReportImpl;
import it.ethica.esf.service.base.ESFAnnualConiReportLocalServiceBaseImpl;

/**
 * The implementation of the e s f annual coni report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFAnnualConiReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFAnnualConiReportLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFAnnualConiReportLocalServiceUtil
 */
public class ESFAnnualConiReportLocalServiceImpl
	extends ESFAnnualConiReportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFAnnualConiReportLocalServiceUtil} to access the e s f annual coni report local service.
	 */
	
	public boolean findAffiliationByYear(long assId, int year) throws SystemException{
		boolean find = false;
		ESFAnnualConiReport annualConiAffiliation = null;
		annualConiAffiliation = esfAnnualConiReportPersistence.fetchByAssYear(assId, year);
		_log.info("annualConiAffiliation="+annualConiAffiliation);
		
		if(Validator.isNotNull(annualConiAffiliation)){
			find = true;
		}
		
		return find;
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFAnnualConiReportLocalServiceImpl.class);
}