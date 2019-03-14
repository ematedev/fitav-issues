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
public class ESFTypeSoap implements Serializable {
	public static ESFTypeSoap toSoapModel(ESFType model) {
		ESFTypeSoap soapModel = new ESFTypeSoap();

		soapModel.setEsfTypeId(model.getEsfTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setClassName(model.getClassName());
		soapModel.setStatus(model.getStatus());
		soapModel.setTypeParentId(model.getTypeParentId());

		return soapModel;
	}

	public static ESFTypeSoap[] toSoapModels(ESFType[] models) {
		ESFTypeSoap[] soapModels = new ESFTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFTypeSoap[][] toSoapModels(ESFType[][] models) {
		ESFTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFTypeSoap[] toSoapModels(List<ESFType> models) {
		List<ESFTypeSoap> soapModels = new ArrayList<ESFTypeSoap>(models.size());

		for (ESFType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFTypeSoap[soapModels.size()]);
	}

	public ESFTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfTypeId(pk);
	}

	public long getEsfTypeId() {
		return _esfTypeId;
	}

	public void setEsfTypeId(long esfTypeId) {
		_esfTypeId = esfTypeId;
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

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getTypeParentId() {
		return _typeParentId;
	}

	public void setTypeParentId(long typeParentId) {
		_typeParentId = typeParentId;
	}

	private long _esfTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private String _description;
	private String _className;
	private String _status;
	private long _typeParentId;
}