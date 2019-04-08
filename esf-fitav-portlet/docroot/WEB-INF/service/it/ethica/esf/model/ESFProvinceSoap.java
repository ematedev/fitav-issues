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

import it.ethica.esf.service.persistence.ESFProvincePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFProvinceSoap implements Serializable {
	public static ESFProvinceSoap toSoapModel(ESFProvince model) {
		ESFProvinceSoap soapModel = new ESFProvinceSoap();

		soapModel.setIdProvince(model.getIdProvince());
		soapModel.setIdRegion(model.getIdRegion());
		soapModel.setIdCountry(model.getIdCountry());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFProvinceSoap[] toSoapModels(ESFProvince[] models) {
		ESFProvinceSoap[] soapModels = new ESFProvinceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFProvinceSoap[][] toSoapModels(ESFProvince[][] models) {
		ESFProvinceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFProvinceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFProvinceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFProvinceSoap[] toSoapModels(List<ESFProvince> models) {
		List<ESFProvinceSoap> soapModels = new ArrayList<ESFProvinceSoap>(models.size());

		for (ESFProvince model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFProvinceSoap[soapModels.size()]);
	}

	public ESFProvinceSoap() {
	}

	public ESFProvincePK getPrimaryKey() {
		return new ESFProvincePK(_idProvince, _idRegion, _idCountry);
	}

	public void setPrimaryKey(ESFProvincePK pk) {
		setIdProvince(pk.idProvince);
		setIdRegion(pk.idRegion);
		setIdCountry(pk.idCountry);
	}

	public String getIdProvince() {
		return _idProvince;
	}

	public void setIdProvince(String idProvince) {
		_idProvince = idProvince;
	}

	public String getIdRegion() {
		return _idRegion;
	}

	public void setIdRegion(String idRegion) {
		_idRegion = idRegion;
	}

	public String getIdCountry() {
		return _idCountry;
	}

	public void setIdCountry(String idCountry) {
		_idCountry = idCountry;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _idProvince;
	private String _idRegion;
	private String _idCountry;
	private String _name;
}