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

import it.ethica.esf.service.persistence.ESFToolRelPK;

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
public class ESFToolRelSoap implements Serializable {
	public static ESFToolRelSoap toSoapModel(ESFToolRel model) {
		ESFToolRelSoap soapModel = new ESFToolRelSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAssignmentDate(model.getAssignmentDate());
		soapModel.setEsfToolId(model.getEsfToolId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static ESFToolRelSoap[] toSoapModels(ESFToolRel[] models) {
		ESFToolRelSoap[] soapModels = new ESFToolRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFToolRelSoap[][] toSoapModels(ESFToolRel[][] models) {
		ESFToolRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFToolRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFToolRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFToolRelSoap[] toSoapModels(List<ESFToolRel> models) {
		List<ESFToolRelSoap> soapModels = new ArrayList<ESFToolRelSoap>(models.size());

		for (ESFToolRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFToolRelSoap[soapModels.size()]);
	}

	public ESFToolRelSoap() {
	}

	public ESFToolRelPK getPrimaryKey() {
		return new ESFToolRelPK(_esfToolId, _className, _classPK);
	}

	public void setPrimaryKey(ESFToolRelPK pk) {
		setEsfToolId(pk.esfToolId);
		setClassName(pk.className);
		setClassPK(pk.classPK);
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

	public Date getAssignmentDate() {
		return _assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		_assignmentDate = assignmentDate;
	}

	public long getEsfToolId() {
		return _esfToolId;
	}

	public void setEsfToolId(long esfToolId) {
		_esfToolId = esfToolId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	private String _uuid;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _assignmentDate;
	private long _esfToolId;
	private String _className;
	private long _classPK;
}