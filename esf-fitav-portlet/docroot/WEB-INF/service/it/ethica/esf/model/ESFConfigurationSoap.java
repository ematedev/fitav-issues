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
public class ESFConfigurationSoap implements Serializable {
	public static ESFConfigurationSoap toSoapModel(ESFConfiguration model) {
		ESFConfigurationSoap soapModel = new ESFConfigurationSoap();

		soapModel.setEsfConfigurationId(model.getEsfConfigurationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ESFConfigurationSoap[] toSoapModels(ESFConfiguration[] models) {
		ESFConfigurationSoap[] soapModels = new ESFConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFConfigurationSoap[][] toSoapModels(
		ESFConfiguration[][] models) {
		ESFConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFConfigurationSoap[] toSoapModels(
		List<ESFConfiguration> models) {
		List<ESFConfigurationSoap> soapModels = new ArrayList<ESFConfigurationSoap>(models.size());

		for (ESFConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFConfigurationSoap[soapModels.size()]);
	}

	public ESFConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _esfConfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfConfigurationId(pk);
	}

	public long getEsfConfigurationId() {
		return _esfConfigurationId;
	}

	public void setEsfConfigurationId(long esfConfigurationId) {
		_esfConfigurationId = esfConfigurationId;
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

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _esfConfigurationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _value;
}