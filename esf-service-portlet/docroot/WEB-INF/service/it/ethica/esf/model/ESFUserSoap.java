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
public class ESFUserSoap implements Serializable {
	public static ESFUserSoap toSoapModel(ESFUser model) {
		ESFUserSoap soapModel = new ESFUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortalUserId(model.getPortalUserId());
		soapModel.setCode(model.getCode());

		return soapModel;
	}

	public static ESFUserSoap[] toSoapModels(ESFUser[] models) {
		ESFUserSoap[] soapModels = new ESFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[][] toSoapModels(ESFUser[][] models) {
		ESFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[] toSoapModels(List<ESFUser> models) {
		List<ESFUserSoap> soapModels = new ArrayList<ESFUserSoap>(models.size());

		for (ESFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserSoap[soapModels.size()]);
	}

	public ESFUserSoap() {
	}

	public long getPrimaryKey() {
		return _esfUserId;
	}

	public void setPrimaryKey(long pk) {
		setEsfUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
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

	public long getPortalUserId() {
		return _portalUserId;
	}

	public void setPortalUserId(long portalUserId) {
		_portalUserId = portalUserId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	private String _uuid;
	private long _esfUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _portalUserId;
	private String _code;
}