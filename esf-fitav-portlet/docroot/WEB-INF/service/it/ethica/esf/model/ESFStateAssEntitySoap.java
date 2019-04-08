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

import it.ethica.esf.service.persistence.ESFStateAssEntityPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFStateAssEntitySoap implements Serializable {
	public static ESFStateAssEntitySoap toSoapModel(ESFStateAssEntity model) {
		ESFStateAssEntitySoap soapModel = new ESFStateAssEntitySoap();

		soapModel.setEsfStateId(model.getEsfStateId());
		soapModel.setClassName(model.getClassName());

		return soapModel;
	}

	public static ESFStateAssEntitySoap[] toSoapModels(
		ESFStateAssEntity[] models) {
		ESFStateAssEntitySoap[] soapModels = new ESFStateAssEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFStateAssEntitySoap[][] toSoapModels(
		ESFStateAssEntity[][] models) {
		ESFStateAssEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFStateAssEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFStateAssEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFStateAssEntitySoap[] toSoapModels(
		List<ESFStateAssEntity> models) {
		List<ESFStateAssEntitySoap> soapModels = new ArrayList<ESFStateAssEntitySoap>(models.size());

		for (ESFStateAssEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFStateAssEntitySoap[soapModels.size()]);
	}

	public ESFStateAssEntitySoap() {
	}

	public ESFStateAssEntityPK getPrimaryKey() {
		return new ESFStateAssEntityPK(_esfStateId, _className);
	}

	public void setPrimaryKey(ESFStateAssEntityPK pk) {
		setEsfStateId(pk.esfStateId);
		setClassName(pk.className);
	}

	public long getEsfStateId() {
		return _esfStateId;
	}

	public void setEsfStateId(long esfStateId) {
		_esfStateId = esfStateId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	private long _esfStateId;
	private String _className;
}