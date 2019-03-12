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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFAddressSoap implements Serializable {
	public static ESFAddressSoap toSoapModel(ESFAddress model) {
		ESFAddressSoap soapModel = new ESFAddressSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfAddressId(model.getEsfAddressId());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setEsfCountryId(model.getEsfCountryId());
		soapModel.setEsfRegionId(model.getEsfRegionId());
		soapModel.setEsfProvinceId(model.getEsfProvinceId());
		soapModel.setEsfCityId(model.getEsfCityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setType(model.getType());
		soapModel.setIsNotNational(model.getIsNotNational());
		soapModel.setListTypeId(model.getListTypeId());

		return soapModel;
	}

	public static ESFAddressSoap[] toSoapModels(ESFAddress[] models) {
		ESFAddressSoap[] soapModels = new ESFAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFAddressSoap[][] toSoapModels(ESFAddress[][] models) {
		ESFAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFAddressSoap[] toSoapModels(List<ESFAddress> models) {
		List<ESFAddressSoap> soapModels = new ArrayList<ESFAddressSoap>(models.size());

		for (ESFAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFAddressSoap[soapModels.size()]);
	}

	public ESFAddressSoap() {
	}

	public long getPrimaryKey() {
		return _esfAddressId;
	}

	public void setPrimaryKey(long pk) {
		setEsfAddressId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfAddressId() {
		return _esfAddressId;
	}

	public void setEsfAddressId(long esfAddressId) {
		_esfAddressId = esfAddressId;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public String getEsfCountryId() {
		return _esfCountryId;
	}

	public void setEsfCountryId(String esfCountryId) {
		_esfCountryId = esfCountryId;
	}

	public String getEsfRegionId() {
		return _esfRegionId;
	}

	public void setEsfRegionId(String esfRegionId) {
		_esfRegionId = esfRegionId;
	}

	public String getEsfProvinceId() {
		return _esfProvinceId;
	}

	public void setEsfProvinceId(String esfProvinceId) {
		_esfProvinceId = esfProvinceId;
	}

	public long getEsfCityId() {
		return _esfCityId;
	}

	public void setEsfCityId(long esfCityId) {
		_esfCityId = esfCityId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public boolean getIsNotNational() {
		return _isNotNational;
	}

	public boolean isIsNotNational() {
		return _isNotNational;
	}

	public void setIsNotNational(boolean isNotNational) {
		_isNotNational = isNotNational;
	}

	public int getListTypeId() {
		return _listTypeId;
	}

	public void setListTypeId(int listTypeId) {
		_listTypeId = listTypeId;
	}

	private String _uuid;
	private long _esfAddressId;
	private double _longitude;
	private double _latitude;
	private String _esfCountryId;
	private String _esfRegionId;
	private String _esfProvinceId;
	private long _esfCityId;
	private long _groupId;
	private String _type;
	private boolean _isNotNational;
	private int _listTypeId;
}