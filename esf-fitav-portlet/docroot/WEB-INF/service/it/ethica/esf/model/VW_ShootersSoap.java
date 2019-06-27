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

import it.ethica.esf.service.persistence.VW_ShootersPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class VW_ShootersSoap implements Serializable {
	public static VW_ShootersSoap toSoapModel(VW_Shooters model) {
		VW_ShootersSoap soapModel = new VW_ShootersSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setCodiceTessera(model.getCodiceTessera());
		soapModel.setCodiceOrganizzazione(model.getCodiceOrganizzazione());
		soapModel.setNome(model.getNome());
		soapModel.setCognome(model.getCognome());
		soapModel.setEmail(model.getEmail());
		soapModel.setCF(model.getCF());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setInvitato(model.getInvitato());

		return soapModel;
	}

	public static VW_ShootersSoap[] toSoapModels(VW_Shooters[] models) {
		VW_ShootersSoap[] soapModels = new VW_ShootersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_ShootersSoap[][] toSoapModels(VW_Shooters[][] models) {
		VW_ShootersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_ShootersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_ShootersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_ShootersSoap[] toSoapModels(List<VW_Shooters> models) {
		List<VW_ShootersSoap> soapModels = new ArrayList<VW_ShootersSoap>(models.size());

		for (VW_Shooters model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_ShootersSoap[soapModels.size()]);
	}

	public VW_ShootersSoap() {
	}

	public VW_ShootersPK getPrimaryKey() {
		return new VW_ShootersPK(_userId, _organizationId);
	}

	public void setPrimaryKey(VW_ShootersPK pk) {
		setUserId(pk.userId);
		setOrganizationId(pk.organizationId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getCodiceTessera() {
		return _CodiceTessera;
	}

	public void setCodiceTessera(String CodiceTessera) {
		_CodiceTessera = CodiceTessera;
	}

	public String getCodiceOrganizzazione() {
		return _CodiceOrganizzazione;
	}

	public void setCodiceOrganizzazione(String CodiceOrganizzazione) {
		_CodiceOrganizzazione = CodiceOrganizzazione;
	}

	public String getNome() {
		return _Nome;
	}

	public void setNome(String Nome) {
		_Nome = Nome;
	}

	public String getCognome() {
		return _Cognome;
	}

	public void setCognome(String Cognome) {
		_Cognome = Cognome;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getCF() {
		return _CF;
	}

	public void setCF(String CF) {
		_CF = CF;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public int getInvitato() {
		return _invitato;
	}

	public void setInvitato(int invitato) {
		_invitato = invitato;
	}

	private long _userId;
	private String _CodiceTessera;
	private String _CodiceOrganizzazione;
	private String _Nome;
	private String _Cognome;
	private String _Email;
	private String _CF;
	private long _organizationId;
	private int _invitato;
}