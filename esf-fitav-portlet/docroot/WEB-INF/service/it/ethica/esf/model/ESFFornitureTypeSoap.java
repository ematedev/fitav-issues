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
public class ESFFornitureTypeSoap implements Serializable {
	public static ESFFornitureTypeSoap toSoapModel(ESFFornitureType model) {
		ESFFornitureTypeSoap soapModel = new ESFFornitureTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfFornitureTypeId(model.getEsfFornitureTypeId());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ESFFornitureTypeSoap[] toSoapModels(ESFFornitureType[] models) {
		ESFFornitureTypeSoap[] soapModels = new ESFFornitureTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureTypeSoap[][] toSoapModels(
		ESFFornitureType[][] models) {
		ESFFornitureTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFornitureTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFornitureTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureTypeSoap[] toSoapModels(
		List<ESFFornitureType> models) {
		List<ESFFornitureTypeSoap> soapModels = new ArrayList<ESFFornitureTypeSoap>(models.size());

		for (ESFFornitureType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFornitureTypeSoap[soapModels.size()]);
	}

	public ESFFornitureTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfFornitureTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfFornitureTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfFornitureTypeId() {
		return _esfFornitureTypeId;
	}

	public void setEsfFornitureTypeId(long esfFornitureTypeId) {
		_esfFornitureTypeId = esfFornitureTypeId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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
	private long _esfFornitureTypeId;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}