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

import it.ethica.esf.service.persistence.vw_datidirettoretiroPK;

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
public class vw_datidirettoretiroSoap implements Serializable {
	public static vw_datidirettoretiroSoap toSoapModel(
		vw_datidirettoretiro model) {
		vw_datidirettoretiroSoap soapModel = new vw_datidirettoretiroSoap();

		soapModel.setEsfshootingdirectorid(model.getEsfshootingdirectorid());
		soapModel.setNome(model.getNome());
		soapModel.setCognome(model.getCognome());
		soapModel.setEsfstartdata(model.getEsfstartdata());
		soapModel.setCategoryid(model.getCategoryid());
		soapModel.setNumerotessera(model.getNumerotessera());
		soapModel.setCodiceregione(model.getCodiceregione());

		return soapModel;
	}

	public static vw_datidirettoretiroSoap[] toSoapModels(
		vw_datidirettoretiro[] models) {
		vw_datidirettoretiroSoap[] soapModels = new vw_datidirettoretiroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static vw_datidirettoretiroSoap[][] toSoapModels(
		vw_datidirettoretiro[][] models) {
		vw_datidirettoretiroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new vw_datidirettoretiroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new vw_datidirettoretiroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static vw_datidirettoretiroSoap[] toSoapModels(
		List<vw_datidirettoretiro> models) {
		List<vw_datidirettoretiroSoap> soapModels = new ArrayList<vw_datidirettoretiroSoap>(models.size());

		for (vw_datidirettoretiro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new vw_datidirettoretiroSoap[soapModels.size()]);
	}

	public vw_datidirettoretiroSoap() {
	}

	public vw_datidirettoretiroPK getPrimaryKey() {
		return new vw_datidirettoretiroPK(_esfshootingdirectorid, _nome,
			_cognome, _esfstartdata, _categoryid, _numerotessera, _codiceregione);
	}

	public void setPrimaryKey(vw_datidirettoretiroPK pk) {
		setEsfshootingdirectorid(pk.esfshootingdirectorid);
		setNome(pk.nome);
		setCognome(pk.cognome);
		setEsfstartdata(pk.esfstartdata);
		setCategoryid(pk.categoryid);
		setNumerotessera(pk.numerotessera);
		setCodiceregione(pk.codiceregione);
	}

	public long getEsfshootingdirectorid() {
		return _esfshootingdirectorid;
	}

	public void setEsfshootingdirectorid(long esfshootingdirectorid) {
		_esfshootingdirectorid = esfshootingdirectorid;
	}

	public long getNome() {
		return _nome;
	}

	public void setNome(long nome) {
		_nome = nome;
	}

	public long getCognome() {
		return _cognome;
	}

	public void setCognome(long cognome) {
		_cognome = cognome;
	}

	public Date getEsfstartdata() {
		return _esfstartdata;
	}

	public void setEsfstartdata(Date esfstartdata) {
		_esfstartdata = esfstartdata;
	}

	public long getCategoryid() {
		return _categoryid;
	}

	public void setCategoryid(long categoryid) {
		_categoryid = categoryid;
	}

	public long getNumerotessera() {
		return _numerotessera;
	}

	public void setNumerotessera(long numerotessera) {
		_numerotessera = numerotessera;
	}

	public long getCodiceregione() {
		return _codiceregione;
	}

	public void setCodiceregione(long codiceregione) {
		_codiceregione = codiceregione;
	}

	private long _esfshootingdirectorid;
	private long _nome;
	private long _cognome;
	private Date _esfstartdata;
	private long _categoryid;
	private long _numerotessera;
	private long _codiceregione;
}