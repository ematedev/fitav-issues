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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.impl.ESFShootingDirectorImpl;
import it.ethica.esf.portlet.ESFShootingDirectorPortlet;
import it.ethica.esf.service.base.ESFShootingDirectorLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFShootingDirectorFinderUtil;

/**
 * The implementation of the e s f shooting director local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFShootingDirectorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFShootingDirectorLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil
 */
public class ESFShootingDirectorLocalServiceImpl
	extends ESFShootingDirectorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil} to access the e s f shooting director local service.
	 */
	
	public List<ESFShootingDirector> findByUserId(long esfUserId, int start, int end) 
					throws SystemException{
		List<ESFShootingDirector> shSt = new ArrayList<ESFShootingDirector>();
		shSt = esfShootingDirectorPersistence.findBybyUserId(esfUserId);
		
		if(shSt.size() > end ){
			shSt = shSt.subList(start, end);
		}else{
			shSt = shSt.subList(start, shSt.size());
		}
		
		return shSt;
		
	}
	
	public int countByUserId(long esfUserId) 
					throws SystemException{
		int tot = 0;
		List<ESFShootingDirector> shSt = new ArrayList<ESFShootingDirector>();
		shSt = esfShootingDirectorPersistence.findBybyUserId(esfUserId);
		return tot =shSt.size() ;
		
	}
	
	public ESFShootingDirector findedShDr (long esfUserId , long sdqId, long stId)
				throws SystemException{
		

		ESFShootingDirector shDt = new ESFShootingDirectorImpl();
		shDt = esfShootingDirectorPersistence.fetchBybyUserId_SDQId_STId(esfUserId, sdqId, stId);
		
		return shDt;
	}
	
	public List<ESFShootingDirector> findAll( int start, int end)throws SystemException{
		
		List<ESFShootingDirector> shSt = new ArrayList<ESFShootingDirector>();
		
		shSt = esfShootingDirectorPersistence.findAll(start, end);
		
		return shSt;
	}
	
	public int countTotal()throws SystemException{
		
		int total = 0;
		List<ESFShootingDirector> shSt = new ArrayList<ESFShootingDirector>();
		
		shSt = esfShootingDirectorPersistence.findAll();
		total = shSt.size();
		
		return total;
	}
	
	/**
	 * ricerca i direttori di tiro filtrandoli in base ai parametri
	 * @param lastName
	 * @param firstName
	 * @param cardCode
	 * @param regionId
	 * @param qualificationId
	 * @param sportTypeId
	 * @param start
	 * @param end
	 * @return List<ESFShootingDirector>
	 * @throws SystemException
	 */
	public List<ESFShootingDirector> findShootingDirector(String lastName, String firstName, String cardCode, String regionId,
		long qualificationId, long sportTypeId, int start, int end) throws SystemException{
		
		List<ESFShootingDirector> shDr = new ArrayList<ESFShootingDirector>();
		
		shDr = ESFShootingDirectorFinderUtil.findShootingDirector(lastName, firstName,
			cardCode, regionId, qualificationId, sportTypeId, start, end);
		
		return shDr;
		
	}
	
	/**
	 * conta i direttori di tiro filtrandoli in base ai parametri
	 * @param lastName
	 * @param firstName
	 * @param cardCode
	 * @param regionId
	 * @param qualificationId
	 * @param sportTypeId
	 * @param start
	 * @param end
	 * @return List<ESFShootingDirector>
	 * @throws SystemException
	 */
	public int countShootingDirector(String lastName, String firstName, String cardCode, String regionId,
		long qualificationId, long sportTypeId) throws SystemException{
		
		int tot = 0;
		List<ESFShootingDirector> shDr = new ArrayList<ESFShootingDirector>();
		
		shDr = ESFShootingDirectorFinderUtil.findShootingDirector(lastName, firstName,
			cardCode, regionId, qualificationId, sportTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return shDr.size();
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFShootingDirectorLocalServiceImpl.class);
}