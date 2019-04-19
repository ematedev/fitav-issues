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
public class ESFPublicAuthoritySoap implements Serializable {
	public static ESFPublicAuthoritySoap toSoapModel(ESFPublicAuthority model) {
		ESFPublicAuthoritySoap soapModel = new ESFPublicAuthoritySoap();

		soapModel.setEsfPublicAuthorityId(model.getEsfPublicAuthorityId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFPublicAuthoritySoap[] toSoapModels(
		ESFPublicAuthority[] models) {
		ESFPublicAuthoritySoap[] soapModels = new ESFPublicAuthoritySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFPublicAuthoritySoap[][] toSoapModels(
		ESFPublicAuthority[][] models) {
		ESFPublicAuthoritySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFPublicAuthoritySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFPublicAuthoritySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFPublicAuthoritySoap[] toSoapModels(
		List<ESFPublicAuthority> models) {
		List<ESFPublicAuthoritySoap> soapModels = new ArrayList<ESFPublicAuthoritySoap>(models.size());

		for (ESFPublicAuthority model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFPublicAuthoritySoap[soapModels.size()]);
	}

	public ESFPublicAuthoritySoap() {
	}

	public long getPrimaryKey() {
		return _esfPublicAuthorityId;
	}

	public void setPrimaryKey(long pk) {
		setEsfPublicAuthorityId(pk);
	}

	public long getEsfPublicAuthorityId() {
		return _esfPublicAuthorityId;
	}

	public void setEsfPublicAuthorityId(long esfPublicAuthorityId) {
		_esfPublicAuthorityId = esfPublicAuthorityId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _esfPublicAuthorityId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
}