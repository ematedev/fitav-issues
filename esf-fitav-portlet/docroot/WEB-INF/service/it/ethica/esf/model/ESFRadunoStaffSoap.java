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

import it.ethica.esf.service.persistence.ESFRadunoStaffPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFRadunoStaffSoap implements Serializable {
	public static ESFRadunoStaffSoap toSoapModel(ESFRadunoStaff model) {
		ESFRadunoStaffSoap soapModel = new ESFRadunoStaffSoap();

		soapModel.setId_esf_raduno_staff(model.getId_esf_raduno_staff());
		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ESFRadunoStaffSoap[] toSoapModels(ESFRadunoStaff[] models) {
		ESFRadunoStaffSoap[] soapModels = new ESFRadunoStaffSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoStaffSoap[][] toSoapModels(ESFRadunoStaff[][] models) {
		ESFRadunoStaffSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoStaffSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoStaffSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoStaffSoap[] toSoapModels(List<ESFRadunoStaff> models) {
		List<ESFRadunoStaffSoap> soapModels = new ArrayList<ESFRadunoStaffSoap>(models.size());

		for (ESFRadunoStaff model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoStaffSoap[soapModels.size()]);
	}

	public ESFRadunoStaffSoap() {
	}

	public ESFRadunoStaffPK getPrimaryKey() {
		return new ESFRadunoStaffPK(_id_esf_raduno_staff, _id_esf_raduno,
			_userId);
	}

	public void setPrimaryKey(ESFRadunoStaffPK pk) {
		setId_esf_raduno_staff(pk.id_esf_raduno_staff);
		setId_esf_raduno(pk.id_esf_raduno);
		setUserId(pk.userId);
	}

	public long getId_esf_raduno_staff() {
		return _id_esf_raduno_staff;
	}

	public void setId_esf_raduno_staff(long id_esf_raduno_staff) {
		_id_esf_raduno_staff = id_esf_raduno_staff;
	}

	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _id_esf_raduno_staff;
	private long _id_esf_raduno;
	private long _userId;
}