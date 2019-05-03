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

import it.ethica.esf.service.persistence.ESFFieldESFSportTypePK;

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
public class ESFFieldESFSportTypeSoap implements Serializable {
	public static ESFFieldESFSportTypeSoap toSoapModel(
		ESFFieldESFSportType model) {
		ESFFieldESFSportTypeSoap soapModel = new ESFFieldESFSportTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfFieldId(model.getEsfFieldId());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ESFFieldESFSportTypeSoap[] toSoapModels(
		ESFFieldESFSportType[] models) {
		ESFFieldESFSportTypeSoap[] soapModels = new ESFFieldESFSportTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldESFSportTypeSoap[][] toSoapModels(
		ESFFieldESFSportType[][] models) {
		ESFFieldESFSportTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFieldESFSportTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFieldESFSportTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldESFSportTypeSoap[] toSoapModels(
		List<ESFFieldESFSportType> models) {
		List<ESFFieldESFSportTypeSoap> soapModels = new ArrayList<ESFFieldESFSportTypeSoap>(models.size());

		for (ESFFieldESFSportType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFieldESFSportTypeSoap[soapModels.size()]);
	}

	public ESFFieldESFSportTypeSoap() {
	}

	public ESFFieldESFSportTypePK getPrimaryKey() {
		return new ESFFieldESFSportTypePK(_esfFieldId, _esfSportTypeId);
	}

	public void setPrimaryKey(ESFFieldESFSportTypePK pk) {
		setEsfFieldId(pk.esfFieldId);
		setEsfSportTypeId(pk.esfSportTypeId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfFieldId() {
		return _esfFieldId;
	}

	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
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

	private String _uuid;
	private long _esfFieldId;
	private long _esfSportTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}