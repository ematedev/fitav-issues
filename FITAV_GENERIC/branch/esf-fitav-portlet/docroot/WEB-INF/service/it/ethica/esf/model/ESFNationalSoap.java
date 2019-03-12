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
public class ESFNationalSoap implements Serializable {
	public static ESFNationalSoap toSoapModel(ESFNational model) {
		ESFNationalSoap soapModel = new ESFNationalSoap();

		soapModel.setEsfNationalId(model.getEsfNationalId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setBDODate(model.getBDODate());
		soapModel.setIdInternational(model.getIdInternational());
		soapModel.setIsUniversity(model.getIsUniversity());
		soapModel.setIsNational(model.getIsNational());
		soapModel.setDeliberate(model.getDeliberate());
		soapModel.setDeliberateDate(model.getDeliberateDate());

		return soapModel;
	}

	public static ESFNationalSoap[] toSoapModels(ESFNational[] models) {
		ESFNationalSoap[] soapModels = new ESFNationalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalSoap[][] toSoapModels(ESFNational[][] models) {
		ESFNationalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFNationalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFNationalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFNationalSoap[] toSoapModels(List<ESFNational> models) {
		List<ESFNationalSoap> soapModels = new ArrayList<ESFNationalSoap>(models.size());

		for (ESFNational model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFNationalSoap[soapModels.size()]);
	}

	public ESFNationalSoap() {
	}

	public long getPrimaryKey() {
		return _esfNationalId;
	}

	public void setPrimaryKey(long pk) {
		setEsfNationalId(pk);
	}

	public long getEsfNationalId() {
		return _esfNationalId;
	}

	public void setEsfNationalId(long esfNationalId) {
		_esfNationalId = esfNationalId;
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

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getBDODate() {
		return _BDODate;
	}

	public void setBDODate(Date BDODate) {
		_BDODate = BDODate;
	}

	public String getIdInternational() {
		return _idInternational;
	}

	public void setIdInternational(String idInternational) {
		_idInternational = idInternational;
	}

	public boolean getIsUniversity() {
		return _isUniversity;
	}

	public boolean isIsUniversity() {
		return _isUniversity;
	}

	public void setIsUniversity(boolean isUniversity) {
		_isUniversity = isUniversity;
	}

	public boolean getIsNational() {
		return _isNational;
	}

	public boolean isIsNational() {
		return _isNational;
	}

	public void setIsNational(boolean isNational) {
		_isNational = isNational;
	}

	public String getDeliberate() {
		return _deliberate;
	}

	public void setDeliberate(String deliberate) {
		_deliberate = deliberate;
	}

	public Date getDeliberateDate() {
		return _deliberateDate;
	}

	public void setDeliberateDate(Date deliberateDate) {
		_deliberateDate = deliberateDate;
	}

	private long _esfNationalId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private long _esfSportTypeId;
	private Date _startDate;
	private Date _endDate;
	private Date _BDODate;
	private String _idInternational;
	private boolean _isUniversity;
	private boolean _isNational;
	private String _deliberate;
	private Date _deliberateDate;
}