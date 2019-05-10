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

package it.ethica.esf.renewal.model;

import it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class VW_ESFListaIncarichiTesseraSoap implements Serializable {
	public static VW_ESFListaIncarichiTesseraSoap toSoapModel(
		VW_ESFListaIncarichiTessera model) {
		VW_ESFListaIncarichiTesseraSoap soapModel = new VW_ESFListaIncarichiTesseraSoap();

		soapModel.setAnniPrecedenti(model.getAnniPrecedenti());
		soapModel.setAnnoFineIncarico(model.getAnnoFineIncarico());
		soapModel.setAnnoInizioIncarico(model.getAnnoInizioIncarico());
		soapModel.setAnnoCorrente(model.getAnnoCorrente());
		soapModel.setNomeRuolo(model.getNomeRuolo());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setLastName(model.getLastName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setCodiceTessera(model.getCodiceTessera());
		soapModel.setDataTesseramento(model.getDataTesseramento());
<<<<<<< HEAD
		soapModel.setCodiceFiscale(model.getCodiceFiscale());
=======
>>>>>>> origin/master

		return soapModel;
	}

	public static VW_ESFListaIncarichiTesseraSoap[] toSoapModels(
		VW_ESFListaIncarichiTessera[] models) {
		VW_ESFListaIncarichiTesseraSoap[] soapModels = new VW_ESFListaIncarichiTesseraSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFListaIncarichiTesseraSoap[][] toSoapModels(
		VW_ESFListaIncarichiTessera[][] models) {
		VW_ESFListaIncarichiTesseraSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_ESFListaIncarichiTesseraSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_ESFListaIncarichiTesseraSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFListaIncarichiTesseraSoap[] toSoapModels(
		List<VW_ESFListaIncarichiTessera> models) {
		List<VW_ESFListaIncarichiTesseraSoap> soapModels = new ArrayList<VW_ESFListaIncarichiTesseraSoap>(models.size());

		for (VW_ESFListaIncarichiTessera model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_ESFListaIncarichiTesseraSoap[soapModels.size()]);
	}

	public VW_ESFListaIncarichiTesseraSoap() {
	}

	public VW_ESFListaIncarichiTesseraPK getPrimaryKey() {
		return new VW_ESFListaIncarichiTesseraPK(_AnniPrecedenti,
			_AnnoFineIncarico, _AnnoInizioIncarico, _AnnoCorrente, _NomeRuolo,
			_startDate, _esfUserId, _esfOrganizationId, _lastName, _firstName);
	}

	public void setPrimaryKey(VW_ESFListaIncarichiTesseraPK pk) {
		setAnniPrecedenti(pk.AnniPrecedenti);
		setAnnoFineIncarico(pk.AnnoFineIncarico);
		setAnnoInizioIncarico(pk.AnnoInizioIncarico);
		setAnnoCorrente(pk.AnnoCorrente);
		setNomeRuolo(pk.NomeRuolo);
		setStartDate(pk.startDate);
		setEsfUserId(pk.esfUserId);
		setEsfOrganizationId(pk.esfOrganizationId);
		setLastName(pk.lastName);
		setFirstName(pk.firstName);
	}

	public int getAnniPrecedenti() {
		return _AnniPrecedenti;
	}

	public void setAnniPrecedenti(int AnniPrecedenti) {
		_AnniPrecedenti = AnniPrecedenti;
	}

	public int getAnnoFineIncarico() {
		return _AnnoFineIncarico;
	}

	public void setAnnoFineIncarico(int AnnoFineIncarico) {
		_AnnoFineIncarico = AnnoFineIncarico;
	}

	public int getAnnoInizioIncarico() {
		return _AnnoInizioIncarico;
	}

	public void setAnnoInizioIncarico(int AnnoInizioIncarico) {
		_AnnoInizioIncarico = AnnoInizioIncarico;
	}

	public int getAnnoCorrente() {
		return _AnnoCorrente;
	}

	public void setAnnoCorrente(int AnnoCorrente) {
		_AnnoCorrente = AnnoCorrente;
	}

	public String getNomeRuolo() {
		return _NomeRuolo;
	}

	public void setNomeRuolo(String NomeRuolo) {
		_NomeRuolo = NomeRuolo;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getCodiceTessera() {
		return _CodiceTessera;
	}

	public void setCodiceTessera(String CodiceTessera) {
		_CodiceTessera = CodiceTessera;
	}

	public Date getDataTesseramento() {
		return _DataTesseramento;
	}

	public void setDataTesseramento(Date DataTesseramento) {
		_DataTesseramento = DataTesseramento;
	}

<<<<<<< HEAD
	public String getCodiceFiscale() {
		return _CodiceFiscale;
	}

	public void setCodiceFiscale(String CodiceFiscale) {
		_CodiceFiscale = CodiceFiscale;
	}

=======
>>>>>>> origin/master
	private int _AnniPrecedenti;
	private int _AnnoFineIncarico;
	private int _AnnoInizioIncarico;
	private int _AnnoCorrente;
	private String _NomeRuolo;
	private Date _endDate;
	private Date _startDate;
	private long _esfUserId;
	private long _esfOrganizationId;
	private String _lastName;
	private String _firstName;
	private String _CodiceTessera;
	private Date _DataTesseramento;
<<<<<<< HEAD
	private String _CodiceFiscale;
=======
>>>>>>> origin/master
}