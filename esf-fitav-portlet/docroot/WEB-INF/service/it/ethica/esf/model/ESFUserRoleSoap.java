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
public class ESFUserRoleSoap implements Serializable {
	public static ESFUserRoleSoap toSoapModel(ESFUserRole model) {
		ESFUserRoleSoap soapModel = new ESFUserRoleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfUserRoleId(model.getEsfUserRoleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsBDO(model.getIsBDO());
		soapModel.setIsLEA(model.getIsLEA());
		soapModel.setType(model.getType());
		soapModel.setMaxUser(model.getMaxUser());
		soapModel.setIsOrgAdmin(model.getIsOrgAdmin());
		soapModel.setIsEditable(model.getIsEditable());

		return soapModel;
	}

	public static ESFUserRoleSoap[] toSoapModels(ESFUserRole[] models) {
		ESFUserRoleSoap[] soapModels = new ESFUserRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserRoleSoap[][] toSoapModels(ESFUserRole[][] models) {
		ESFUserRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserRoleSoap[] toSoapModels(List<ESFUserRole> models) {
		List<ESFUserRoleSoap> soapModels = new ArrayList<ESFUserRoleSoap>(models.size());

		for (ESFUserRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserRoleSoap[soapModels.size()]);
	}

	public ESFUserRoleSoap() {
	}

	public long getPrimaryKey() {
		return _esfUserRoleId;
	}

	public void setPrimaryKey(long pk) {
		setEsfUserRoleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfUserRoleId() {
		return _esfUserRoleId;
	}

	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRoleId = esfUserRoleId;
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

	public boolean getIsBDO() {
		return _isBDO;
	}

	public boolean isIsBDO() {
		return _isBDO;
	}

	public void setIsBDO(boolean isBDO) {
		_isBDO = isBDO;
	}

	public boolean getIsLEA() {
		return _isLEA;
	}

	public boolean isIsLEA() {
		return _isLEA;
	}

	public void setIsLEA(boolean isLEA) {
		_isLEA = isLEA;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getMaxUser() {
		return _maxUser;
	}

	public void setMaxUser(int maxUser) {
		_maxUser = maxUser;
	}

	public boolean getIsOrgAdmin() {
		return _isOrgAdmin;
	}

	public boolean isIsOrgAdmin() {
		return _isOrgAdmin;
	}

	public void setIsOrgAdmin(boolean isOrgAdmin) {
		_isOrgAdmin = isOrgAdmin;
	}

	public boolean getIsEditable() {
		return _isEditable;
	}

	public boolean isIsEditable() {
		return _isEditable;
	}

	public void setIsEditable(boolean isEditable) {
		_isEditable = isEditable;
	}

	private String _uuid;
	private long _esfUserRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _isBDO;
	private boolean _isLEA;
	private int _type;
	private int _maxUser;
	private boolean _isOrgAdmin;
	private boolean _isEditable;
}