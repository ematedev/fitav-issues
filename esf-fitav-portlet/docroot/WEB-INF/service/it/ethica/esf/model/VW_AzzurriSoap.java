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

import it.ethica.esf.service.persistence.VW_AzzurriPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class VW_AzzurriSoap implements Serializable {
	public static VW_AzzurriSoap toSoapModel(VW_Azzurri model) {
		VW_AzzurriSoap soapModel = new VW_AzzurriSoap();

		soapModel.setEsfNationalId(model.getEsfNationalId());
		soapModel.setUserName(model.getUserName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setInvitato(model.getInvitato());

		return soapModel;
	}

	public static VW_AzzurriSoap[] toSoapModels(VW_Azzurri[] models) {
		VW_AzzurriSoap[] soapModels = new VW_AzzurriSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_AzzurriSoap[][] toSoapModels(VW_Azzurri[][] models) {
		VW_AzzurriSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_AzzurriSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_AzzurriSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_AzzurriSoap[] toSoapModels(List<VW_Azzurri> models) {
		List<VW_AzzurriSoap> soapModels = new ArrayList<VW_AzzurriSoap>(models.size());

		for (VW_Azzurri model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_AzzurriSoap[soapModels.size()]);
	}

	public VW_AzzurriSoap() {
	}

	public VW_AzzurriPK getPrimaryKey() {
		return new VW_AzzurriPK(_esfNationalId, _esfSportTypeId);
	}

	public void setPrimaryKey(VW_AzzurriPK pk) {
		setEsfNationalId(pk.esfNationalId);
		setEsfSportTypeId(pk.esfSportTypeId);
	}

	public long getEsfNationalId() {
		return _esfNationalId;
	}

	public void setEsfNationalId(long esfNationalId) {
		_esfNationalId = esfNationalId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getInvitato() {
		return _invitato;
	}

	public void setInvitato(long invitato) {
		_invitato = invitato;
	}

	private long _esfNationalId;
	private String _userName;
	private Date _startDate;
	private Date _endDate;
	private long _esfSportTypeId;
	private String _name;
	private String _description;
	private long _invitato;
}