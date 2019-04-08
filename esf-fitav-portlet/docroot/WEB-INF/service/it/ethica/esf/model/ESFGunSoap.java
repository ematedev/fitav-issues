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
public class ESFGunSoap implements Serializable {
	public static ESFGunSoap toSoapModel(ESFGun model) {
		ESFGunSoap soapModel = new ESFGunSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfGunId(model.getEsfGunId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCode(model.getCode());
		soapModel.setEsfGunKindId(model.getEsfGunKindId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setRegistrationNumber(model.getRegistrationNumber());
		soapModel.setCatridgeCaliber(model.getCatridgeCaliber());
		soapModel.setIsFavoriteGun(model.getIsFavoriteGun());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setMeasures(model.getMeasures());
		soapModel.setNote(model.getNote());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFGunSoap[] toSoapModels(ESFGun[] models) {
		ESFGunSoap[] soapModels = new ESFGunSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFGunSoap[][] toSoapModels(ESFGun[][] models) {
		ESFGunSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFGunSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFGunSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFGunSoap[] toSoapModels(List<ESFGun> models) {
		List<ESFGunSoap> soapModels = new ArrayList<ESFGunSoap>(models.size());

		for (ESFGun model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFGunSoap[soapModels.size()]);
	}

	public ESFGunSoap() {
	}

	public long getPrimaryKey() {
		return _esfGunId;
	}

	public void setPrimaryKey(long pk) {
		setEsfGunId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfGunId() {
		return _esfGunId;
	}

	public void setEsfGunId(long esfGunId) {
		_esfGunId = esfGunId;
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

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;
	}

	public long getCatridgeCaliber() {
		return _catridgeCaliber;
	}

	public void setCatridgeCaliber(long catridgeCaliber) {
		_catridgeCaliber = catridgeCaliber;
	}

	public boolean getIsFavoriteGun() {
		return _isFavoriteGun;
	}

	public boolean isIsFavoriteGun() {
		return _isFavoriteGun;
	}

	public void setIsFavoriteGun(boolean isFavoriteGun) {
		_isFavoriteGun = isFavoriteGun;
	}

	public int getTypeId() {
		return _typeId;
	}

	public void setTypeId(int typeId) {
		_typeId = typeId;
	}

	public String getMeasures() {
		return _measures;
	}

	public void setMeasures(String measures) {
		_measures = measures;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private long _esfGunId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private String _code;
	private long _esfGunKindId;
	private long _esfOrganizationId;
	private String _registrationNumber;
	private long _catridgeCaliber;
	private boolean _isFavoriteGun;
	private int _typeId;
	private String _measures;
	private String _note;
	private String _name;
}