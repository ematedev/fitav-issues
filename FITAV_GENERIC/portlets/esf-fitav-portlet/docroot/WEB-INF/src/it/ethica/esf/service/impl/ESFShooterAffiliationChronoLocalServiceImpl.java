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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import org.docx4j.docProps.variantTypes.Array;



import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalService;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;
import it.ethica.esf.service.base.ESFShooterAffiliationChronoLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFShooterAffiliationChronoFinderUtil;
import it.ethica.esf.service.persistence.ESFUserFinderUtil;

/**
 * The implementation of the e s f shooter affiliation chrono local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFShooterAffiliationChronoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFShooterAffiliationChronoLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil
 */
public class ESFShooterAffiliationChronoLocalServiceImpl
	extends ESFShooterAffiliationChronoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil} to access the e s f shooter affiliation chrono local service.
	 */
	
	/*
	 * 
	 * ricerca se il tiratore è già stato tesserato per l'anno attuale
	 */
	
	public boolean affiliated (long shooterId, int year)
					throws SystemException {
		
			boolean affiliated = false;
			
			List<ESFShooterAffiliationChrono> chrono = new ArrayList<ESFShooterAffiliationChrono>();
			chrono = esfShooterAffiliationChronoPersistence.findByUserIdYear(shooterId, year);
			if(0 < chrono.size()){
				affiliated = true;
			}
			return affiliated;
	}
	
	public List<ESFShooterAffiliationChrono> findbyDate(Date data, int start, int end)throws SystemException {
		
		List<ESFShooterAffiliationChrono> chrono = new ArrayList<ESFShooterAffiliationChrono>();
		chrono = esfShooterAffiliationChronoPersistence.findByDate(data);
		
		if(end < chrono.size()){
			chrono = chrono.subList(start, end);
			
		}else{
			chrono = chrono.subList(start, chrono.size());
		}
		
		return chrono;
	}
	
	public int countByDate(Date data)throws SystemException {
		
		int tot = 0;
		
		List<ESFShooterAffiliationChrono> chrono = new ArrayList<ESFShooterAffiliationChrono>();
		chrono = esfShooterAffiliationChronoPersistence.findByDate(data);
		
		tot = chrono.size();
		return tot;
		
	}
	
	
	public List<ESFShooterAffiliationChrono> findChronobyDate(String data, int start, int end)throws SystemException {
		
		List<ESFShooterAffiliationChrono> chrono = new ArrayList<ESFShooterAffiliationChrono>();
		chrono = ESFShooterAffiliationChronoFinderUtil.findByData(data, start, end);
		
		return chrono;
	}
	public List<ESFShooterAffiliationChrono> findChronobyCardAndYear(String card, int year)throws SystemException {
		
		List<ESFShooterAffiliationChrono> chrono = new ArrayList<ESFShooterAffiliationChrono>();
			chrono = esfShooterAffiliationChronoPersistence.findByCardYear(card, year);
			
			return chrono;
		}
	public int countChronoByDate(String data)throws SystemException {
		int tot = 0;
		
		tot = ESFShooterAffiliationChronoFinderUtil.findByData(data);
		return tot;
		
	}

	public int countShooterByYear(String startDateStr, String organizationCode)
			throws SystemException, PortalException {
		int tot = 0;
		tot = ESFShooterAffiliationChronoFinderUtil.shooterByYear(startDateStr, organizationCode).size();
	
		return tot ;
	}
	
	public int countShooterThisYear(String startDateStr, String organizationCode)
			throws SystemException, PortalException {
		int tot = 0;
		tot = ESFShooterAffiliationChronoFinderUtil.shooterThisYear(startDateStr, organizationCode).size();
	
		return tot ;
	}
}