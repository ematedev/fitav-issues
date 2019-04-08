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
public class ESFStateSoap implements Serializable {
	public static ESFStateSoap toSoapModel(ESFState model) {
		ESFStateSoap soapModel = new ESFStateSoap();

		soapModel.setEsfStateId(model.getEsfStateId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFStateSoap[] toSoapModels(ESFState[] models) {
		ESFStateSoap[] soapModels = new ESFStateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFStateSoap[][] toSoapModels(ESFState[][] models) {
		ESFStateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFStateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFStateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFStateSoap[] toSoapModels(List<ESFState> models) {
		List<ESFStateSoap> soapModels = new ArrayList<ESFStateSoap>(models.size());

		for (ESFState model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFStateSoap[soapModels.size()]);
	}

	public ESFStateSoap() {
	}

	public long getPrimaryKey() {
		return _esfStateId;
	}

	public void setPrimaryKey(long pk) {
		setEsfStateId(pk);
	}

	public long getEsfStateId() {
		return _esfStateId;
	}

	public void setEsfStateId(long esfStateId) {
		_esfStateId = esfStateId;
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

	private long _esfStateId;
	private String _name;
	private String _description;
}