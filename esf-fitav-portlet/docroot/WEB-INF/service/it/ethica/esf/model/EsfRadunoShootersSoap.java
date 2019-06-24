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

import it.ethica.esf.service.persistence.EsfRadunoShootersPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class EsfRadunoShootersSoap implements Serializable {
	public static EsfRadunoShootersSoap toSoapModel(EsfRadunoShooters model) {
		EsfRadunoShootersSoap soapModel = new EsfRadunoShootersSoap();

		soapModel.setId_esf_raduno_shooters(model.getId_esf_raduno_shooters());
		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static EsfRadunoShootersSoap[] toSoapModels(
		EsfRadunoShooters[] models) {
		EsfRadunoShootersSoap[] soapModels = new EsfRadunoShootersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EsfRadunoShootersSoap[][] toSoapModels(
		EsfRadunoShooters[][] models) {
		EsfRadunoShootersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EsfRadunoShootersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EsfRadunoShootersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EsfRadunoShootersSoap[] toSoapModels(
		List<EsfRadunoShooters> models) {
		List<EsfRadunoShootersSoap> soapModels = new ArrayList<EsfRadunoShootersSoap>(models.size());

		for (EsfRadunoShooters model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EsfRadunoShootersSoap[soapModels.size()]);
	}

	public EsfRadunoShootersSoap() {
	}

	public EsfRadunoShootersPK getPrimaryKey() {
		return new EsfRadunoShootersPK(_id_esf_raduno_shooters, _id_esf_raduno,
			_userId);
	}

	public void setPrimaryKey(EsfRadunoShootersPK pk) {
		setId_esf_raduno_shooters(pk.id_esf_raduno_shooters);
		setId_esf_raduno(pk.id_esf_raduno);
		setUserId(pk.userId);
	}

	public long getId_esf_raduno_shooters() {
		return _id_esf_raduno_shooters;
	}

	public void setId_esf_raduno_shooters(long id_esf_raduno_shooters) {
		_id_esf_raduno_shooters = id_esf_raduno_shooters;
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

	private long _id_esf_raduno_shooters;
	private long _id_esf_raduno;
	private long _userId;
}