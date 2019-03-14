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

import it.ethica.esf.service.persistence.ESFUserESFFederalRolePK;

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
public class ESFUserESFFederalRoleSoap implements Serializable {
	public static ESFUserESFFederalRoleSoap toSoapModel(
		ESFUserESFFederalRole model) {
		ESFUserESFFederalRoleSoap soapModel = new ESFUserESFFederalRoleSoap();

		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfFederalRoleId(model.getEsfFederalRoleId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());
		soapModel.setEsfSpecificId(model.getEsfSpecificId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setProvinceId(model.getProvinceId());
		soapModel.setNotes(model.getNotes());

		return soapModel;
	}

	public static ESFUserESFFederalRoleSoap[] toSoapModels(
		ESFUserESFFederalRole[] models) {
		ESFUserESFFederalRoleSoap[] soapModels = new ESFUserESFFederalRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserESFFederalRoleSoap[][] toSoapModels(
		ESFUserESFFederalRole[][] models) {
		ESFUserESFFederalRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserESFFederalRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserESFFederalRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserESFFederalRoleSoap[] toSoapModels(
		List<ESFUserESFFederalRole> models) {
		List<ESFUserESFFederalRoleSoap> soapModels = new ArrayList<ESFUserESFFederalRoleSoap>(models.size());

		for (ESFUserESFFederalRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserESFFederalRoleSoap[soapModels.size()]);
	}

	public ESFUserESFFederalRoleSoap() {
	}

	public ESFUserESFFederalRolePK getPrimaryKey() {
		return new ESFUserESFFederalRolePK(_esfUserId, _esfFederalRoleId,
			_startDate);
	}

	public void setPrimaryKey(ESFUserESFFederalRolePK pk) {
		setEsfUserId(pk.esfUserId);
		setEsfFederalRoleId(pk.esfFederalRoleId);
		setStartDate(pk.startDate);
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleId = esfFederalRoleId;
	}

	public long getStartDate() {
		return _startDate;
	}

	public void setStartDate(long startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getEsfSpecificId() {
		return _esfSpecificId;
	}

	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecificId = esfSpecificId;
	}

	public String getRegionId() {
		return _regionId;
	}

	public void setRegionId(String regionId) {
		_regionId = regionId;
	}

	public String getProvinceId() {
		return _provinceId;
	}

	public void setProvinceId(String provinceId) {
		_provinceId = provinceId;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	private long _esfUserId;
	private long _esfFederalRoleId;
	private long _startDate;
	private Date _endDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _esfSpecificId;
	private String _regionId;
	private String _provinceId;
	private String _notes;
}