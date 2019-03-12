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

import it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFShooterQualificationESFTournamentSoap implements Serializable {
	public static ESFShooterQualificationESFTournamentSoap toSoapModel(
		ESFShooterQualificationESFTournament model) {
		ESFShooterQualificationESFTournamentSoap soapModel = new ESFShooterQualificationESFTournamentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfShooterQualificationId(model.getEsfShooterQualificationId());
		soapModel.setEsfTournamentId(model.getEsfTournamentId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static ESFShooterQualificationESFTournamentSoap[] toSoapModels(
		ESFShooterQualificationESFTournament[] models) {
		ESFShooterQualificationESFTournamentSoap[] soapModels = new ESFShooterQualificationESFTournamentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterQualificationESFTournamentSoap[][] toSoapModels(
		ESFShooterQualificationESFTournament[][] models) {
		ESFShooterQualificationESFTournamentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFShooterQualificationESFTournamentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFShooterQualificationESFTournamentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterQualificationESFTournamentSoap[] toSoapModels(
		List<ESFShooterQualificationESFTournament> models) {
		List<ESFShooterQualificationESFTournamentSoap> soapModels = new ArrayList<ESFShooterQualificationESFTournamentSoap>(models.size());

		for (ESFShooterQualificationESFTournament model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFShooterQualificationESFTournamentSoap[soapModels.size()]);
	}

	public ESFShooterQualificationESFTournamentSoap() {
	}

	public ESFShooterQualificationESFTournamentPK getPrimaryKey() {
		return new ESFShooterQualificationESFTournamentPK(_esfShooterQualificationId,
			_esfTournamentId);
	}

	public void setPrimaryKey(ESFShooterQualificationESFTournamentPK pk) {
		setEsfShooterQualificationId(pk.esfShooterQualificationId);
		setEsfTournamentId(pk.esfTournamentId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationId;
	}

	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationId = esfShooterQualificationId;
	}

	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournamentId = esfTournamentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private String _uuid;
	private long _esfShooterQualificationId;
	private long _esfTournamentId;
	private long _groupId;
}