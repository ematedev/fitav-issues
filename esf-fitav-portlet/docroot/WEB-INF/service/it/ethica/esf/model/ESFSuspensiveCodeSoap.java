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
public class ESFSuspensiveCodeSoap implements Serializable {
	public static ESFSuspensiveCodeSoap toSoapModel(ESFSuspensiveCode model) {
		ESFSuspensiveCodeSoap soapModel = new ESFSuspensiveCodeSoap();

		soapModel.setEsfSuspensiveCodeId(model.getEsfSuspensiveCodeId());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFSuspensiveCodeSoap[] toSoapModels(
		ESFSuspensiveCode[] models) {
		ESFSuspensiveCodeSoap[] soapModels = new ESFSuspensiveCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFSuspensiveCodeSoap[][] toSoapModels(
		ESFSuspensiveCode[][] models) {
		ESFSuspensiveCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFSuspensiveCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFSuspensiveCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFSuspensiveCodeSoap[] toSoapModels(
		List<ESFSuspensiveCode> models) {
		List<ESFSuspensiveCodeSoap> soapModels = new ArrayList<ESFSuspensiveCodeSoap>(models.size());

		for (ESFSuspensiveCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFSuspensiveCodeSoap[soapModels.size()]);
	}

	public ESFSuspensiveCodeSoap() {
	}

	public long getPrimaryKey() {
		return _esfSuspensiveCodeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfSuspensiveCodeId(pk);
	}

	public long getEsfSuspensiveCodeId() {
		return _esfSuspensiveCodeId;
	}

	public void setEsfSuspensiveCodeId(long esfSuspensiveCodeId) {
		_esfSuspensiveCodeId = esfSuspensiveCodeId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _esfSuspensiveCodeId;
	private String _code;
	private String _description;
}