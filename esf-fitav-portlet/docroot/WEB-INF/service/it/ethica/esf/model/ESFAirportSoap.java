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
public class ESFAirportSoap implements Serializable {
	public static ESFAirportSoap toSoapModel(ESFAirport model) {
		ESFAirportSoap soapModel = new ESFAirportSoap();

		soapModel.setEsfAirportId(model.getEsfAirportId());
		soapModel.setName(model.getName());
		soapModel.setCity(model.getCity());
		soapModel.setCountry(model.getCountry());

		return soapModel;
	}

	public static ESFAirportSoap[] toSoapModels(ESFAirport[] models) {
		ESFAirportSoap[] soapModels = new ESFAirportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFAirportSoap[][] toSoapModels(ESFAirport[][] models) {
		ESFAirportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFAirportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFAirportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFAirportSoap[] toSoapModels(List<ESFAirport> models) {
		List<ESFAirportSoap> soapModels = new ArrayList<ESFAirportSoap>(models.size());

		for (ESFAirport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFAirportSoap[soapModels.size()]);
	}

	public ESFAirportSoap() {
	}

	public long getPrimaryKey() {
		return _esfAirportId;
	}

	public void setPrimaryKey(long pk) {
		setEsfAirportId(pk);
	}

	public long getEsfAirportId() {
		return _esfAirportId;
	}

	public void setEsfAirportId(long esfAirportId) {
		_esfAirportId = esfAirportId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	private long _esfAirportId;
	private String _name;
	private String _city;
	private String _country;
}