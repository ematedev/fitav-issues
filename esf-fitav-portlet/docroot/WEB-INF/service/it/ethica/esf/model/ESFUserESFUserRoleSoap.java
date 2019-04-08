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

import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;

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
public class ESFUserESFUserRoleSoap implements Serializable {
	public static ESFUserESFUserRoleSoap toSoapModel(ESFUserESFUserRole model) {
		ESFUserESFUserRoleSoap soapModel = new ESFUserESFUserRoleSoap();

		soapModel.setEsfUserRoleId(model.getEsfUserRoleId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static ESFUserESFUserRoleSoap[] toSoapModels(
		ESFUserESFUserRole[] models) {
		ESFUserESFUserRoleSoap[] soapModels = new ESFUserESFUserRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserESFUserRoleSoap[][] toSoapModels(
		ESFUserESFUserRole[][] models) {
		ESFUserESFUserRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserESFUserRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserESFUserRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserESFUserRoleSoap[] toSoapModels(
		List<ESFUserESFUserRole> models) {
		List<ESFUserESFUserRoleSoap> soapModels = new ArrayList<ESFUserESFUserRoleSoap>(models.size());

		for (ESFUserESFUserRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserESFUserRoleSoap[soapModels.size()]);
	}

	public ESFUserESFUserRoleSoap() {
	}

	public ESFUserESFUserRolePK getPrimaryKey() {
		return new ESFUserESFUserRolePK(_esfUserRoleId, _esfUserId,
			_esfOrganizationId, _startDate);
	}

	public void setPrimaryKey(ESFUserESFUserRolePK pk) {
		setEsfUserRoleId(pk.esfUserRoleId);
		setEsfUserId(pk.esfUserId);
		setEsfOrganizationId(pk.esfOrganizationId);
		setStartDate(pk.startDate);
	}

	public long getEsfUserRoleId() {
		return _esfUserRoleId;
	}

	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRoleId = esfUserRoleId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
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

	private long _esfUserRoleId;
	private long _esfUserId;
	private long _esfOrganizationId;
	private Date _startDate;
	private Date _endDate;
}