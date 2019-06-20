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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchRadunoAzzurriException;
import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.impl.ESFRadunoAzzurriImpl;
import it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil;
import it.ethica.esf.service.base.ESFRadunoAzzurriLocalServiceBaseImpl;

/**
 * The implementation of the e s f raduno azzurri local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFRadunoAzzurriLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFRadunoAzzurriLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil
 */
public class ESFRadunoAzzurriLocalServiceImpl
	extends ESFRadunoAzzurriLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil} to access the e s f raduno azzurri local service.
	 */
	
	public void associaAzzurri(long id_esf_raduno, List<String> listaChecked, List<String> listaUnchecked) throws SystemException, NumberFormatException{
		
		if(id_esf_raduno == 0)
			return;
		
		if(listaChecked == null)
			return;
		
		if(listaUnchecked == null)
			return;
		
		for(String idUnchecked : listaUnchecked){
			
			long esfNationalId = Long.valueOf(idUnchecked);
			try {
				esfRadunoAzzurriPersistence.removeByfindRadunoAzzurri(id_esf_raduno, esfNationalId);
			} catch (NoSuchRadunoAzzurriException e) {
				// TODO Auto-generated catch block
				System.out.println("CANCELLO LA RIGA n. " + idUnchecked);
				//e.printStackTrace();
			}
		}
		
		for(String idChecked : listaChecked){
			long esfNationalId = Long.valueOf(idChecked);
			
			//ESFRadunoAzzurri raFetched;
			try {
				esfRadunoAzzurriPersistence.findByfindRadunoAzzurri(id_esf_raduno, esfNationalId);
			} catch (NoSuchRadunoAzzurriException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				ESFRadunoAzzurri raNew = new ESFRadunoAzzurriImpl();
				raNew.setId_esf_raduno(id_esf_raduno);
				raNew.setEsfNationalId(esfNationalId);
				
				this.addESFRadunoAzzurri(raNew);
				System.out.println("INSERISCO LA RIGA n. " + esfNationalId);
			}
			
		}		
	}
	
}