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
public class ESFDocumentSoap implements Serializable {
	public static ESFDocumentSoap toSoapModel(ESFDocument model) {
		ESFDocumentSoap soapModel = new ESFDocumentSoap();

		soapModel.setEsfDocumentId(model.getEsfDocumentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setReleasedBy(model.getReleasedBy());
		soapModel.setReleaseDate(model.getReleaseDate());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setType(model.getType());
		soapModel.setEsfDocumentTypeId(model.getEsfDocumentTypeId());
		soapModel.setEsfPublicAuthorityId(model.getEsfPublicAuthorityId());
		soapModel.setPath(model.getPath());

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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getReleasedBy() {
		return _releasedBy;
	}

	public void setReleasedBy(String releasedBy) {
		_releasedBy = releasedBy;
	}

	public Date getReleaseDate() {
		return _releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getEsfDocumentTypeId() {
		return _esfDocumentTypeId;
	}

	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentTypeId = esfDocumentTypeId;
	}

	public long getEsfPublicAuthorityId() {
		return _esfPublicAuthorityId;
	}

	public void setEsfPublicAuthorityId(long esfPublicAuthorityId) {
		_esfPublicAuthorityId = esfPublicAuthorityId;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	private long _esfDocumentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _releasedBy;
	private Date _releaseDate;
	private Date _expirationDate;
	private long _esfUserId;
	private String _type;
	private long _esfDocumentTypeId;
	private long _esfPublicAuthorityId;
	private String _path;
}