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
public class ESFPartecipantTypeSoap implements Serializable {
	public static ESFPartecipantTypeSoap toSoapModel(ESFPartecipantType model) {
		ESFPartecipantTypeSoap soapModel = new ESFPartecipantTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfPartecipantTypeId(model.getEsfPartecipantTypeId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFPartecipantTypeSoap[] toSoapModels(
		ESFPartecipantType[] models) {
		ESFPartecipantTypeSoap[] soapModels = new ESFPartecipantTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantTypeSoap[][] toSoapModels(
		ESFPartecipantType[][] models) {
		ESFPartecipantTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFPartecipantTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFPartecipantTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantTypeSoap[] toSoapModels(
		List<ESFPartecipantType> models) {
		List<ESFPartecipantTypeSoap> soapModels = new ArrayList<ESFPartecipantTypeSoap>(models.size());

		for (ESFPartecipantType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFPartecipantTypeSoap[soapModels.size()]);
	}

	public ESFPartecipantTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfPartecipantTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfPartecipantTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfPartecipantTypeId() {
		return _esfPartecipantTypeId;
	}

	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantTypeId = esfPartecipantTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private long _esfPartecipantTypeId;
	private String _name;
}