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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchRadunoException;
import it.ethica.esf.model.ESFRaduno;
import it.ethica.esf.model.ESFRadunoFiles;
import it.ethica.esf.model.ESFRadunoSottotipiRaduno;
import it.ethica.esf.model.ESFRadunoSottotipo;
import it.ethica.esf.model.impl.ESFRadunoImpl;
import it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoImpl;
import it.ethica.esf.service.ESFRadunoLocalServiceUtil;
import it.ethica.esf.service.ESFRadunoSottotipiRadunoLocalServiceUtil;
import it.ethica.esf.service.base.ESFRadunoLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFRadunoPersistence;
import it.ethica.esf.service.persistence.ESFRadunoPersistenceImpl;
import it.ethica.esf.service.persistence.ESFRadunoSottotipiRadunoPersistence;
import it.ethica.esf.service.persistence.ESFRadunoSottotipoUtil;
import it.ethica.esf.service.persistence.ESFRadunoUtil;
import it.ethica.esf.util.DateUtilFormatter;
import it.ethica.esf.util.MissingDateException;

/**
 * The implementation of the e s f raduno local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFRadunoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFRadunoLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFRadunoLocalServiceUtil
 */
public class ESFRadunoLocalServiceImpl extends ESFRadunoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFRadunoLocalServiceUtil} to access the e s f raduno local service.
	 */
	
	public List<ESFRaduno> findAllRaduni() throws SystemException {

			return esfRadunoPersistence.findAll();
		}
	
	public int countAllRaduni() throws SystemException {
		return esfRadunoPersistence.countAll();
		
	}
	
	
	public ESFRaduno findById(long id_esf_raduno) throws SystemException, NoSuchRadunoException {
		ESFRaduno raduno = null;

		raduno = esfRadunoPersistence.findByPrimaryKey(id_esf_raduno);
		
		return raduno;
	}

	
	/**
	 * Funzione che inserisce un nuovo raduno
	 * interessa le tabelle esfraduno, esfradunosottotipiraduno
	 * @param id_esf_raduno
	 * @return
	 * @throws NoSuchRadunoException
	 * @throws SystemException
	 */
	public ESFRaduno inserisciRaduno(ESFRaduno esfRaduno, String[] valoriSottoTipiScelti) throws NoSuchRadunoException, SystemException {
		ESFRaduno raduno = null;
		
		raduno = this.addESFRaduno(esfRaduno);
		String code = new SimpleDateFormat("YYYY").format(new Date());
		long id_esf_raduno = raduno.getId_esf_raduno();
		String codiceCompleto = code + "_" + String.valueOf(id_esf_raduno);
		raduno.setCodice(codiceCompleto);
		raduno = esfRadunoPersistence.update(raduno);
		
		for (String id_esf_raduno_sottotipo : valoriSottoTipiScelti) {
			ESFRadunoSottotipiRaduno radunoSottotipiRaduno = new ESFRadunoSottotipiRadunoImpl();
			radunoSottotipiRaduno.setId_esf_raduno(raduno.getId_esf_raduno());
			radunoSottotipiRaduno.setId_esf_raduno_sottotipo(Long.parseLong(id_esf_raduno_sottotipo));
			//esfRadunoSottotipiRadunoPersistence.
			ESFRadunoSottotipiRadunoLocalServiceUtil.addESFRadunoSottotipiRaduno(radunoSottotipiRaduno);
		}
		
		return raduno;
	}
	
	public ESFRaduno aggiornaRaduno(ESFRaduno esfRaduno, String[] valoriSottoTipiScelti) throws NoSuchRadunoException, SystemException {
		ESFRaduno raduno = null;
		
		esfRadunoPersistence.update(esfRaduno);
		esfRadunoSottotipiRadunoPersistence.removeByfindByIdEsfRaduno(esfRaduno.getId_esf_raduno());
		
		for (String id_esf_raduno_sottotipo : valoriSottoTipiScelti) {
			ESFRadunoSottotipiRaduno radunoSottotipiRaduno = new ESFRadunoSottotipiRadunoImpl();
			radunoSottotipiRaduno.setId_esf_raduno(esfRaduno.getId_esf_raduno());
			radunoSottotipiRaduno.setId_esf_raduno_sottotipo(Long.parseLong(id_esf_raduno_sottotipo));
			//esfRadunoSottotipiRadunoPersistence.
			ESFRadunoSottotipiRadunoLocalServiceUtil.addESFRadunoSottotipiRaduno(radunoSottotipiRaduno);
		}
		
		return raduno;
	}

	
	public ESFRaduno cancellaRaduno(long id_esf_raduno) throws NoSuchRadunoException, SystemException{
		ESFRaduno raduno = null;
		
		esfRadunoSottotipiRadunoPersistence.removeByfindByIdEsfRaduno(id_esf_raduno);
		
		List<ESFRadunoFiles> listaFiles = esfRadunoFilesPersistence.findByfindByRaduno(id_esf_raduno);
		
		for (ESFRadunoFiles file : listaFiles){
			File fileDaCancellare = FileUtils.getFile(file.getPath());
			if(fileDaCancellare == null)
				continue;
			FileUtils.deleteQuietly(fileDaCancellare);
		}
		
		esfRadunoFilesPersistence.removeByfindByRaduno(id_esf_raduno);
		
		raduno = esfRadunoPersistence.remove(id_esf_raduno);
		
		return raduno;
	}

}