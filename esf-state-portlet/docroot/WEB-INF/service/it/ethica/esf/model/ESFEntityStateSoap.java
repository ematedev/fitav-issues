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

import it.ethica.esf.service.persistence.ESFEntityStatePK;

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
public class ESFEntityStateSoap implements Serializable {
	public static ESFEntityStateSoap toSoapModel(ESFEntityState model) {
		ESFEntityStateSoap soapModel = new ESFEntityStateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPk(model.getClassPk());
		soapModel.setStateId(model.getStateId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static ESFEntityStateSoap[] toSoapModels(ESFEntityState[] models) {
		ESFEntityStateSoap[] soapModels = new ESFEntityStateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFEntityStateSoap[][] toSoapModels(ESFEntityState[][] models) {
		ESFEntityStateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFEntityStateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFEntityStateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFEntityStateSoap[] toSoapModels(List<ESFEntityState> models) {
		List<ESFEntityStateSoap> soapModels = new ArrayList<ESFEntityStateSoap>(models.size());

		for (ESFEntityState model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFEntityStateSoap[soapModels.size()]);
	}

	public ESFEntityStateSoap() {
	}

	public ESFEntityStatePK getPrimaryKey() {
		return new ESFEntityStatePK(_className, _classPk, _stateId);
	}

	public void setPrimaryKey(ESFEntityStatePK pk) {
		setClassName(pk.className);
		setClassPk(pk.classPk);
		setStateId(pk.stateId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPk() {
		return _classPk;
	}

	public void setClassPk(long classPk) {
		_classPk = classPk;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
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

	private String _uuid;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _className;
	private long _classPk;
	private long _stateId;
	private Date _startDate;
	private Date _endDate;
}