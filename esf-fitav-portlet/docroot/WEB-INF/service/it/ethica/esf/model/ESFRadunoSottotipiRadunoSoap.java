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
public class ESFRadunoSottotipiRadunoSoap implements Serializable {
	public static ESFRadunoSottotipiRadunoSoap toSoapModel(
		ESFRadunoSottotipiRaduno model) {
		ESFRadunoSottotipiRadunoSoap soapModel = new ESFRadunoSottotipiRadunoSoap();

		soapModel.setId_esf_raduno_sottotipi_raduno(model.getId_esf_raduno_sottotipi_raduno());
		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setId_esf_raduno_sottotipo(model.getId_esf_raduno_sottotipo());

		return soapModel;
	}

	public static ESFRadunoSottotipiRadunoSoap[] toSoapModels(
		ESFRadunoSottotipiRaduno[] models) {
		ESFRadunoSottotipiRadunoSoap[] soapModels = new ESFRadunoSottotipiRadunoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSottotipiRadunoSoap[][] toSoapModels(
		ESFRadunoSottotipiRaduno[][] models) {
		ESFRadunoSottotipiRadunoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoSottotipiRadunoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoSottotipiRadunoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoSottotipiRadunoSoap[] toSoapModels(
		List<ESFRadunoSottotipiRaduno> models) {
		List<ESFRadunoSottotipiRadunoSoap> soapModels = new ArrayList<ESFRadunoSottotipiRadunoSoap>(models.size());

		for (ESFRadunoSottotipiRaduno model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoSottotipiRadunoSoap[soapModels.size()]);
	}

	public ESFRadunoSottotipiRadunoSoap() {
	}

	public long getPrimaryKey() {
		return _id_esf_raduno_sottotipi_raduno;
	}

	public void setPrimaryKey(long pk) {
		setId_esf_raduno_sottotipi_raduno(pk);
	}

	public long getId_esf_raduno_sottotipi_raduno() {
		return _id_esf_raduno_sottotipi_raduno;
	}

	public void setId_esf_raduno_sottotipi_raduno(
		long id_esf_raduno_sottotipi_raduno) {
		_id_esf_raduno_sottotipi_raduno = id_esf_raduno_sottotipi_raduno;
	}

	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;
	}

	public long getId_esf_raduno_sottotipo() {
		return _id_esf_raduno_sottotipo;
	}

	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_id_esf_raduno_sottotipo = id_esf_raduno_sottotipo;
	}

	private long _id_esf_raduno_sottotipi_raduno;
	private long _id_esf_raduno;
	private long _id_esf_raduno_sottotipo;
}