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
public class ESFDocumentTypeSoap implements Serializable {
	public static ESFDocumentTypeSoap toSoapModel(ESFDocumentType model) {
		ESFDocumentTypeSoap soapModel = new ESFDocumentTypeSoap();

		soapModel.setEsfDocumentTypeId(model.getEsfDocumentTypeId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setExpirationMonthsNotice(model.getExpirationMonthsNotice());

		return soapModel;
	}

	public static ESFDocumentTypeSoap[] toSoapModels(ESFDocumentType[] models) {
		ESFDocumentTypeSoap[] soapModels = new ESFDocumentTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFDocumentTypeSoap[][] toSoapModels(
		ESFDocumentType[][] models) {
		ESFDocumentTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFDocumentTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFDocumentTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFDocumentTypeSoap[] toSoapModels(
		List<ESFDocumentType> models) {
		List<ESFDocumentTypeSoap> soapModels = new ArrayList<ESFDocumentTypeSoap>(models.size());

		for (ESFDocumentType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFDocumentTypeSoap[soapModels.size()]);
	}

	public ESFDocumentTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfDocumentTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfDocumentTypeId(pk);
	}

	public long getEsfDocumentTypeId() {
		return _esfDocumentTypeId;
	}

	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentTypeId = esfDocumentTypeId;
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

	public int getExpirationMonthsNotice() {
		return _expirationMonthsNotice;
	}

	public void setExpirationMonthsNotice(int expirationMonthsNotice) {
		_expirationMonthsNotice = expirationMonthsNotice;
	}

	private long _esfDocumentTypeId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private int _expirationMonthsNotice;
}