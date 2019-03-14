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
public class ESFOrganizationSoap implements Serializable {
	public static ESFOrganizationSoap toSoapModel(ESFOrganization model) {
		ESFOrganizationSoap soapModel = new ESFOrganizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortalOrganizationId(model.getPortalOrganizationId());

		return soapModel;
	}

	public static ESFOrganizationSoap[] toSoapModels(ESFOrganization[] models) {
		ESFOrganizationSoap[] soapModels = new ESFOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[][] toSoapModels(
		ESFOrganization[][] models) {
		ESFOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[] toSoapModels(
		List<ESFOrganization> models) {
		List<ESFOrganizationSoap> soapModels = new ArrayList<ESFOrganizationSoap>(models.size());

		for (ESFOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFOrganizationSoap[soapModels.size()]);
	}

	public ESFOrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _esfOrganizationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfOrganizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
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

	public long getPortalOrganizationId() {
		return _portalOrganizationId;
	}

	public void setPortalOrganizationId(long portalOrganizationId) {
		_portalOrganizationId = portalOrganizationId;
	}

	private String _uuid;
	private long _esfOrganizationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _portalOrganizationId;
}