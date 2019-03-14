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
public class ESFUserSoap implements Serializable {
	public static ESFUserSoap toSoapModel(ESFUser model) {
		ESFUserSoap soapModel = new ESFUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCode(model.getCode());

		return soapModel;
	}

	public static ESFUserSoap[] toSoapModels(ESFUser[] models) {
		ESFUserSoap[] soapModels = new ESFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[][] toSoapModels(ESFUser[][] models) {
		ESFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[] toSoapModels(List<ESFUser> models) {
		List<ESFUserSoap> soapModels = new ArrayList<ESFUserSoap>(models.size());

		for (ESFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserSoap[soapModels.size()]);
	}

	public ESFUserSoap() {
	}

	public long getPrimaryKey() {
		return _esfUserId;
	}

	public void setPrimaryKey(long pk) {
		setEsfUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	private String _uuid;
	private long _esfUserId;
	private String _code;
}