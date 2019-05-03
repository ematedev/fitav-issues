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

package it.ethica.esf.model;

import it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK;

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
public class VW_ESFListaIncarichiSoap implements Serializable {
	public static VW_ESFListaIncarichiSoap toSoapModel(
		VW_ESFListaIncarichi model) {
		VW_ESFListaIncarichiSoap soapModel = new VW_ESFListaIncarichiSoap();

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

		return soapModel;
	}

	public static VW_ESFListaIncarichiSoap[] toSoapModels(
		VW_ESFListaIncarichi[] models) {
		VW_ESFListaIncarichiSoap[] soapModels = new VW_ESFListaIncarichiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFListaIncarichiSoap[][] toSoapModels(
		VW_ESFListaIncarichi[][] models) {
		VW_ESFListaIncarichiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_ESFListaIncarichiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_ESFListaIncarichiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFListaIncarichiSoap[] toSoapModels(
		List<VW_ESFListaIncarichi> models) {
		List<VW_ESFListaIncarichiSoap> soapModels = new ArrayList<VW_ESFListaIncarichiSoap>(models.size());

		for (VW_ESFListaIncarichi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_ESFListaIncarichiSoap[soapModels.size()]);
	}

	public VW_ESFListaIncarichiSoap() {
	}

	public VW_ESFListaIncarichiPK getPrimaryKey() {
		return new VW_ESFListaIncarichiPK(_AnniPrecedenti, _AnnoFineIncarico,
			_AnnoInizioIncarico, _AnnoCorrente, _NomeRuolo, _startDate,
			_esfUserId, _esfOrganizationId, _lastName, _firstName);
	}

	public void setPrimaryKey(VW_ESFListaIncarichiPK pk) {
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
}