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
public class ESFRadunoSoap implements Serializable {
	public static ESFRadunoSoap toSoapModel(ESFRaduno model) {
		ESFRadunoSoap soapModel = new ESFRadunoSoap();

		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setCodice(model.getCodice());
		soapModel.setData_inizio(model.getData_inizio());
		soapModel.setData_fine(model.getData_fine());
		soapModel.setTipo_raduno(model.getTipo_raduno());
		soapModel.setId_sottotipo_raduno(model.getId_sottotipo_raduno());
		soapModel.setNote(model.getNote());
		soapModel.setId_associazione_ospitante(model.getId_associazione_ospitante());
		soapModel.setAltra_sede_ospitante(model.getAltra_sede_ospitante());

		return soapModel;
	}

	public static ESFRadunoSoap[] toSoapModels(ESFRaduno[] models) {
		ESFRadunoSoap[] soapModels = new ESFRadunoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSoap[][] toSoapModels(ESFRaduno[][] models) {
		ESFRadunoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSoap[] toSoapModels(List<ESFRaduno> models) {
		List<ESFRadunoSoap> soapModels = new ArrayList<ESFRadunoSoap>(models.size());

		for (ESFRaduno model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoSoap[soapModels.size()]);
	}

	public ESFRadunoSoap() {
	}

	public long getPrimaryKey() {
		return _id_esf_raduno;
	}

	public void setPrimaryKey(long pk) {
		setId_esf_raduno(pk);
	}

	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;
	}

	public String getCodice() {
		return _codice;
	}

	public void setCodice(String codice) {
		_codice = codice;
	}

	public Date getData_inizio() {
		return _data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		_data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return _data_fine;
	}

	public void setData_fine(Date data_fine) {
		_data_fine = data_fine;
	}

	public long getTipo_raduno() {
		return _tipo_raduno;
	}

	public void setTipo_raduno(long tipo_raduno) {
		_tipo_raduno = tipo_raduno;
	}

	public long getId_sottotipo_raduno() {
		return _id_sottotipo_raduno;
	}

	public void setId_sottotipo_raduno(long id_sottotipo_raduno) {
		_id_sottotipo_raduno = id_sottotipo_raduno;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getId_associazione_ospitante() {
		return _id_associazione_ospitante;
	}

	public void setId_associazione_ospitante(long id_associazione_ospitante) {
		_id_associazione_ospitante = id_associazione_ospitante;
	}

	public String getAltra_sede_ospitante() {
		return _altra_sede_ospitante;
	}

	public void setAltra_sede_ospitante(String altra_sede_ospitante) {
		_altra_sede_ospitante = altra_sede_ospitante;
	}

	private long _id_esf_raduno;
	private String _codice;
	private Date _data_inizio;
	private Date _data_fine;
	private long _tipo_raduno;
	private long _id_sottotipo_raduno;
	private String _note;
	private long _id_associazione_ospitante;
	private String _altra_sede_ospitante;
}