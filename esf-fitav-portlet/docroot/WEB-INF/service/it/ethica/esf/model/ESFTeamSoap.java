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
public class ESFTeamSoap implements Serializable {
	public static ESFTeamSoap toSoapModel(ESFTeam model) {
		ESFTeamSoap soapModel = new ESFTeamSoap();

		soapModel.setEsfTeamId(model.getEsfTeamId());
		soapModel.setEsfTournamentId(model.getEsfTournamentId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFTeamSoap[] toSoapModels(ESFTeam[] models) {
		ESFTeamSoap[] soapModels = new ESFTeamSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFTeamSoap[][] toSoapModels(ESFTeam[][] models) {
		ESFTeamSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFTeamSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFTeamSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFTeamSoap[] toSoapModels(List<ESFTeam> models) {
		List<ESFTeamSoap> soapModels = new ArrayList<ESFTeamSoap>(models.size());

		for (ESFTeam model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFTeamSoap[soapModels.size()]);
	}

	public ESFTeamSoap() {
	}

	public long getPrimaryKey() {
		return _esfTeamId;
	}

	public void setPrimaryKey(long pk) {
		setEsfTeamId(pk);
	}

	public long getEsfTeamId() {
		return _esfTeamId;
	}

	public void setEsfTeamId(long esfTeamId) {
		_esfTeamId = esfTeamId;
	}

	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournamentId = esfTournamentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _esfTeamId;
	private long _esfTournamentId;
	private String _name;
}