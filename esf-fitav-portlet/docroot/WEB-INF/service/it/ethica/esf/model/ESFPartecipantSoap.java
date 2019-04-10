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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFPartecipantSoap implements Serializable {
	public static ESFPartecipantSoap toSoapModel(ESFPartecipant model) {
		ESFPartecipantSoap soapModel = new ESFPartecipantSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfPartecipantId(model.getEsfPartecipantId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfTeamId(model.getEsfTeamId());
		soapModel.setCt(model.getCt());
		soapModel.setEsfPartecipantTypeId(model.getEsfPartecipantTypeId());
		soapModel.setResult(model.getResult());

		return soapModel;
	}

	public static ESFPartecipantSoap[] toSoapModels(ESFPartecipant[] models) {
		ESFPartecipantSoap[] soapModels = new ESFPartecipantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantSoap[][] toSoapModels(ESFPartecipant[][] models) {
		ESFPartecipantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFPartecipantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFPartecipantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantSoap[] toSoapModels(List<ESFPartecipant> models) {
		List<ESFPartecipantSoap> soapModels = new ArrayList<ESFPartecipantSoap>(models.size());

		for (ESFPartecipant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFPartecipantSoap[soapModels.size()]);
	}

	public ESFPartecipantSoap() {
	}

	public long getPrimaryKey() {
		return _esfPartecipantId;
	}

	public void setPrimaryKey(long pk) {
		setEsfPartecipantId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfPartecipantId() {
		return _esfPartecipantId;
	}

	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfPartecipantId = esfPartecipantId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfTeamId() {
		return _esfTeamId;
	}

	public void setEsfTeamId(long esfTeamId) {
		_esfTeamId = esfTeamId;
	}

	public long getCt() {
		return _ct;
	}

	public void setCt(long ct) {
		_ct = ct;
	}

	public long getEsfPartecipantTypeId() {
		return _esfPartecipantTypeId;
	}

	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantTypeId = esfPartecipantTypeId;
	}

	public long getResult() {
		return _result;
	}

	public void setResult(long result) {
		_result = result;
	}

	private String _uuid;
	private long _esfPartecipantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private long _esfMatchId;
	private long _esfTeamId;
	private long _ct;
	private long _esfPartecipantTypeId;
	private long _result;
}