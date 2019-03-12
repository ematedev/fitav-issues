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

import it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFShooterCategoryESFTournamentSoap implements Serializable {
	public static ESFShooterCategoryESFTournamentSoap toSoapModel(
		ESFShooterCategoryESFTournament model) {
		ESFShooterCategoryESFTournamentSoap soapModel = new ESFShooterCategoryESFTournamentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfShooterCategoryId(model.getEsfShooterCategoryId());
		soapModel.setEsfTournamentId(model.getEsfTournamentId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static ESFShooterCategoryESFTournamentSoap[] toSoapModels(
		ESFShooterCategoryESFTournament[] models) {
		ESFShooterCategoryESFTournamentSoap[] soapModels = new ESFShooterCategoryESFTournamentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterCategoryESFTournamentSoap[][] toSoapModels(
		ESFShooterCategoryESFTournament[][] models) {
		ESFShooterCategoryESFTournamentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFShooterCategoryESFTournamentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFShooterCategoryESFTournamentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterCategoryESFTournamentSoap[] toSoapModels(
		List<ESFShooterCategoryESFTournament> models) {
		List<ESFShooterCategoryESFTournamentSoap> soapModels = new ArrayList<ESFShooterCategoryESFTournamentSoap>(models.size());

		for (ESFShooterCategoryESFTournament model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFShooterCategoryESFTournamentSoap[soapModels.size()]);
	}

	public ESFShooterCategoryESFTournamentSoap() {
	}

	public ESFShooterCategoryESFTournamentPK getPrimaryKey() {
		return new ESFShooterCategoryESFTournamentPK(_esfShooterCategoryId,
			_esfTournamentId);
	}

	public void setPrimaryKey(ESFShooterCategoryESFTournamentPK pk) {
		setEsfShooterCategoryId(pk.esfShooterCategoryId);
		setEsfTournamentId(pk.esfTournamentId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryId;
	}

	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryId = esfShooterCategoryId;
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
	private long _esfShooterCategoryId;
	private long _esfTournamentId;
	private long _groupId;
}