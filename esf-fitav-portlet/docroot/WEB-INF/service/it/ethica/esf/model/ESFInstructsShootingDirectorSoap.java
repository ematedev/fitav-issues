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
public class ESFInstructsShootingDirectorSoap implements Serializable {
	public static ESFInstructsShootingDirectorSoap toSoapModel(
		ESFInstructsShootingDirector model) {
		ESFInstructsShootingDirectorSoap soapModel = new ESFInstructsShootingDirectorSoap();

		soapModel.setEsfInstructsShootingDirectorId(model.getEsfInstructsShootingDirectorId());
		soapModel.setEsfInstructsShootingDirectorCode(model.getEsfInstructsShootingDirectorCode());
		soapModel.setEsfInstructsShootingDirectorDesc(model.getEsfInstructsShootingDirectorDesc());

		return soapModel;
	}

	public static ESFInstructsShootingDirectorSoap[] toSoapModels(
		ESFInstructsShootingDirector[] models) {
		ESFInstructsShootingDirectorSoap[] soapModels = new ESFInstructsShootingDirectorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFInstructsShootingDirectorSoap[][] toSoapModels(
		ESFInstructsShootingDirector[][] models) {
		ESFInstructsShootingDirectorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFInstructsShootingDirectorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFInstructsShootingDirectorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFInstructsShootingDirectorSoap[] toSoapModels(
		List<ESFInstructsShootingDirector> models) {
		List<ESFInstructsShootingDirectorSoap> soapModels = new ArrayList<ESFInstructsShootingDirectorSoap>(models.size());

		for (ESFInstructsShootingDirector model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFInstructsShootingDirectorSoap[soapModels.size()]);
	}

	public ESFInstructsShootingDirectorSoap() {
	}

	public long getPrimaryKey() {
		return _esfInstructsShootingDirectorId;
	}

	public void setPrimaryKey(long pk) {
		setEsfInstructsShootingDirectorId(pk);
	}

	public long getEsfInstructsShootingDirectorId() {
		return _esfInstructsShootingDirectorId;
	}

	public void setEsfInstructsShootingDirectorId(
		long esfInstructsShootingDirectorId) {
		_esfInstructsShootingDirectorId = esfInstructsShootingDirectorId;
	}

	public String getEsfInstructsShootingDirectorCode() {
		return _esfInstructsShootingDirectorCode;
	}

	public void setEsfInstructsShootingDirectorCode(
		String esfInstructsShootingDirectorCode) {
		_esfInstructsShootingDirectorCode = esfInstructsShootingDirectorCode;
	}

	public String getEsfInstructsShootingDirectorDesc() {
		return _esfInstructsShootingDirectorDesc;
	}

	public void setEsfInstructsShootingDirectorDesc(
		String esfInstructsShootingDirectorDesc) {
		_esfInstructsShootingDirectorDesc = esfInstructsShootingDirectorDesc;
	}

	private long _esfInstructsShootingDirectorId;
	private String _esfInstructsShootingDirectorCode;
	private String _esfInstructsShootingDirectorDesc;
}