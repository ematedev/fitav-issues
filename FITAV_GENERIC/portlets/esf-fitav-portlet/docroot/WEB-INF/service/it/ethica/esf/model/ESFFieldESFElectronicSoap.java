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
public class ESFFieldESFElectronicSoap implements Serializable {
	public static ESFFieldESFElectronicSoap toSoapModel(
		ESFFieldESFElectronic model) {
		ESFFieldESFElectronicSoap soapModel = new ESFFieldESFElectronicSoap();

		soapModel.setId(model.getId());
		soapModel.setBrandId(model.getBrandId());
		soapModel.setElectronicId(model.getElectronicId());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFFieldESFElectronicSoap[] toSoapModels(
		ESFFieldESFElectronic[] models) {
		ESFFieldESFElectronicSoap[] soapModels = new ESFFieldESFElectronicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldESFElectronicSoap[][] toSoapModels(
		ESFFieldESFElectronic[][] models) {
		ESFFieldESFElectronicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFieldESFElectronicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFieldESFElectronicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldESFElectronicSoap[] toSoapModels(
		List<ESFFieldESFElectronic> models) {
		List<ESFFieldESFElectronicSoap> soapModels = new ArrayList<ESFFieldESFElectronicSoap>(models.size());

		for (ESFFieldESFElectronic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFieldESFElectronicSoap[soapModels.size()]);
	}

	public ESFFieldESFElectronicSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getBrandId() {
		return _brandId;
	}

	public void setBrandId(long brandId) {
		_brandId = brandId;
	}

	public long getElectronicId() {
		return _electronicId;
	}

	public void setElectronicId(long electronicId) {
		_electronicId = electronicId;
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private long _brandId;
	private long _electronicId;
	private long _fieldId;
	private String _description;
}