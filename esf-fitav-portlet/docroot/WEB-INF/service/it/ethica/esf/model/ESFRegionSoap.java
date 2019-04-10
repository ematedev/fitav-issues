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

import it.ethica.esf.service.persistence.ESFRegionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFRegionSoap implements Serializable {
	public static ESFRegionSoap toSoapModel(ESFRegion model) {
		ESFRegionSoap soapModel = new ESFRegionSoap();

		soapModel.setIdRegion(model.getIdRegion());
		soapModel.setIdCountry(model.getIdCountry());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFRegionSoap[] toSoapModels(ESFRegion[] models) {
		ESFRegionSoap[] soapModels = new ESFRegionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRegionSoap[][] toSoapModels(ESFRegion[][] models) {
		ESFRegionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRegionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRegionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRegionSoap[] toSoapModels(List<ESFRegion> models) {
		List<ESFRegionSoap> soapModels = new ArrayList<ESFRegionSoap>(models.size());

		for (ESFRegion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRegionSoap[soapModels.size()]);
	}

	public ESFRegionSoap() {
	}

	public ESFRegionPK getPrimaryKey() {
		return new ESFRegionPK(_idRegion, _idCountry);
	}

	public void setPrimaryKey(ESFRegionPK pk) {
		setIdRegion(pk.idRegion);
		setIdCountry(pk.idCountry);
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

	private String _idRegion;
	private String _idCountry;
	private String _name;
}