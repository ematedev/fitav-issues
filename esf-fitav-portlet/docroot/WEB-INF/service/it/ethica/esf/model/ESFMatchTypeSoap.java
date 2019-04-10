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
public class ESFMatchTypeSoap implements Serializable {
	public static ESFMatchTypeSoap toSoapModel(ESFMatchType model) {
		ESFMatchTypeSoap soapModel = new ESFMatchTypeSoap();

		soapModel.setEsfMatchTypeId(model.getEsfMatchTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setIsCategoryQualification(model.getIsCategoryQualification());
		soapModel.setIsNational(model.getIsNational());
		soapModel.setCode(model.getCode());

		return soapModel;
	}

	public static ESFMatchTypeSoap[] toSoapModels(ESFMatchType[] models) {
		ESFMatchTypeSoap[] soapModels = new ESFMatchTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchTypeSoap[][] toSoapModels(ESFMatchType[][] models) {
		ESFMatchTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFMatchTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFMatchTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchTypeSoap[] toSoapModels(List<ESFMatchType> models) {
		List<ESFMatchTypeSoap> soapModels = new ArrayList<ESFMatchTypeSoap>(models.size());

		for (ESFMatchType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFMatchTypeSoap[soapModels.size()]);
	}

	public ESFMatchTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfMatchTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfMatchTypeId(pk);
	}

	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getIsCategoryQualification() {
		return _isCategoryQualification;
	}

	public boolean isIsCategoryQualification() {
		return _isCategoryQualification;
	}

	public void setIsCategoryQualification(boolean isCategoryQualification) {
		_isCategoryQualification = isCategoryQualification;
	}

	public boolean getIsNational() {
		return _isNational;
	}

	public boolean isIsNational() {
		return _isNational;
	}

	public void setIsNational(boolean isNational) {
		_isNational = isNational;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	private long _esfMatchTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private boolean _isCategoryQualification;
	private boolean _isNational;
	private String _code;
}