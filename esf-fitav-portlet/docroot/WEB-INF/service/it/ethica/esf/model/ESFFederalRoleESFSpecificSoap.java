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

import it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.ethica.esf.service.http.ESFFederalRoleESFSpecificServiceSoap}.
 *
 * @author Ethica
 * @see it.ethica.esf.service.http.ESFFederalRoleESFSpecificServiceSoap
 * @generated
 */
public class ESFFederalRoleESFSpecificSoap implements Serializable {
	public static ESFFederalRoleESFSpecificSoap toSoapModel(
		ESFFederalRoleESFSpecific model) {
		ESFFederalRoleESFSpecificSoap soapModel = new ESFFederalRoleESFSpecificSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfSpecificId(model.getEsfSpecificId());
		soapModel.setEsfFederalRoleId(model.getEsfFederalRoleId());

		return soapModel;
	}

	public static ESFFederalRoleESFSpecificSoap[] toSoapModels(
		ESFFederalRoleESFSpecific[] models) {
		ESFFederalRoleESFSpecificSoap[] soapModels = new ESFFederalRoleESFSpecificSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFederalRoleESFSpecificSoap[][] toSoapModels(
		ESFFederalRoleESFSpecific[][] models) {
		ESFFederalRoleESFSpecificSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFederalRoleESFSpecificSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFederalRoleESFSpecificSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFederalRoleESFSpecificSoap[] toSoapModels(
		List<ESFFederalRoleESFSpecific> models) {
		List<ESFFederalRoleESFSpecificSoap> soapModels = new ArrayList<ESFFederalRoleESFSpecificSoap>(models.size());

		for (ESFFederalRoleESFSpecific model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFederalRoleESFSpecificSoap[soapModels.size()]);
	}

	public ESFFederalRoleESFSpecificSoap() {
	}

	public ESFFederalRoleESFSpecificPK getPrimaryKey() {
		return new ESFFederalRoleESFSpecificPK(_esfSpecificId, _esfFederalRoleId);
	}

	public void setPrimaryKey(ESFFederalRoleESFSpecificPK pk) {
		setEsfSpecificId(pk.esfSpecificId);
		setEsfFederalRoleId(pk.esfFederalRoleId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfSpecificId() {
		return _esfSpecificId;
	}

	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecificId = esfSpecificId;
	}

	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleId = esfFederalRoleId;
	}

	private String _uuid;
	private long _esfSpecificId;
	private long _esfFederalRoleId;
}