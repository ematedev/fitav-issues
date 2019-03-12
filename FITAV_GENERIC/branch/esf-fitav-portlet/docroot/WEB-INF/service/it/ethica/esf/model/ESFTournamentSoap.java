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
public class ESFTournamentSoap implements Serializable {
	public static ESFTournamentSoap toSoapModel(ESFTournament model) {
		ESFTournamentSoap soapModel = new ESFTournamentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfTournamentId(model.getEsfTournamentId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setMaxnum(model.getMaxnum());
		soapModel.setMinnum(model.getMinnum());
		soapModel.setIsSingleMatch(model.getIsSingleMatch());
		soapModel.setIsTeamMatch(model.getIsTeamMatch());
		soapModel.setIsIndividualMatch(model.getIsIndividualMatch());
		soapModel.setIsJuniorMatch(model.getIsJuniorMatch());
		soapModel.setIsNationalMatch(model.getIsNationalMatch());
		soapModel.setIsFinal(model.getIsFinal());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ESFTournamentSoap[] toSoapModels(ESFTournament[] models) {
		ESFTournamentSoap[] soapModels = new ESFTournamentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFTournamentSoap[][] toSoapModels(ESFTournament[][] models) {
		ESFTournamentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFTournamentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFTournamentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFTournamentSoap[] toSoapModels(List<ESFTournament> models) {
		List<ESFTournamentSoap> soapModels = new ArrayList<ESFTournamentSoap>(models.size());

		for (ESFTournament model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFTournamentSoap[soapModels.size()]);
	}

	public ESFTournamentSoap() {
	}

	public long getPrimaryKey() {
		return _esfTournamentId;
	}

	public void setPrimaryKey(long pk) {
		setEsfTournamentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournamentId = esfTournamentId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getMaxnum() {
		return _maxnum;
	}

	public void setMaxnum(long maxnum) {
		_maxnum = maxnum;
	}

	public long getMinnum() {
		return _minnum;
	}

	public void setMinnum(long minnum) {
		_minnum = minnum;
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

	public boolean getIsNationalMatch() {
		return _isNationalMatch;
	}

	public boolean isIsNationalMatch() {
		return _isNationalMatch;
	}

	public void setIsNationalMatch(boolean isNationalMatch) {
		_isNationalMatch = isNationalMatch;
	}

	public boolean getIsFinal() {
		return _isFinal;
	}

	public boolean isIsFinal() {
		return _isFinal;
	}

	public void setIsFinal(boolean isFinal) {
		_isFinal = isFinal;
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

	private String _uuid;
	private long _esfTournamentId;
	private long _esfOrganizationId;
	private String _title;
	private String _description;
	private long _maxnum;
	private long _minnum;
	private boolean _isSingleMatch;
	private boolean _isTeamMatch;
	private boolean _isIndividualMatch;
	private boolean _isJuniorMatch;
	private boolean _isNationalMatch;
	private boolean _isFinal;
	private Date _startDate;
	private Date _endDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}