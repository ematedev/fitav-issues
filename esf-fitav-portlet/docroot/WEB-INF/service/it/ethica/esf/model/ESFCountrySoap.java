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
public class ESFCountrySoap implements Serializable {
	public static ESFCountrySoap toSoapModel(ESFCountry model) {
		ESFCountrySoap soapModel = new ESFCountrySoap();

		soapModel.setIdCountry(model.getIdCountry());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFCountrySoap[] toSoapModels(ESFCountry[] models) {
		ESFCountrySoap[] soapModels = new ESFCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCountrySoap[][] toSoapModels(ESFCountry[][] models) {
		ESFCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCountrySoap[] toSoapModels(List<ESFCountry> models) {
		List<ESFCountrySoap> soapModels = new ArrayList<ESFCountrySoap>(models.size());

		for (ESFCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCountrySoap[soapModels.size()]);
	}

	public ESFCountrySoap() {
	}

	public String getPrimaryKey() {
		return _idCountry;
	}

	public void setPrimaryKey(String pk) {
		setIdCountry(pk);
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

	private String _idCountry;
	private String _name;
}