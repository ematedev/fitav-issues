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
public class ESFElectronicSoap implements Serializable {
	public static ESFElectronicSoap toSoapModel(ESFElectronic model) {
		ESFElectronicSoap soapModel = new ESFElectronicSoap();

		soapModel.setElectronicId(model.getElectronicId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFElectronicSoap[] toSoapModels(ESFElectronic[] models) {
		ESFElectronicSoap[] soapModels = new ESFElectronicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFElectronicSoap[][] toSoapModels(ESFElectronic[][] models) {
		ESFElectronicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFElectronicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFElectronicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFElectronicSoap[] toSoapModels(List<ESFElectronic> models) {
		List<ESFElectronicSoap> soapModels = new ArrayList<ESFElectronicSoap>(models.size());

		for (ESFElectronic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFElectronicSoap[soapModels.size()]);
	}

	public ESFElectronicSoap() {
	}

	public long getPrimaryKey() {
		return _electronicId;
	}

	public void setPrimaryKey(long pk) {
		setElectronicId(pk);
	}

	public long getElectronicId() {
		return _electronicId;
	}

	public void setElectronicId(long electronicId) {
		_electronicId = electronicId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _electronicId;
	private String _name;
	private String _description;
}