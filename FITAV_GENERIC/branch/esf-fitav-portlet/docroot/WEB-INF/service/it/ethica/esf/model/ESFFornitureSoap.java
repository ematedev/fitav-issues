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
public class ESFFornitureSoap implements Serializable {
	public static ESFFornitureSoap toSoapModel(ESFForniture model) {
		ESFFornitureSoap soapModel = new ESFFornitureSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfFornitureId(model.getEsfFornitureId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setNumberFornitures(model.getNumberFornitures());
		soapModel.setSize(model.getSize());

		return soapModel;
	}

	public static ESFFornitureSoap[] toSoapModels(ESFForniture[] models) {
		ESFFornitureSoap[] soapModels = new ESFFornitureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureSoap[][] toSoapModels(ESFForniture[][] models) {
		ESFFornitureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFornitureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFornitureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureSoap[] toSoapModels(List<ESFForniture> models) {
		List<ESFFornitureSoap> soapModels = new ArrayList<ESFFornitureSoap>(models.size());

		for (ESFForniture model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFornitureSoap[soapModels.size()]);
	}

	public ESFFornitureSoap() {
	}

	public long getPrimaryKey() {
		return _esfFornitureId;
	}

	public void setPrimaryKey(long pk) {
		setEsfFornitureId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfFornitureId() {
		return _esfFornitureId;
	}

	public void setEsfFornitureId(long esfFornitureId) {
		_esfFornitureId = esfFornitureId;
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

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public Date getInsertDate() {
		return _insertDate;
	}

	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	public long getNumberFornitures() {
		return _numberFornitures;
	}

	public void setNumberFornitures(long numberFornitures) {
		_numberFornitures = numberFornitures;
	}

	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		_size = size;
	}

	private String _uuid;
	private long _esfFornitureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private String _description;
	private long _type;
	private Date _insertDate;
	private long _numberFornitures;
	private String _size;
}