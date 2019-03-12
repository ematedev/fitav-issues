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
public class ESFMatchSoap implements Serializable {
	public static ESFMatchSoap toSoapModel(ESFMatch model) {
		ESFMatchSoap soapModel = new ESFMatchSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setStartHour(model.getStartHour());
		soapModel.setEsfSportTypeId(model.getEsfSportTypeId());
		soapModel.setEsfMatchTypeId(model.getEsfMatchTypeId());
		soapModel.setIsDraft(model.getIsDraft());
		soapModel.setIsTeamMatch(model.getIsTeamMatch());
		soapModel.setIsIndividualMatch(model.getIsIndividualMatch());
		soapModel.setIsJuniorMatch(model.getIsJuniorMatch());
		soapModel.setNumDisk(model.getNumDisk());
		soapModel.setNumDiskTeam(model.getNumDiskTeam());
		soapModel.setEsfAssociationId(model.getEsfAssociationId());
		soapModel.setNotes(model.getNotes());
		soapModel.setDescription(model.getDescription());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setNumFields(model.getNumFields());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsSingleMatch(model.getIsSingleMatch());
		soapModel.setSite(model.getSite());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCode(model.getCode());
		soapModel.setIsNational(model.getIsNational());
		soapModel.setHasPenality(model.getHasPenality());
		soapModel.setIsOlimpicQualificationMatch(model.getIsOlimpicQualificationMatch());
		soapModel.setEventType(model.getEventType());
		soapModel.setNotNationalAssotiation(model.getNotNationalAssotiation());
		soapModel.setIsChangeCategoryMatch(model.getIsChangeCategoryMatch());
		soapModel.setEsfNationalSportTypeId(model.getEsfNationalSportTypeId());
		soapModel.setOldCode(model.getOldCode());

		return soapModel;
	}

	public static ESFMatchSoap[] toSoapModels(ESFMatch[] models) {
		ESFMatchSoap[] soapModels = new ESFMatchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchSoap[][] toSoapModels(ESFMatch[][] models) {
		ESFMatchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFMatchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFMatchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFMatchSoap[] toSoapModels(List<ESFMatch> models) {
		List<ESFMatchSoap> soapModels = new ArrayList<ESFMatchSoap>(models.size());

		for (ESFMatch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFMatchSoap[soapModels.size()]);
	}

	public ESFMatchSoap() {
	}

	public long getPrimaryKey() {
		return _esfMatchId;
	}

	public void setPrimaryKey(long pk) {
		setEsfMatchId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public String getStartHour() {
		return _startHour;
	}

	public void setStartHour(String startHour) {
		_startHour = startHour;
	}

	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;
	}

	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;
	}

	public boolean getIsDraft() {
		return _isDraft;
	}

	public boolean isIsDraft() {
		return _isDraft;
	}

	public void setIsDraft(boolean isDraft) {
		_isDraft = isDraft;
	}

	public boolean getIsTeamMatch() {
		return _isTeamMatch;
	}

	public boolean isIsTeamMatch() {
		return _isTeamMatch;
	}

	public void setIsTeamMatch(boolean isTeamMatch) {
		_isTeamMatch = isTeamMatch;
	}

	public boolean getIsIndividualMatch() {
		return _isIndividualMatch;
	}

	public boolean isIsIndividualMatch() {
		return _isIndividualMatch;
	}

	public void setIsIndividualMatch(boolean isIndividualMatch) {
		_isIndividualMatch = isIndividualMatch;
	}

	public boolean getIsJuniorMatch() {
		return _isJuniorMatch;
	}

	public boolean isIsJuniorMatch() {
		return _isJuniorMatch;
	}

	public void setIsJuniorMatch(boolean isJuniorMatch) {
		_isJuniorMatch = isJuniorMatch;
	}

	public int getNumDisk() {
		return _numDisk;
	}

	public void setNumDisk(int numDisk) {
		_numDisk = numDisk;
	}

	public int getNumDiskTeam() {
		return _numDiskTeam;
	}

	public void setNumDiskTeam(int numDiskTeam) {
		_numDiskTeam = numDiskTeam;
	}

	public long getEsfAssociationId() {
		return _esfAssociationId;
	}

	public void setEsfAssociationId(long esfAssociationId) {
		_esfAssociationId = esfAssociationId;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public long getDescription() {
		return _description;
	}

	public void setDescription(long description) {
		_description = description;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getNumFields() {
		return _numFields;
	}

	public void setNumFields(int numFields) {
		_numFields = numFields;
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

	public boolean getIsSingleMatch() {
		return _isSingleMatch;
	}

	public boolean isIsSingleMatch() {
		return _isSingleMatch;
	}

	public void setIsSingleMatch(boolean isSingleMatch) {
		_isSingleMatch = isSingleMatch;
	}

	public String getSite() {
		return _site;
	}

	public void setSite(String site) {
		_site = site;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
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

	public boolean getHasPenality() {
		return _HasPenality;
	}

	public boolean isHasPenality() {
		return _HasPenality;
	}

	public void setHasPenality(boolean HasPenality) {
		_HasPenality = HasPenality;
	}

	public boolean getIsOlimpicQualificationMatch() {
		return _isOlimpicQualificationMatch;
	}

	public boolean isIsOlimpicQualificationMatch() {
		return _isOlimpicQualificationMatch;
	}

	public void setIsOlimpicQualificationMatch(
		boolean isOlimpicQualificationMatch) {
		_isOlimpicQualificationMatch = isOlimpicQualificationMatch;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getNotNationalAssotiation() {
		return _notNationalAssotiation;
	}

	public void setNotNationalAssotiation(String notNationalAssotiation) {
		_notNationalAssotiation = notNationalAssotiation;
	}

	public boolean getIsChangeCategoryMatch() {
		return _isChangeCategoryMatch;
	}

	public boolean isIsChangeCategoryMatch() {
		return _isChangeCategoryMatch;
	}

	public void setIsChangeCategoryMatch(boolean isChangeCategoryMatch) {
		_isChangeCategoryMatch = isChangeCategoryMatch;
	}

	public String getEsfNationalSportTypeId() {
		return _esfNationalSportTypeId;
	}

	public void setEsfNationalSportTypeId(String esfNationalSportTypeId) {
		_esfNationalSportTypeId = esfNationalSportTypeId;
	}

	public String getOldCode() {
		return _oldCode;
	}

	public void setOldCode(String oldCode) {
		_oldCode = oldCode;
	}

	private String _uuid;
	private long _esfMatchId;
	private Date _startDate;
	private String _startHour;
	private long _esfSportTypeId;
	private long _esfMatchTypeId;
	private boolean _isDraft;
	private boolean _isTeamMatch;
	private boolean _isIndividualMatch;
	private boolean _isJuniorMatch;
	private int _numDisk;
	private int _numDiskTeam;
	private long _esfAssociationId;
	private String _notes;
	private long _description;
	private Date _endDate;
	private int _numFields;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _isSingleMatch;
	private String _site;
	private long _countryId;
	private String _code;
	private boolean _isNational;
	private boolean _HasPenality;
	private boolean _isOlimpicQualificationMatch;
	private String _eventType;
	private String _notNationalAssotiation;
	private boolean _isChangeCategoryMatch;
	private String _esfNationalSportTypeId;
	private String _oldCode;
}