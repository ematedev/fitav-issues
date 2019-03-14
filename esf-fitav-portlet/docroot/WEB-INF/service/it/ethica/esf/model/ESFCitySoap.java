/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import it.ethica.esf.service.persistence.ESFCityPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFCitySoap implements Serializable {
	public static ESFCitySoap toSoapModel(ESFCity model) {
		ESFCitySoap soapModel = new ESFCitySoap();

		soapModel.setIdCity(model.getIdCity());
		soapModel.setIdProvince(model.getIdProvince());
		soapModel.setIdRegion(model.getIdRegion());
		soapModel.setIdCountry(model.getIdCountry());
		soapModel.setZip(model.getZip());
		soapModel.setName(model.getName());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setAltitude(model.getAltitude());
		soapModel.setWebsite(model.getWebsite());

		return soapModel;
	}

	public static ESFCitySoap[] toSoapModels(ESFCity[] models) {
		ESFCitySoap[] soapModels = new ESFCitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCitySoap[][] toSoapModels(ESFCity[][] models) {
		ESFCitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCitySoap[] toSoapModels(List<ESFCity> models) {
		List<ESFCitySoap> soapModels = new ArrayList<ESFCitySoap>(models.size());

		for (ESFCity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCitySoap[soapModels.size()]);
	}

	public ESFCitySoap() {
	}

	public ESFCityPK getPrimaryKey() {
		return new ESFCityPK(_idCity, _idProvince, _idRegion, _idCountry);
	}

	public void setPrimaryKey(ESFCityPK pk) {
		setIdCity(pk.idCity);
		setIdProvince(pk.idProvince);
		setIdRegion(pk.idRegion);
		setIdCountry(pk.idCountry);
	}

	public long getIdCity() {
		return _idCity;
	}

	public void setIdCity(long idCity) {
		_idCity = idCity;
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

	public long getZip() {
		return _zip;
	}

	public void setZip(long zip) {
		_zip = zip;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public double getAltitude() {
		return _altitude;
	}

	public void setAltitude(double altitude) {
		_altitude = altitude;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	private long _idCity;
	private String _idProvince;
	private String _idRegion;
	private String _idCountry;
	private long _zip;
	private String _name;
	private double _latitude;
	private double _longitude;
	private double _altitude;
	private String _website;
}