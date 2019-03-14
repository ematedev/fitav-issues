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
public class ESFShootingDirectorQualificationSoap implements Serializable {
	public static ESFShootingDirectorQualificationSoap toSoapModel(
		ESFShootingDirectorQualification model) {
		ESFShootingDirectorQualificationSoap soapModel = new ESFShootingDirectorQualificationSoap();

		soapModel.setEsfShootingDirectorQualificationId(model.getEsfShootingDirectorQualificationId());
		soapModel.setEsfShootingDirectorQualificationDesc(model.getEsfShootingDirectorQualificationDesc());

		return soapModel;
	}

	public static ESFShootingDirectorQualificationSoap[] toSoapModels(
		ESFShootingDirectorQualification[] models) {
		ESFShootingDirectorQualificationSoap[] soapModels = new ESFShootingDirectorQualificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFShootingDirectorQualificationSoap[][] toSoapModels(
		ESFShootingDirectorQualification[][] models) {
		ESFShootingDirectorQualificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFShootingDirectorQualificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFShootingDirectorQualificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFShootingDirectorQualificationSoap[] toSoapModels(
		List<ESFShootingDirectorQualification> models) {
		List<ESFShootingDirectorQualificationSoap> soapModels = new ArrayList<ESFShootingDirectorQualificationSoap>(models.size());

		for (ESFShootingDirectorQualification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFShootingDirectorQualificationSoap[soapModels.size()]);
	}

	public ESFShootingDirectorQualificationSoap() {
	}

	public long getPrimaryKey() {
		return _esfShootingDirectorQualificationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfShootingDirectorQualificationId(pk);
	}

	public long getEsfShootingDirectorQualificationId() {
		return _esfShootingDirectorQualificationId;
	}

	public void setEsfShootingDirectorQualificationId(
		long esfShootingDirectorQualificationId) {
		_esfShootingDirectorQualificationId = esfShootingDirectorQualificationId;
	}

	public String getEsfShootingDirectorQualificationDesc() {
		return _esfShootingDirectorQualificationDesc;
	}

	public void setEsfShootingDirectorQualificationDesc(
		String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationDesc;
	}

	private long _esfShootingDirectorQualificationId;
	private String _esfShootingDirectorQualificationDesc;
}