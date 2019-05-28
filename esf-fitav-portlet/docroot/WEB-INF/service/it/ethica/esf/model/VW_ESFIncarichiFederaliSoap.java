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

import it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK;

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
public class VW_ESFIncarichiFederaliSoap implements Serializable {
	public static VW_ESFIncarichiFederaliSoap toSoapModel(
		VW_ESFIncarichiFederali model) {
		VW_ESFIncarichiFederaliSoap soapModel = new VW_ESFIncarichiFederaliSoap();

		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfFederalRoleId(model.getEsfFederalRoleId());
		soapModel.setCode_(model.getCode_());
		soapModel.setDescription(model.getDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setActive_(model.getActive_());

		return soapModel;
	}

	public static VW_ESFIncarichiFederaliSoap[] toSoapModels(
		VW_ESFIncarichiFederali[] models) {
		VW_ESFIncarichiFederaliSoap[] soapModels = new VW_ESFIncarichiFederaliSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFIncarichiFederaliSoap[][] toSoapModels(
		VW_ESFIncarichiFederali[][] models) {
		VW_ESFIncarichiFederaliSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_ESFIncarichiFederaliSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_ESFIncarichiFederaliSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_ESFIncarichiFederaliSoap[] toSoapModels(
		List<VW_ESFIncarichiFederali> models) {
		List<VW_ESFIncarichiFederaliSoap> soapModels = new ArrayList<VW_ESFIncarichiFederaliSoap>(models.size());

		for (VW_ESFIncarichiFederali model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_ESFIncarichiFederaliSoap[soapModels.size()]);
	}

	public VW_ESFIncarichiFederaliSoap() {
	}

	public VW_ESFIncarichiFederaliPK getPrimaryKey() {
		return new VW_ESFIncarichiFederaliPK(_esfUserId, _esfFederalRoleId,
			_startDate, _endDate, _active_);
	}

	public void setPrimaryKey(VW_ESFIncarichiFederaliPK pk) {
		setEsfUserId(pk.esfUserId);
		setEsfFederalRoleId(pk.esfFederalRoleId);
		setStartDate(pk.startDate);
		setEndDate(pk.endDate);
		setActive_(pk.active_);
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

	public String getCode_() {
		return _code_;
	}

	public void setCode_(String code_) {
		_code_ = code_;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public boolean getActive_() {
		return _active_;
	}

	public boolean isActive_() {
		return _active_;
	}

	public void setActive_(boolean active_) {
		_active_ = active_;
	}

	private long _esfUserId;
	private long _esfFederalRoleId;
	private String _code_;
	private String _description;
	private long _startDate;
	private Date _endDate;
	private boolean _active_;
}