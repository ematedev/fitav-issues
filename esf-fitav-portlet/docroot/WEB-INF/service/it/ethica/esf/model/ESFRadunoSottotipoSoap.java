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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFRadunoSottotipoSoap implements Serializable {
	public static ESFRadunoSottotipoSoap toSoapModel(ESFRadunoSottotipo model) {
		ESFRadunoSottotipoSoap soapModel = new ESFRadunoSottotipoSoap();

		soapModel.setId_esf_raduno_sottotipo(model.getId_esf_raduno_sottotipo());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static ESFRadunoSottotipoSoap[] toSoapModels(
		ESFRadunoSottotipo[] models) {
		ESFRadunoSottotipoSoap[] soapModels = new ESFRadunoSottotipoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSottotipoSoap[][] toSoapModels(
		ESFRadunoSottotipo[][] models) {
		ESFRadunoSottotipoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoSottotipoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoSottotipoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSottotipoSoap[] toSoapModels(
		List<ESFRadunoSottotipo> models) {
		List<ESFRadunoSottotipoSoap> soapModels = new ArrayList<ESFRadunoSottotipoSoap>(models.size());

		for (ESFRadunoSottotipo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoSottotipoSoap[soapModels.size()]);
	}

	public ESFRadunoSottotipoSoap() {
	}

	public long getPrimaryKey() {
		return _id_esf_raduno_sottotipo;
	}

	public void setPrimaryKey(long pk) {
		setId_esf_raduno_sottotipo(pk);
	}

	public long getId_esf_raduno_sottotipo() {
		return _id_esf_raduno_sottotipo;
	}

	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_id_esf_raduno_sottotipo = id_esf_raduno_sottotipo;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_esf_raduno_sottotipo;
	private String _descrizione;
}