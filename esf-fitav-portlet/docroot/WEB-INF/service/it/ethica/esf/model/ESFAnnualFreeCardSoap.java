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
public class ESFAnnualFreeCardSoap implements Serializable {
	public static ESFAnnualFreeCardSoap toSoapModel(ESFAnnualFreeCard model) {
		ESFAnnualFreeCardSoap soapModel = new ESFAnnualFreeCardSoap();

		soapModel.setAnnualFreeCardId(model.getAnnualFreeCardId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAssId(model.getAssId());
		soapModel.setCode(model.getCode());
		soapModel.setCardCode(model.getCardCode());
		soapModel.setAssCode(model.getAssCode());
		soapModel.setAssName(model.getAssName());

		return soapModel;
	}

	public static ESFAnnualFreeCardSoap[] toSoapModels(
		ESFAnnualFreeCard[] models) {
		ESFAnnualFreeCardSoap[] soapModels = new ESFAnnualFreeCardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFAnnualFreeCardSoap[][] toSoapModels(
		ESFAnnualFreeCard[][] models) {
		ESFAnnualFreeCardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFAnnualFreeCardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFAnnualFreeCardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFAnnualFreeCardSoap[] toSoapModels(
		List<ESFAnnualFreeCard> models) {
		List<ESFAnnualFreeCardSoap> soapModels = new ArrayList<ESFAnnualFreeCardSoap>(models.size());

		for (ESFAnnualFreeCard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFAnnualFreeCardSoap[soapModels.size()]);
	}

	public ESFAnnualFreeCardSoap() {
	}

	public long getPrimaryKey() {
		return _annualFreeCardId;
	}

	public void setPrimaryKey(long pk) {
		setAnnualFreeCardId(pk);
	}

	public long getAnnualFreeCardId() {
		return _annualFreeCardId;
	}

	public void setAnnualFreeCardId(long annualFreeCardId) {
		_annualFreeCardId = annualFreeCardId;
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

	public long getAssId() {
		return _assId;
	}

	public void setAssId(long assId) {
		_assId = assId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCardCode() {
		return _cardCode;
	}

	public void setCardCode(String cardCode) {
		_cardCode = cardCode;
	}

	public String getAssCode() {
		return _assCode;
	}

	public void setAssCode(String assCode) {
		_assCode = assCode;
	}

	public String getAssName() {
		return _assName;
	}

	public void setAssName(String assName) {
		_assName = assName;
	}

	private long _annualFreeCardId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assId;
	private String _code;
	private String _cardCode;
	private String _assCode;
	private String _assName;
}