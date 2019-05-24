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
 * This class is used by SOAP remote services, specifically {@link it.ethica.esf.service.http.ESFCardServiceSoap}.
 *
 * @author Ethica
 * @see it.ethica.esf.service.http.ESFCardServiceSoap
 * @generated
 */
public class ESFCardSoap implements Serializable {
	public static ESFCardSoap toSoapModel(ESFCard model) {
		ESFCardSoap soapModel = new ESFCardSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfCardId(model.getEsfCardId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCodeAlfa(model.getCodeAlfa());
		soapModel.setCodeNum(model.getCodeNum());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setCode(model.getCode());
		soapModel.setOldCode(model.getOldCode());

		return soapModel;
	}

	public static ESFCardSoap[] toSoapModels(ESFCard[] models) {
		ESFCardSoap[] soapModels = new ESFCardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCardSoap[][] toSoapModels(ESFCard[][] models) {
		ESFCardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCardSoap[] toSoapModels(List<ESFCard> models) {
		List<ESFCardSoap> soapModels = new ArrayList<ESFCardSoap>(models.size());

		for (ESFCard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCardSoap[soapModels.size()]);
	}

	public ESFCardSoap() {
	}

	public long getPrimaryKey() {
		return _esfCardId;
	}

	public void setPrimaryKey(long pk) {
		setEsfCardId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfCardId() {
		return _esfCardId;
	}

	public void setEsfCardId(long esfCardId) {
		_esfCardId = esfCardId;
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

	public String getCodeAlfa() {
		return _codeAlfa;
	}

	public void setCodeAlfa(String codeAlfa) {
		_codeAlfa = codeAlfa;
	}

	public long getCodeNum() {
		return _codeNum;
	}

	public void setCodeNum(long codeNum) {
		_codeNum = codeNum;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getOldCode() {
		return _oldCode;
	}

	public void setOldCode(String oldCode) {
		_oldCode = oldCode;
	}

	private String _uuid;
	private long _esfCardId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _codeAlfa;
	private long _codeNum;
	private long _esfUserId;
	private long _esfOrganizationId;
	private String _code;
	private String _oldCode;
}