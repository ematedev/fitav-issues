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

import it.ethica.esf.service.persistence.ESFRadunoAzzurriPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFRadunoAzzurriSoap implements Serializable {
	public static ESFRadunoAzzurriSoap toSoapModel(ESFRadunoAzzurri model) {
		ESFRadunoAzzurriSoap soapModel = new ESFRadunoAzzurriSoap();

		soapModel.setId_esf_raduno_azzurri(model.getId_esf_raduno_azzurri());
		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setEsfNationalId(model.getEsfNationalId());

		return soapModel;
	}

	public static ESFRadunoAzzurriSoap[] toSoapModels(ESFRadunoAzzurri[] models) {
		ESFRadunoAzzurriSoap[] soapModels = new ESFRadunoAzzurriSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoAzzurriSoap[][] toSoapModels(
		ESFRadunoAzzurri[][] models) {
		ESFRadunoAzzurriSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoAzzurriSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoAzzurriSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoAzzurriSoap[] toSoapModels(
		List<ESFRadunoAzzurri> models) {
		List<ESFRadunoAzzurriSoap> soapModels = new ArrayList<ESFRadunoAzzurriSoap>(models.size());

		for (ESFRadunoAzzurri model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoAzzurriSoap[soapModels.size()]);
	}

	public ESFRadunoAzzurriSoap() {
	}

	public ESFRadunoAzzurriPK getPrimaryKey() {
		return new ESFRadunoAzzurriPK(_id_esf_raduno_azzurri, _id_esf_raduno,
			_esfNationalId);
	}

	public void setPrimaryKey(ESFRadunoAzzurriPK pk) {
		setId_esf_raduno_azzurri(pk.id_esf_raduno_azzurri);
		setId_esf_raduno(pk.id_esf_raduno);
		setEsfNationalId(pk.esfNationalId);
	}

	public long getId_esf_raduno_azzurri() {
		return _id_esf_raduno_azzurri;
	}

	public void setId_esf_raduno_azzurri(long id_esf_raduno_azzurri) {
		_id_esf_raduno_azzurri = id_esf_raduno_azzurri;
	}

	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;
	}

	public long getEsfNationalId() {
		return _esfNationalId;
	}

	public void setEsfNationalId(long esfNationalId) {
		_esfNationalId = esfNationalId;
	}

	private long _id_esf_raduno_azzurri;
	private long _id_esf_raduno;
	private long _esfNationalId;
}