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

import it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class VW_DatiDrettoreTiroSoap implements Serializable {
	public static VW_DatiDrettoreTiroSoap toSoapModel(VW_DatiDrettoreTiro model) {
		VW_DatiDrettoreTiroSoap soapModel = new VW_DatiDrettoreTiroSoap();

		soapModel.setEsfShootingDirectorId(model.getEsfShootingDirectorId());
		soapModel.setNome(model.getNome());
		soapModel.setCognome(model.getCognome());
		soapModel.setCodiceRegione(model.getCodiceRegione());

		return soapModel;
	}

	public static VW_DatiDrettoreTiroSoap[] toSoapModels(
		VW_DatiDrettoreTiro[] models) {
		VW_DatiDrettoreTiroSoap[] soapModels = new VW_DatiDrettoreTiroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_DatiDrettoreTiroSoap[][] toSoapModels(
		VW_DatiDrettoreTiro[][] models) {
		VW_DatiDrettoreTiroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_DatiDrettoreTiroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_DatiDrettoreTiroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_DatiDrettoreTiroSoap[] toSoapModels(
		List<VW_DatiDrettoreTiro> models) {
		List<VW_DatiDrettoreTiroSoap> soapModels = new ArrayList<VW_DatiDrettoreTiroSoap>(models.size());

		for (VW_DatiDrettoreTiro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_DatiDrettoreTiroSoap[soapModels.size()]);
	}

	public VW_DatiDrettoreTiroSoap() {
	}

	public VW_DatiDrettoreTiroPK getPrimaryKey() {
		return new VW_DatiDrettoreTiroPK(_esfShootingDirectorId, _Nome,
			_Cognome, _CodiceRegione);
	}

	public void setPrimaryKey(VW_DatiDrettoreTiroPK pk) {
		setEsfShootingDirectorId(pk.esfShootingDirectorId);
		setNome(pk.Nome);
		setCognome(pk.Cognome);
		setCodiceRegione(pk.CodiceRegione);
	}

	public long getEsfShootingDirectorId() {
		return _esfShootingDirectorId;
	}

	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_esfShootingDirectorId = esfShootingDirectorId;
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

	public String getCodiceRegione() {
		return _CodiceRegione;
	}

	public void setCodiceRegione(String CodiceRegione) {
		_CodiceRegione = CodiceRegione;
	}

	private long _esfShootingDirectorId;
	private String _Nome;
	private String _Cognome;
	private String _CodiceRegione;
}