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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFMatch}.
 * </p>
 *
 * @author Ethica
 * @see ESFMatch
 * @generated
 */
public class ESFMatchWrapper implements ESFMatch, ModelWrapper<ESFMatch> {
	public ESFMatchWrapper(ESFMatch esfMatch) {
		_esfMatch = esfMatch;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFMatch.class;
	}

	@Override
	public String getModelClassName() {
		return ESFMatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("startDate", getStartDate());
		attributes.put("startHour", getStartHour());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("esfMatchTypeId", getEsfMatchTypeId());
		attributes.put("isDraft", getIsDraft());
		attributes.put("isTeamMatch", getIsTeamMatch());
		attributes.put("isIndividualMatch", getIsIndividualMatch());
		attributes.put("isJuniorMatch", getIsJuniorMatch());
		attributes.put("numDisk", getNumDisk());
		attributes.put("numDiskTeam", getNumDiskTeam());
		attributes.put("esfAssociationId", getEsfAssociationId());
		attributes.put("notes", getNotes());
		attributes.put("description", getDescription());
		attributes.put("endDate", getEndDate());
		attributes.put("numFields", getNumFields());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isSingleMatch", getIsSingleMatch());
		attributes.put("site", getSite());
		attributes.put("countryId", getCountryId());
		attributes.put("code", getCode());
		attributes.put("isNational", getIsNational());
		attributes.put("HasPenality", getHasPenality());
		attributes.put("isOlimpicQualificationMatch",
			getIsOlimpicQualificationMatch());
		attributes.put("eventType", getEventType());
		attributes.put("notNationalAssotiation", getNotNationalAssotiation());
		attributes.put("isChangeCategoryMatch", getIsChangeCategoryMatch());
		attributes.put("esfNationalSportTypeId", getEsfNationalSportTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String startHour = (String)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		Long esfMatchTypeId = (Long)attributes.get("esfMatchTypeId");

		if (esfMatchTypeId != null) {
			setEsfMatchTypeId(esfMatchTypeId);
		}

		Boolean isDraft = (Boolean)attributes.get("isDraft");

		if (isDraft != null) {
			setIsDraft(isDraft);
		}

		Boolean isTeamMatch = (Boolean)attributes.get("isTeamMatch");

		if (isTeamMatch != null) {
			setIsTeamMatch(isTeamMatch);
		}

		Boolean isIndividualMatch = (Boolean)attributes.get("isIndividualMatch");

		if (isIndividualMatch != null) {
			setIsIndividualMatch(isIndividualMatch);
		}

		Boolean isJuniorMatch = (Boolean)attributes.get("isJuniorMatch");

		if (isJuniorMatch != null) {
			setIsJuniorMatch(isJuniorMatch);
		}

		Integer numDisk = (Integer)attributes.get("numDisk");

		if (numDisk != null) {
			setNumDisk(numDisk);
		}

		Integer numDiskTeam = (Integer)attributes.get("numDiskTeam");

		if (numDiskTeam != null) {
			setNumDiskTeam(numDiskTeam);
		}

		Long esfAssociationId = (Long)attributes.get("esfAssociationId");

		if (esfAssociationId != null) {
			setEsfAssociationId(esfAssociationId);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		Long description = (Long)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer numFields = (Integer)attributes.get("numFields");

		if (numFields != null) {
			setNumFields(numFields);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean isSingleMatch = (Boolean)attributes.get("isSingleMatch");

		if (isSingleMatch != null) {
			setIsSingleMatch(isSingleMatch);
		}

		String site = (String)attributes.get("site");

		if (site != null) {
			setSite(site);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		Boolean HasPenality = (Boolean)attributes.get("HasPenality");

		if (HasPenality != null) {
			setHasPenality(HasPenality);
		}

		Boolean isOlimpicQualificationMatch = (Boolean)attributes.get(
				"isOlimpicQualificationMatch");

		if (isOlimpicQualificationMatch != null) {
			setIsOlimpicQualificationMatch(isOlimpicQualificationMatch);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String notNationalAssotiation = (String)attributes.get(
				"notNationalAssotiation");

		if (notNationalAssotiation != null) {
			setNotNationalAssotiation(notNationalAssotiation);
		}

		Boolean isChangeCategoryMatch = (Boolean)attributes.get(
				"isChangeCategoryMatch");

		if (isChangeCategoryMatch != null) {
			setIsChangeCategoryMatch(isChangeCategoryMatch);
		}

		String esfNationalSportTypeId = (String)attributes.get(
				"esfNationalSportTypeId");

		if (esfNationalSportTypeId != null) {
			setEsfNationalSportTypeId(esfNationalSportTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f match.
	*
	* @return the primary key of this e s f match
	*/
	@Override
	public long getPrimaryKey() {
		return _esfMatch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f match.
	*
	* @param primaryKey the primary key of this e s f match
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfMatch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f match.
	*
	* @return the uuid of this e s f match
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfMatch.getUuid();
	}

	/**
	* Sets the uuid of this e s f match.
	*
	* @param uuid the uuid of this e s f match
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfMatch.setUuid(uuid);
	}

	/**
	* Returns the esf match ID of this e s f match.
	*
	* @return the esf match ID of this e s f match
	*/
	@Override
	public long getEsfMatchId() {
		return _esfMatch.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f match.
	*
	* @param esfMatchId the esf match ID of this e s f match
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatch.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the start date of this e s f match.
	*
	* @return the start date of this e s f match
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfMatch.getStartDate();
	}

	/**
	* Sets the start date of this e s f match.
	*
	* @param startDate the start date of this e s f match
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfMatch.setStartDate(startDate);
	}

	/**
	* Returns the start hour of this e s f match.
	*
	* @return the start hour of this e s f match
	*/
	@Override
	public java.lang.String getStartHour() {
		return _esfMatch.getStartHour();
	}

	/**
	* Sets the start hour of this e s f match.
	*
	* @param startHour the start hour of this e s f match
	*/
	@Override
	public void setStartHour(java.lang.String startHour) {
		_esfMatch.setStartHour(startHour);
	}

	/**
	* Returns the esf sport type ID of this e s f match.
	*
	* @return the esf sport type ID of this e s f match
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfMatch.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f match.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f match
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfMatch.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the esf match type ID of this e s f match.
	*
	* @return the esf match type ID of this e s f match
	*/
	@Override
	public long getEsfMatchTypeId() {
		return _esfMatch.getEsfMatchTypeId();
	}

	/**
	* Sets the esf match type ID of this e s f match.
	*
	* @param esfMatchTypeId the esf match type ID of this e s f match
	*/
	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatch.setEsfMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns the is draft of this e s f match.
	*
	* @return the is draft of this e s f match
	*/
	@Override
	public boolean getIsDraft() {
		return _esfMatch.getIsDraft();
	}

	/**
	* Returns <code>true</code> if this e s f match is is draft.
	*
	* @return <code>true</code> if this e s f match is is draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsDraft() {
		return _esfMatch.isIsDraft();
	}

	/**
	* Sets whether this e s f match is is draft.
	*
	* @param isDraft the is draft of this e s f match
	*/
	@Override
	public void setIsDraft(boolean isDraft) {
		_esfMatch.setIsDraft(isDraft);
	}

	/**
	* Returns the is team match of this e s f match.
	*
	* @return the is team match of this e s f match
	*/
	@Override
	public boolean getIsTeamMatch() {
		return _esfMatch.getIsTeamMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is team match.
	*
	* @return <code>true</code> if this e s f match is is team match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsTeamMatch() {
		return _esfMatch.isIsTeamMatch();
	}

	/**
	* Sets whether this e s f match is is team match.
	*
	* @param isTeamMatch the is team match of this e s f match
	*/
	@Override
	public void setIsTeamMatch(boolean isTeamMatch) {
		_esfMatch.setIsTeamMatch(isTeamMatch);
	}

	/**
	* Returns the is individual match of this e s f match.
	*
	* @return the is individual match of this e s f match
	*/
	@Override
	public boolean getIsIndividualMatch() {
		return _esfMatch.getIsIndividualMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is individual match.
	*
	* @return <code>true</code> if this e s f match is is individual match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsIndividualMatch() {
		return _esfMatch.isIsIndividualMatch();
	}

	/**
	* Sets whether this e s f match is is individual match.
	*
	* @param isIndividualMatch the is individual match of this e s f match
	*/
	@Override
	public void setIsIndividualMatch(boolean isIndividualMatch) {
		_esfMatch.setIsIndividualMatch(isIndividualMatch);
	}

	/**
	* Returns the is junior match of this e s f match.
	*
	* @return the is junior match of this e s f match
	*/
	@Override
	public boolean getIsJuniorMatch() {
		return _esfMatch.getIsJuniorMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is junior match.
	*
	* @return <code>true</code> if this e s f match is is junior match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsJuniorMatch() {
		return _esfMatch.isIsJuniorMatch();
	}

	/**
	* Sets whether this e s f match is is junior match.
	*
	* @param isJuniorMatch the is junior match of this e s f match
	*/
	@Override
	public void setIsJuniorMatch(boolean isJuniorMatch) {
		_esfMatch.setIsJuniorMatch(isJuniorMatch);
	}

	/**
	* Returns the num disk of this e s f match.
	*
	* @return the num disk of this e s f match
	*/
	@Override
	public int getNumDisk() {
		return _esfMatch.getNumDisk();
	}

	/**
	* Sets the num disk of this e s f match.
	*
	* @param numDisk the num disk of this e s f match
	*/
	@Override
	public void setNumDisk(int numDisk) {
		_esfMatch.setNumDisk(numDisk);
	}

	/**
	* Returns the num disk team of this e s f match.
	*
	* @return the num disk team of this e s f match
	*/
	@Override
	public int getNumDiskTeam() {
		return _esfMatch.getNumDiskTeam();
	}

	/**
	* Sets the num disk team of this e s f match.
	*
	* @param numDiskTeam the num disk team of this e s f match
	*/
	@Override
	public void setNumDiskTeam(int numDiskTeam) {
		_esfMatch.setNumDiskTeam(numDiskTeam);
	}

	/**
	* Returns the esf association ID of this e s f match.
	*
	* @return the esf association ID of this e s f match
	*/
	@Override
	public long getEsfAssociationId() {
		return _esfMatch.getEsfAssociationId();
	}

	/**
	* Sets the esf association ID of this e s f match.
	*
	* @param esfAssociationId the esf association ID of this e s f match
	*/
	@Override
	public void setEsfAssociationId(long esfAssociationId) {
		_esfMatch.setEsfAssociationId(esfAssociationId);
	}

	/**
	* Returns the notes of this e s f match.
	*
	* @return the notes of this e s f match
	*/
	@Override
	public java.lang.String getNotes() {
		return _esfMatch.getNotes();
	}

	/**
	* Sets the notes of this e s f match.
	*
	* @param notes the notes of this e s f match
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_esfMatch.setNotes(notes);
	}

	/**
	* Returns the description of this e s f match.
	*
	* @return the description of this e s f match
	*/
	@Override
	public long getDescription() {
		return _esfMatch.getDescription();
	}

	/**
	* Sets the description of this e s f match.
	*
	* @param description the description of this e s f match
	*/
	@Override
	public void setDescription(long description) {
		_esfMatch.setDescription(description);
	}

	/**
	* Returns the end date of this e s f match.
	*
	* @return the end date of this e s f match
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfMatch.getEndDate();
	}

	/**
	* Sets the end date of this e s f match.
	*
	* @param endDate the end date of this e s f match
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfMatch.setEndDate(endDate);
	}

	/**
	* Returns the num fields of this e s f match.
	*
	* @return the num fields of this e s f match
	*/
	@Override
	public int getNumFields() {
		return _esfMatch.getNumFields();
	}

	/**
	* Sets the num fields of this e s f match.
	*
	* @param numFields the num fields of this e s f match
	*/
	@Override
	public void setNumFields(int numFields) {
		_esfMatch.setNumFields(numFields);
	}

	/**
	* Returns the group ID of this e s f match.
	*
	* @return the group ID of this e s f match
	*/
	@Override
	public long getGroupId() {
		return _esfMatch.getGroupId();
	}

	/**
	* Sets the group ID of this e s f match.
	*
	* @param groupId the group ID of this e s f match
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfMatch.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f match.
	*
	* @return the company ID of this e s f match
	*/
	@Override
	public long getCompanyId() {
		return _esfMatch.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f match.
	*
	* @param companyId the company ID of this e s f match
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfMatch.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f match.
	*
	* @return the user ID of this e s f match
	*/
	@Override
	public long getUserId() {
		return _esfMatch.getUserId();
	}

	/**
	* Sets the user ID of this e s f match.
	*
	* @param userId the user ID of this e s f match
	*/
	@Override
	public void setUserId(long userId) {
		_esfMatch.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f match.
	*
	* @return the user uuid of this e s f match
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatch.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f match.
	*
	* @param userUuid the user uuid of this e s f match
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfMatch.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f match.
	*
	* @return the user name of this e s f match
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfMatch.getUserName();
	}

	/**
	* Sets the user name of this e s f match.
	*
	* @param userName the user name of this e s f match
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfMatch.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f match.
	*
	* @return the create date of this e s f match
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfMatch.getCreateDate();
	}

	/**
	* Sets the create date of this e s f match.
	*
	* @param createDate the create date of this e s f match
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfMatch.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f match.
	*
	* @return the modified date of this e s f match
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfMatch.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f match.
	*
	* @param modifiedDate the modified date of this e s f match
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfMatch.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the is single match of this e s f match.
	*
	* @return the is single match of this e s f match
	*/
	@Override
	public boolean getIsSingleMatch() {
		return _esfMatch.getIsSingleMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is single match.
	*
	* @return <code>true</code> if this e s f match is is single match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSingleMatch() {
		return _esfMatch.isIsSingleMatch();
	}

	/**
	* Sets whether this e s f match is is single match.
	*
	* @param isSingleMatch the is single match of this e s f match
	*/
	@Override
	public void setIsSingleMatch(boolean isSingleMatch) {
		_esfMatch.setIsSingleMatch(isSingleMatch);
	}

	/**
	* Returns the site of this e s f match.
	*
	* @return the site of this e s f match
	*/
	@Override
	public java.lang.String getSite() {
		return _esfMatch.getSite();
	}

	/**
	* Sets the site of this e s f match.
	*
	* @param site the site of this e s f match
	*/
	@Override
	public void setSite(java.lang.String site) {
		_esfMatch.setSite(site);
	}

	/**
	* Returns the country ID of this e s f match.
	*
	* @return the country ID of this e s f match
	*/
	@Override
	public long getCountryId() {
		return _esfMatch.getCountryId();
	}

	/**
	* Sets the country ID of this e s f match.
	*
	* @param countryId the country ID of this e s f match
	*/
	@Override
	public void setCountryId(long countryId) {
		_esfMatch.setCountryId(countryId);
	}

	/**
	* Returns the code of this e s f match.
	*
	* @return the code of this e s f match
	*/
	@Override
	public java.lang.String getCode() {
		return _esfMatch.getCode();
	}

	/**
	* Sets the code of this e s f match.
	*
	* @param code the code of this e s f match
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfMatch.setCode(code);
	}

	/**
	* Returns the is national of this e s f match.
	*
	* @return the is national of this e s f match
	*/
	@Override
	public boolean getIsNational() {
		return _esfMatch.getIsNational();
	}

	/**
	* Returns <code>true</code> if this e s f match is is national.
	*
	* @return <code>true</code> if this e s f match is is national; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNational() {
		return _esfMatch.isIsNational();
	}

	/**
	* Sets whether this e s f match is is national.
	*
	* @param isNational the is national of this e s f match
	*/
	@Override
	public void setIsNational(boolean isNational) {
		_esfMatch.setIsNational(isNational);
	}

	/**
	* Returns the has penality of this e s f match.
	*
	* @return the has penality of this e s f match
	*/
	@Override
	public boolean getHasPenality() {
		return _esfMatch.getHasPenality();
	}

	/**
	* Returns <code>true</code> if this e s f match is has penality.
	*
	* @return <code>true</code> if this e s f match is has penality; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasPenality() {
		return _esfMatch.isHasPenality();
	}

	/**
	* Sets whether this e s f match is has penality.
	*
	* @param HasPenality the has penality of this e s f match
	*/
	@Override
	public void setHasPenality(boolean HasPenality) {
		_esfMatch.setHasPenality(HasPenality);
	}

	/**
	* Returns the is olimpic qualification match of this e s f match.
	*
	* @return the is olimpic qualification match of this e s f match
	*/
	@Override
	public boolean getIsOlimpicQualificationMatch() {
		return _esfMatch.getIsOlimpicQualificationMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is olimpic qualification match.
	*
	* @return <code>true</code> if this e s f match is is olimpic qualification match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsOlimpicQualificationMatch() {
		return _esfMatch.isIsOlimpicQualificationMatch();
	}

	/**
	* Sets whether this e s f match is is olimpic qualification match.
	*
	* @param isOlimpicQualificationMatch the is olimpic qualification match of this e s f match
	*/
	@Override
	public void setIsOlimpicQualificationMatch(
		boolean isOlimpicQualificationMatch) {
		_esfMatch.setIsOlimpicQualificationMatch(isOlimpicQualificationMatch);
	}

	/**
	* Returns the event type of this e s f match.
	*
	* @return the event type of this e s f match
	*/
	@Override
	public java.lang.String getEventType() {
		return _esfMatch.getEventType();
	}

	/**
	* Sets the event type of this e s f match.
	*
	* @param eventType the event type of this e s f match
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_esfMatch.setEventType(eventType);
	}

	/**
	* Returns the not national assotiation of this e s f match.
	*
	* @return the not national assotiation of this e s f match
	*/
	@Override
	public java.lang.String getNotNationalAssotiation() {
		return _esfMatch.getNotNationalAssotiation();
	}

	/**
	* Sets the not national assotiation of this e s f match.
	*
	* @param notNationalAssotiation the not national assotiation of this e s f match
	*/
	@Override
	public void setNotNationalAssotiation(
		java.lang.String notNationalAssotiation) {
		_esfMatch.setNotNationalAssotiation(notNationalAssotiation);
	}

	/**
	* Returns the is change category match of this e s f match.
	*
	* @return the is change category match of this e s f match
	*/
	@Override
	public boolean getIsChangeCategoryMatch() {
		return _esfMatch.getIsChangeCategoryMatch();
	}

	/**
	* Returns <code>true</code> if this e s f match is is change category match.
	*
	* @return <code>true</code> if this e s f match is is change category match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsChangeCategoryMatch() {
		return _esfMatch.isIsChangeCategoryMatch();
	}

	/**
	* Sets whether this e s f match is is change category match.
	*
	* @param isChangeCategoryMatch the is change category match of this e s f match
	*/
	@Override
	public void setIsChangeCategoryMatch(boolean isChangeCategoryMatch) {
		_esfMatch.setIsChangeCategoryMatch(isChangeCategoryMatch);
	}

	/**
	* Returns the esf national sport type ID of this e s f match.
	*
	* @return the esf national sport type ID of this e s f match
	*/
	@Override
	public java.lang.String getEsfNationalSportTypeId() {
		return _esfMatch.getEsfNationalSportTypeId();
	}

	/**
	* Sets the esf national sport type ID of this e s f match.
	*
	* @param esfNationalSportTypeId the esf national sport type ID of this e s f match
	*/
	@Override
	public void setEsfNationalSportTypeId(
		java.lang.String esfNationalSportTypeId) {
		_esfMatch.setEsfNationalSportTypeId(esfNationalSportTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfMatch.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfMatch.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfMatch.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfMatch.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfMatch.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfMatch.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfMatch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfMatch.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfMatch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfMatch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfMatch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFMatchWrapper((ESFMatch)_esfMatch.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFMatch esfMatch) {
		return _esfMatch.compareTo(esfMatch);
	}

	@Override
	public int hashCode() {
		return _esfMatch.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFMatch> toCacheModel() {
		return _esfMatch.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFMatch toEscapedModel() {
		return new ESFMatchWrapper(_esfMatch.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFMatch toUnescapedModel() {
		return new ESFMatchWrapper(_esfMatch.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfMatch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfMatch.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfMatch.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFMatchWrapper)) {
			return false;
		}

		ESFMatchWrapper esfMatchWrapper = (ESFMatchWrapper)obj;

		if (Validator.equals(_esfMatch, esfMatchWrapper._esfMatch)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfMatch.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFMatch getWrappedESFMatch() {
		return _esfMatch;
	}

	@Override
	public ESFMatch getWrappedModel() {
		return _esfMatch;
	}

	@Override
	public void resetOriginalValues() {
		_esfMatch.resetOriginalValues();
	}

	private ESFMatch _esfMatch;
}