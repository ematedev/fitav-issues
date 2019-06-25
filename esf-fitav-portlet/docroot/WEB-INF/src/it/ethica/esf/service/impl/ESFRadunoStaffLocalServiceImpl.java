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

import it.ethica.esf.NoSuchRadunoAzzurriException;
import it.ethica.esf.NoSuchRadunoStaffException;
import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.ESFRadunoStaff;
import it.ethica.esf.model.impl.ESFRadunoAzzurriImpl;
import it.ethica.esf.model.impl.ESFRadunoStaffImpl;
import it.ethica.esf.service.base.ESFRadunoStaffLocalServiceBaseImpl;

/**
 * The implementation of the e s f raduno staff local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFRadunoStaffLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFRadunoStaffLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFRadunoStaffLocalServiceUtil
 */
public class ESFRadunoStaffLocalServiceImpl
	extends ESFRadunoStaffLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFRadunoStaffLocalServiceUtil} to access the e s f raduno staff local service.
	 */
	
	public List<ESFRadunoStaff> findById(long id_esf_raduno) throws SystemException{
		List<ESFRadunoStaff> listaRadunoStaff = null;
		
		listaRadunoStaff = esfRadunoStaffPersistence.findByfindByIdRaduno(id_esf_raduno);
		
		return listaRadunoStaff;
	}
	
	public void associaStaff(long id_esf_raduno, List<String> listaChecked, List<String> listaUnchecked) throws SystemException, NumberFormatException{
		
		if(id_esf_raduno == 0)
			return;
		
		if(listaChecked == null)
			return;
		
		if(listaUnchecked == null)
			return;
		
		for(String idUnchecked : listaUnchecked){
			
			long userId = Long.valueOf(idUnchecked);
			try {
				esfRadunoStaffPersistence.removeByfindRadunoStaff(id_esf_raduno, userId);
			} catch (NoSuchRadunoStaffException e) {
				// TODO Auto-generated catch block
				System.out.println("CANCELLO LA RIGA n. " + idUnchecked);
				//e.printStackTrace();
			}
		}
		
		for(String idChecked : listaChecked){
			long userId = Long.valueOf(idChecked);
			
			//ESFRadunoAzzurri raFetched;
			try {
				esfRadunoStaffPersistence.findByfindRadunoStaff(id_esf_raduno, userId);
			} catch (NoSuchRadunoStaffException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				ESFRadunoStaff rsNew = new ESFRadunoStaffImpl();
				rsNew.setId_esf_raduno(id_esf_raduno);
				rsNew.setUserId(userId);
				
				this.addESFRadunoStaff(rsNew);
				System.out.println("INSERISCO LA RIGA n. " + userId);
			}
			
		}		
	}

}