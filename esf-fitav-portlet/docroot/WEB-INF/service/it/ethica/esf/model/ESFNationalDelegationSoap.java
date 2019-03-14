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
public class ESFNationalDelegationSoap implements Serializable {
	public static ESFNationalDelegationSoap toSoapModel(
		ESFNationalDelegation model) {
		ESFNationalDelegationSoap soapModel = new ESFNationalDelegationSoap();

		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeaveDate(model.getLeaveDate());
		soapModel.setReturnDate(model.getReturnDate());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setEsfShooterQualificationId(model.getEsfShooterQualificationId());
		soapModel.setEsfGunId1(model.getEsfGunId1());
		soapModel.setEsfGunId2(model.getEsfGunId2());
		soapModel.setEsfNationalDelgationId(model.getEsfNationalDelgationId());
		soapModel.setEsfPartecipantTypeId(model.getEsfPartecipantTypeId());
		soapModel.setNominationDate(model.getNominationDate());
		soapModel.setRefusalDate(model.getRefusalDate());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setRefusal(model.getRefusal());

		return soapModel;
	}

	public static ESFNationalDelegationSoap[] toSoapModels(
		ESFNationalDelegation[] models) {
		ESFNationalDelegationSoap[] soapModels = new ESFNationalDelegationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalDelegationSoap[][] toSoapModels(
		ESFNationalDelegation[][] models) {
		ESFNationalDelegationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFNationalDelegationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFNationalDelegationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalDelegationSoap[] toSoapModels(
		List<ESFNationalDelegation> models) {
		List<ESFNationalDelegationSoap> soapModels = new ArrayList<ESFNationalDelegationSoap>(models.size());

		for (ESFNationalDelegation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFNationalDelegationSoap[soapModels.size()]);
	}

	public ESFNationalDelegationSoap() {
	}

	public long getPrimaryKey() {
		return _esfNationalDelgationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfNationalDelgationId(pk);
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
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

	public Date getLeaveDate() {
		return _leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		_leaveDate = leaveDate;
	}

	public Date getReturnDate() {
		return _returnDate;
	}

	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationId;
	}

	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationId = esfShooterQualificationId;
	}

	public long getEsfGunId1() {
		return _esfGunId1;
	}

	public void setEsfGunId1(long esfGunId1) {
		_esfGunId1 = esfGunId1;
	}

	public long getEsfGunId2() {
		return _esfGunId2;
	}

	public void setEsfGunId2(long esfGunId2) {
		_esfGunId2 = esfGunId2;
	}

	public long getEsfNationalDelgationId() {
		return _esfNationalDelgationId;
	}

	public void setEsfNationalDelgationId(long esfNationalDelgationId) {
		_esfNationalDelgationId = esfNationalDelgationId;
	}

	public long getEsfPartecipantTypeId() {
		return _esfPartecipantTypeId;
	}

	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantTypeId = esfPartecipantTypeId;
	}

	public Date getNominationDate() {
		return _nominationDate;
	}

	public void setNominationDate(Date nominationDate) {
		_nominationDate = nominationDate;
	}

	public Date getRefusalDate() {
		return _refusalDate;
	}

	public void setRefusalDate(Date refusalDate) {
		_refusalDate = refusalDate;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public String getRefusal() {
		return _refusal;
	}

	public void setRefusal(String refusal) {
		_refusal = refusal;
	}

	private long _esfUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _leaveDate;
	private Date _returnDate;
	private long _esfMatchId;
	private long _esfSportTypeId;
	private long _esfShooterQualificationId;
	private long _esfGunId1;
	private long _esfGunId2;
	private long _esfNationalDelgationId;
	private long _esfPartecipantTypeId;
	private Date _nominationDate;
	private Date _refusalDate;
	private long _taskId;
	private String _refusal;
}