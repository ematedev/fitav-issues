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
public class ESFCodeOrgSoap implements Serializable {
	public static ESFCodeOrgSoap toSoapModel(ESFCodeOrg model) {
		ESFCodeOrgSoap soapModel = new ESFCodeOrgSoap();

		soapModel.setEsfCodeOrgId(model.getEsfCodeOrgId());
		soapModel.setClassName(model.getClassName());
		soapModel.setCode(model.getCode());
		soapModel.setSequence(model.getSequence());

		return soapModel;
	}

	public static ESFCodeOrgSoap[] toSoapModels(ESFCodeOrg[] models) {
		ESFCodeOrgSoap[] soapModels = new ESFCodeOrgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCodeOrgSoap[][] toSoapModels(ESFCodeOrg[][] models) {
		ESFCodeOrgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCodeOrgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCodeOrgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCodeOrgSoap[] toSoapModels(List<ESFCodeOrg> models) {
		List<ESFCodeOrgSoap> soapModels = new ArrayList<ESFCodeOrgSoap>(models.size());

		for (ESFCodeOrg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCodeOrgSoap[soapModels.size()]);
	}

	public ESFCodeOrgSoap() {
	}

	public long getPrimaryKey() {
		return _esfCodeOrgId;
	}

	public void setPrimaryKey(long pk) {
		setEsfCodeOrgId(pk);
	}

	public long getEsfCodeOrgId() {
		return _esfCodeOrgId;
	}

	public void setEsfCodeOrgId(long esfCodeOrgId) {
		_esfCodeOrgId = esfCodeOrgId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getSequence() {
		return _sequence;
	}

	public void setSequence(long sequence) {
		_sequence = sequence;
	}

	private long _esfCodeOrgId;
	private String _className;
	private String _code;
	private long _sequence;
}