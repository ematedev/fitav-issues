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

import it.ethica.esf.service.persistence.VW_StaffPK;

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
public class VW_StaffSoap implements Serializable {
	public static VW_StaffSoap toSoapModel(VW_Staff model) {
		VW_StaffSoap soapModel = new VW_StaffSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setEsfStartData(model.getEsfStartData());
		soapModel.setEsfEndData(model.getEsfEndData());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setProvinceId(model.getProvinceId());
		soapModel.setEsfShootingDirectorQualificationDesc(model.getEsfShootingDirectorQualificationDesc());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setName(model.getName());
		soapModel.setInvitato(model.getInvitato());

		return soapModel;
	}

	public static VW_StaffSoap[] toSoapModels(VW_Staff[] models) {
		VW_StaffSoap[] soapModels = new VW_StaffSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VW_StaffSoap[][] toSoapModels(VW_Staff[][] models) {
		VW_StaffSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VW_StaffSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VW_StaffSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VW_StaffSoap[] toSoapModels(List<VW_Staff> models) {
		List<VW_StaffSoap> soapModels = new ArrayList<VW_StaffSoap>(models.size());

		for (VW_Staff model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VW_StaffSoap[soapModels.size()]);
	}

	public VW_StaffSoap() {
	}

	public VW_StaffPK getPrimaryKey() {
		return new VW_StaffPK(_userId, _regionId, _provinceId, _esfSportTypeId);
	}

	public void setPrimaryKey(VW_StaffPK pk) {
		setUserId(pk.userId);
		setRegionId(pk.regionId);
		setProvinceId(pk.provinceId);
		setEsfSportTypeId(pk.esfSportTypeId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getEsfStartData() {
		return _esfStartData;
	}

	public void setEsfStartData(Date esfStartData) {
		_esfStartData = esfStartData;
	}

	public Date getEsfEndData() {
		return _esfEndData;
	}

	public void setEsfEndData(Date esfEndData) {
		_esfEndData = esfEndData;
	}

	public String getRegionId() {
		return _regionId;
	}

	public void setRegionId(String regionId) {
		_regionId = regionId;
	}

	public String getProvinceId() {
		return _provinceId;
	}

	public void setProvinceId(String provinceId) {
		_provinceId = provinceId;
	}

	public String getEsfShootingDirectorQualificationDesc() {
		return _esfShootingDirectorQualificationDesc;
	}

	public void setEsfShootingDirectorQualificationDesc(
		String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationDesc;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getInvitato() {
		return _invitato;
	}

	public void setInvitato(long invitato) {
		_invitato = invitato;
	}

	private long _userId;
	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private Date _createDate;
	private Date _esfStartData;
	private Date _esfEndData;
	private String _regionId;
	private String _provinceId;
	private String _esfShootingDirectorQualificationDesc;
	private long _esfSportTypeId;
	private String _name;
	private long _invitato;
}