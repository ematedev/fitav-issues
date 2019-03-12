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
public class ESFShootingDirectorSoap implements Serializable {
	public static ESFShootingDirectorSoap toSoapModel(ESFShootingDirector model) {
		ESFShootingDirectorSoap soapModel = new ESFShootingDirectorSoap();

		soapModel.setEsfShootingDirectorId(model.getEsfShootingDirectorId());
		soapModel.setEsfCodeData(model.getEsfCodeData());
		soapModel.setEsfStartData(model.getEsfStartData());
		soapModel.setEsfEndData(model.getEsfEndData());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCodeUser(model.getCodeUser());
		soapModel.setShootingDirectorQualificationId(model.getShootingDirectorQualificationId());
		soapModel.setSportTypeId(model.getSportTypeId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setProvinceId(model.getProvinceId());
		soapModel.setFlagCrea(model.getFlagCrea());
		soapModel.setDateVar(model.getDateVar());

		return soapModel;
	}

	public static ESFShootingDirectorSoap[] toSoapModels(
		ESFShootingDirector[] models) {
		ESFShootingDirectorSoap[] soapModels = new ESFShootingDirectorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFShootingDirectorSoap[][] toSoapModels(
		ESFShootingDirector[][] models) {
		ESFShootingDirectorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFShootingDirectorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFShootingDirectorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFShootingDirectorSoap[] toSoapModels(
		List<ESFShootingDirector> models) {
		List<ESFShootingDirectorSoap> soapModels = new ArrayList<ESFShootingDirectorSoap>(models.size());

		for (ESFShootingDirector model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFShootingDirectorSoap[soapModels.size()]);
	}

	public ESFShootingDirectorSoap() {
	}

	public long getPrimaryKey() {
		return _esfShootingDirectorId;
	}

	public void setPrimaryKey(long pk) {
		setEsfShootingDirectorId(pk);
	}

	public long getEsfShootingDirectorId() {
		return _esfShootingDirectorId;
	}

	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_esfShootingDirectorId = esfShootingDirectorId;
	}

	public String getEsfCodeData() {
		return _esfCodeData;
	}

	public void setEsfCodeData(String esfCodeData) {
		_esfCodeData = esfCodeData;
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

	public Long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(Long esfUserId) {
		_esfUserId = esfUserId;
	}

	public Long getCodeUser() {
		return _codeUser;
	}

	public void setCodeUser(Long codeUser) {
		_codeUser = codeUser;
	}

	public Long getShootingDirectorQualificationId() {
		return _shootingDirectorQualificationId;
	}

	public void setShootingDirectorQualificationId(
		Long shootingDirectorQualificationId) {
		_shootingDirectorQualificationId = shootingDirectorQualificationId;
	}

	public Long getSportTypeId() {
		return _sportTypeId;
	}

	public void setSportTypeId(Long sportTypeId) {
		_sportTypeId = sportTypeId;
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

	public String getFlagCrea() {
		return _flagCrea;
	}

	public void setFlagCrea(String flagCrea) {
		_flagCrea = flagCrea;
	}

	public Date getDateVar() {
		return _DateVar;
	}

	public void setDateVar(Date DateVar) {
		_DateVar = DateVar;
	}

	private long _esfShootingDirectorId;
	private String _esfCodeData;
	private Date _esfStartData;
	private Date _esfEndData;
	private Long _esfUserId;
	private Long _codeUser;
	private Long _shootingDirectorQualificationId;
	private Long _sportTypeId;
	private String _regionId;
	private String _provinceId;
	private String _flagCrea;
	private Date _DateVar;
}