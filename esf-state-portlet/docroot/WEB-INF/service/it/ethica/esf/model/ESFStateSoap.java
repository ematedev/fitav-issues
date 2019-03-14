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
public class ESFStateSoap implements Serializable {
	public static ESFStateSoap toSoapModel(ESFState model) {
		ESFStateSoap soapModel = new ESFStateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfStateId(model.getEsfStateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfName(model.getEsfName());
		soapModel.setEsfDescription(model.getEsfDescription());

		return soapModel;
	}

	public static ESFStateSoap[] toSoapModels(ESFState[] models) {
		ESFStateSoap[] soapModels = new ESFStateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFStateSoap[][] toSoapModels(ESFState[][] models) {
		ESFStateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFStateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFStateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFStateSoap[] toSoapModels(List<ESFState> models) {
		List<ESFStateSoap> soapModels = new ArrayList<ESFStateSoap>(models.size());

		for (ESFState model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFStateSoap[soapModels.size()]);
	}

	public ESFStateSoap() {
	}

	public long getPrimaryKey() {
		return _esfStateId;
	}

	public void setPrimaryKey(long pk) {
		setEsfStateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfStateId() {
		return _esfStateId;
	}

	public void setEsfStateId(long esfStateId) {
		_esfStateId = esfStateId;
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

	public String getEsfName() {
		return _esfName;
	}

	public void setEsfName(String esfName) {
		_esfName = esfName;
	}

	public String getEsfDescription() {
		return _esfDescription;
	}

	public void setEsfDescription(String esfDescription) {
		_esfDescription = esfDescription;
	}

	private String _uuid;
	private long _esfStateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _esfName;
	private String _esfDescription;
}