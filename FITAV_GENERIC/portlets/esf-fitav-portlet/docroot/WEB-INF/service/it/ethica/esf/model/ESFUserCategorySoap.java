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
public class ESFUserCategorySoap implements Serializable {
	public static ESFUserCategorySoap toSoapModel(ESFUserCategory model) {
		ESFUserCategorySoap soapModel = new ESFUserCategorySoap();

		soapModel.setEsfUserCategoryId(model.getEsfUserCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setEsfCategoryId(model.getEsfCategoryId());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());

		return soapModel;
	}

	public static ESFUserCategorySoap[] toSoapModels(ESFUserCategory[] models) {
		ESFUserCategorySoap[] soapModels = new ESFUserCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserCategorySoap[][] toSoapModels(
		ESFUserCategory[][] models) {
		ESFUserCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserCategorySoap[] toSoapModels(
		List<ESFUserCategory> models) {
		List<ESFUserCategorySoap> soapModels = new ArrayList<ESFUserCategorySoap>(models.size());

		for (ESFUserCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserCategorySoap[soapModels.size()]);
	}

	public ESFUserCategorySoap() {
	}

	public long getPrimaryKey() {
		return _esfUserCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setEsfUserCategoryId(pk);
	}

	public long getEsfUserCategoryId() {
		return _esfUserCategoryId;
	}

	public void setEsfUserCategoryId(long esfUserCategoryId) {
		_esfUserCategoryId = esfUserCategoryId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategoryId = esfCategoryId;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	private long _esfUserCategoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private Date _startDate;
	private Date _endDate;
	private long _esfCategoryId;
	private long _esfSportTypeId;
}