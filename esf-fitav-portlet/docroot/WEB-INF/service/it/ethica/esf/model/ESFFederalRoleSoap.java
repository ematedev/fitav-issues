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
public class ESFFederalRoleSoap implements Serializable {
	public static ESFFederalRoleSoap toSoapModel(ESFFederalRole model) {
		ESFFederalRoleSoap soapModel = new ESFFederalRoleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfFederalRoleId(model.getEsfFederalRoleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setRegional(model.getRegional());
		soapModel.setProvincial(model.getProvincial());

		return soapModel;
	}

	public static ESFFederalRoleSoap[] toSoapModels(ESFFederalRole[] models) {
		ESFFederalRoleSoap[] soapModels = new ESFFederalRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFederalRoleSoap[][] toSoapModels(ESFFederalRole[][] models) {
		ESFFederalRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFederalRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFederalRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFederalRoleSoap[] toSoapModels(List<ESFFederalRole> models) {
		List<ESFFederalRoleSoap> soapModels = new ArrayList<ESFFederalRoleSoap>(models.size());

		for (ESFFederalRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFederalRoleSoap[soapModels.size()]);
	}

	public ESFFederalRoleSoap() {
	}

	public long getPrimaryKey() {
		return _esfFederalRoleId;
	}

	public void setPrimaryKey(long pk) {
		setEsfFederalRoleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleId = esfFederalRoleId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getRegional() {
		return _regional;
	}

	public boolean isRegional() {
		return _regional;
	}

	public void setRegional(boolean regional) {
		_regional = regional;
	}

	public boolean getProvincial() {
		return _provincial;
	}

	public boolean isProvincial() {
		return _provincial;
	}

	public void setProvincial(boolean provincial) {
		_provincial = provincial;
	}

	private String _uuid;
	private long _esfFederalRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _description;
	private boolean _regional;
	private boolean _provincial;
}