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
public class ESFDocumentSoap implements Serializable {
	public static ESFDocumentSoap toSoapModel(ESFDocument model) {
		ESFDocumentSoap soapModel = new ESFDocumentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfDocumentId(model.getEsfDocumentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setOwnerType(model.getOwnerType());
		soapModel.setName(model.getName());
		soapModel.setNumber(model.getNumber());
		soapModel.setReleaseDate(model.getReleaseDate());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setIssuer(model.getIssuer());
		soapModel.setContents(model.getContents());
		soapModel.setLocationReference(model.getLocationReference());

		return soapModel;
	}

	public static ESFDocumentSoap[] toSoapModels(ESFDocument[] models) {
		ESFDocumentSoap[] soapModels = new ESFDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFDocumentSoap[][] toSoapModels(ESFDocument[][] models) {
		ESFDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFDocumentSoap[] toSoapModels(List<ESFDocument> models) {
		List<ESFDocumentSoap> soapModels = new ArrayList<ESFDocumentSoap>(models.size());

		for (ESFDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFDocumentSoap[soapModels.size()]);
	}

	public ESFDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _esfDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setEsfDocumentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfDocumentId() {
		return _esfDocumentId;
	}

	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocumentId = esfDocumentId;
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

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getOwnerType() {
		return _ownerType;
	}

	public void setOwnerType(String ownerType) {
		_ownerType = ownerType;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getNumber() {
		return _number;
	}

	public void setNumber(long number) {
		_number = number;
	}

	public Date getReleaseDate() {
		return _releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	public String getIssuer() {
		return _issuer;
	}

	public void setIssuer(String issuer) {
		_issuer = issuer;
	}

	public String getContents() {
		return _contents;
	}

	public void setContents(String contents) {
		_contents = contents;
	}

	public String getLocationReference() {
		return _locationReference;
	}

	public void setLocationReference(String locationReference) {
		_locationReference = locationReference;
	}

	private String _uuid;
	private long _esfDocumentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ownerId;
	private String _ownerType;
	private String _name;
	private long _number;
	private Date _releaseDate;
	private Date _expireDate;
	private String _issuer;
	private String _contents;
	private String _locationReference;
}