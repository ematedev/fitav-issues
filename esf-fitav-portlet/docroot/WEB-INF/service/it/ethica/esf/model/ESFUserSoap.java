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
 * This class is used by SOAP remote services, specifically {@link it.ethica.esf.service.http.ESFUserServiceSoap}.
 *
 * @author Ethica
 * @see it.ethica.esf.service.http.ESFUserServiceSoap
 * @generated
 */
public class ESFUserSoap implements Serializable {
	public static ESFUserSoap toSoapModel(ESFUser model) {
		ESFUserSoap soapModel = new ESFUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCode(model.getCode());
		soapModel.setTypearmy(model.getTypearmy());
		soapModel.setFiscalCode(model.getFiscalCode());
		soapModel.setBirthcity(model.getBirthcity());
		soapModel.setNationality(model.getNationality());
		soapModel.setIsSportsGroups(model.getIsSportsGroups());
		soapModel.setJob(model.getJob());
		soapModel.setIssfIdNumber(model.getIssfIdNumber());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setPin(model.getPin());
		soapModel.setCodeUser(model.getCodeUser());
		soapModel.setDateOfDeath(model.getDateOfDeath());
		soapModel.setPrivacy1(model.getPrivacy1());
		soapModel.setPrivacy2(model.getPrivacy2());
		soapModel.setPrivacy3(model.getPrivacy3());
		soapModel.setDatePrivacy1(model.getDatePrivacy1());
		soapModel.setDatePrivacy2(model.getDatePrivacy2());
		soapModel.setDatePrivacy3(model.getDatePrivacy3());
		soapModel.setValidateCF(model.getValidateCF());

		return soapModel;
	}

	public static ESFUserSoap[] toSoapModels(ESFUser[] models) {
		ESFUserSoap[] soapModels = new ESFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[][] toSoapModels(ESFUser[][] models) {
		ESFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFUserSoap[] toSoapModels(List<ESFUser> models) {
		List<ESFUserSoap> soapModels = new ArrayList<ESFUserSoap>(models.size());

		for (ESFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFUserSoap[soapModels.size()]);
	}

	public ESFUserSoap() {
	}

	public long getPrimaryKey() {
		return _esfUserId;
	}

	public void setPrimaryKey(long pk) {
		setEsfUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getTypearmy() {
		return _typearmy;
	}

	public void setTypearmy(long typearmy) {
		_typearmy = typearmy;
	}

	public String getFiscalCode() {
		return _fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;
	}

	public String getBirthcity() {
		return _birthcity;
	}

	public void setBirthcity(String birthcity) {
		_birthcity = birthcity;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public boolean getIsSportsGroups() {
		return _isSportsGroups;
	}

	public boolean isIsSportsGroups() {
		return _isSportsGroups;
	}

	public void setIsSportsGroups(boolean isSportsGroups) {
		_isSportsGroups = isSportsGroups;
	}

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
	}

	public String getIssfIdNumber() {
		return _issfIdNumber;
	}

	public void setIssfIdNumber(String issfIdNumber) {
		_issfIdNumber = issfIdNumber;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getPin() {
		return _pin;
	}

	public void setPin(long pin) {
		_pin = pin;
	}

	public long getCodeUser() {
		return _codeUser;
	}

	public void setCodeUser(long codeUser) {
		_codeUser = codeUser;
	}

	public Date getDateOfDeath() {
		return _DateOfDeath;
	}

	public void setDateOfDeath(Date DateOfDeath) {
		_DateOfDeath = DateOfDeath;
	}

	public boolean getPrivacy1() {
		return _privacy1;
	}

	public boolean isPrivacy1() {
		return _privacy1;
	}

	public void setPrivacy1(boolean privacy1) {
		_privacy1 = privacy1;
	}

	public boolean getPrivacy2() {
		return _privacy2;
	}

	public boolean isPrivacy2() {
		return _privacy2;
	}

	public void setPrivacy2(boolean privacy2) {
		_privacy2 = privacy2;
	}

	public boolean getPrivacy3() {
		return _privacy3;
	}

	public boolean isPrivacy3() {
		return _privacy3;
	}

	public void setPrivacy3(boolean privacy3) {
		_privacy3 = privacy3;
	}

	public Date getDatePrivacy1() {
		return _datePrivacy1;
	}

	public void setDatePrivacy1(Date datePrivacy1) {
		_datePrivacy1 = datePrivacy1;
	}

	public Date getDatePrivacy2() {
		return _datePrivacy2;
	}

	public void setDatePrivacy2(Date datePrivacy2) {
		_datePrivacy2 = datePrivacy2;
	}

	public Date getDatePrivacy3() {
		return _datePrivacy3;
	}

	public void setDatePrivacy3(Date datePrivacy3) {
		_datePrivacy3 = datePrivacy3;
	}

	public boolean getValidateCF() {
		return _validateCF;
	}

	public boolean isValidateCF() {
		return _validateCF;
	}

	public void setValidateCF(boolean validateCF) {
		_validateCF = validateCF;
	}

	private String _uuid;
	private long _esfUserId;
	private String _code;
	private long _typearmy;
	private String _fiscalCode;
	private String _birthcity;
	private String _nationality;
	private boolean _isSportsGroups;
	private String _job;
	private String _issfIdNumber;
	private long _categoryId;
	private long _pin;
	private long _codeUser;
	private Date _DateOfDeath;
	private boolean _privacy1;
	private boolean _privacy2;
	private boolean _privacy3;
	private Date _datePrivacy1;
	private Date _datePrivacy2;
	private Date _datePrivacy3;
	private boolean _validateCF;
}