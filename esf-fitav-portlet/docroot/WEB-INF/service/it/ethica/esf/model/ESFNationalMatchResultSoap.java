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
public class ESFNationalMatchResultSoap implements Serializable {
	public static ESFNationalMatchResultSoap toSoapModel(
		ESFNationalMatchResult model) {
		ESFNationalMatchResultSoap soapModel = new ESFNationalMatchResultSoap();

		soapModel.setEsfNationalMatchResultId(model.getEsfNationalMatchResultId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setPosition(model.getPosition());
		soapModel.setQualification(model.getQualification());
		soapModel.setShootOff(model.getShootOff());
		soapModel.setClayPigeonTotal(model.getClayPigeonTotal());
		soapModel.setFinalResult(model.getFinalResult());
		soapModel.setShootOffFinal(model.getShootOffFinal());
		soapModel.setExternalShooter(model.getExternalShooter());
		soapModel.setExternalName(model.getExternalName());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setUserNationality(model.getUserNationality());
		soapModel.setEsfUserQualification(model.getEsfUserQualification());

		return soapModel;
	}

	public static ESFNationalMatchResultSoap[] toSoapModels(
		ESFNationalMatchResult[] models) {
		ESFNationalMatchResultSoap[] soapModels = new ESFNationalMatchResultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalMatchResultSoap[][] toSoapModels(
		ESFNationalMatchResult[][] models) {
		ESFNationalMatchResultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFNationalMatchResultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFNationalMatchResultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalMatchResultSoap[] toSoapModels(
		List<ESFNationalMatchResult> models) {
		List<ESFNationalMatchResultSoap> soapModels = new ArrayList<ESFNationalMatchResultSoap>(models.size());

		for (ESFNationalMatchResult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFNationalMatchResultSoap[soapModels.size()]);
	}

	public ESFNationalMatchResultSoap() {
	}

	public long getPrimaryKey() {
		return _esfNationalMatchResultId;
	}

	public void setPrimaryKey(long pk) {
		setEsfNationalMatchResultId(pk);
	}

	public long getEsfNationalMatchResultId() {
		return _esfNationalMatchResultId;
	}

	public void setEsfNationalMatchResultId(long esfNationalMatchResultId) {
		_esfNationalMatchResultId = esfNationalMatchResultId;
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

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public int getQualification() {
		return _qualification;
	}

	public void setQualification(int qualification) {
		_qualification = qualification;
	}

	public int getShootOff() {
		return _shootOff;
	}

	public void setShootOff(int shootOff) {
		_shootOff = shootOff;
	}

	public int getClayPigeonTotal() {
		return _clayPigeonTotal;
	}

	public void setClayPigeonTotal(int clayPigeonTotal) {
		_clayPigeonTotal = clayPigeonTotal;
	}

	public int getFinalResult() {
		return _finalResult;
	}

	public void setFinalResult(int finalResult) {
		_finalResult = finalResult;
	}

	public int getShootOffFinal() {
		return _shootOffFinal;
	}

	public void setShootOffFinal(int shootOffFinal) {
		_shootOffFinal = shootOffFinal;
	}

	public boolean getExternalShooter() {
		return _externalShooter;
	}

	public boolean isExternalShooter() {
		return _externalShooter;
	}

	public void setExternalShooter(boolean externalShooter) {
		_externalShooter = externalShooter;
	}

	public String getExternalName() {
		return _externalName;
	}

	public void setExternalName(String externalName) {
		_externalName = externalName;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public String getUserNationality() {
		return _userNationality;
	}

	public void setUserNationality(String userNationality) {
		_userNationality = userNationality;
	}

	public long getEsfUserQualification() {
		return _esfUserQualification;
	}

	public void setEsfUserQualification(long esfUserQualification) {
		_esfUserQualification = esfUserQualification;
	}

	private long _esfNationalMatchResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfMatchId;
	private long _esfUserId;
	private int _position;
	private int _qualification;
	private int _shootOff;
	private int _clayPigeonTotal;
	private int _finalResult;
	private int _shootOffFinal;
	private boolean _externalShooter;
	private String _externalName;
	private long _esfSportTypeId;
	private String _userNationality;
	private long _esfUserQualification;
}