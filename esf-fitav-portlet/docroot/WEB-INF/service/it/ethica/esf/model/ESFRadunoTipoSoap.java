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
public class ESFRadunoTipoSoap implements Serializable {
	public static ESFRadunoTipoSoap toSoapModel(ESFRadunoTipo model) {
		ESFRadunoTipoSoap soapModel = new ESFRadunoTipoSoap();

		soapModel.setId_esf_raduno_tipo(model.getId_esf_raduno_tipo());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static ESFRadunoTipoSoap[] toSoapModels(ESFRadunoTipo[] models) {
		ESFRadunoTipoSoap[] soapModels = new ESFRadunoTipoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoTipoSoap[][] toSoapModels(ESFRadunoTipo[][] models) {
		ESFRadunoTipoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoTipoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoTipoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoTipoSoap[] toSoapModels(List<ESFRadunoTipo> models) {
		List<ESFRadunoTipoSoap> soapModels = new ArrayList<ESFRadunoTipoSoap>(models.size());

		for (ESFRadunoTipo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoTipoSoap[soapModels.size()]);
	}

	public ESFRadunoTipoSoap() {
	}

	public long getPrimaryKey() {
		return _id_esf_raduno_tipo;
	}

	public void setPrimaryKey(long pk) {
		setId_esf_raduno_tipo(pk);
	}

	public long getId_esf_raduno_tipo() {
		return _id_esf_raduno_tipo;
	}

	public void setId_esf_raduno_tipo(long id_esf_raduno_tipo) {
		_id_esf_raduno_tipo = id_esf_raduno_tipo;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id_esf_raduno_tipo;
	private String _descrizione;
}