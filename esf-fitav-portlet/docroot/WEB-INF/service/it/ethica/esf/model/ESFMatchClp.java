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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFMatchClp extends BaseModelImpl<ESFMatch> implements ESFMatch {
	public ESFMatchClp() {
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
	public long getPrimaryKey() {
		return _esfMatchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfMatchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfMatchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("oldCode", getOldCode());
		attributes.put("matchYear", getMatchYear());
		attributes.put("matchYearSeq", getMatchYearSeq());

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

		String oldCode = (String)attributes.get("oldCode");

		if (oldCode != null) {
			setOldCode(oldCode);
		}

		Integer matchYear = (Integer)attributes.get("matchYear");

		if (matchYear != null) {
			setMatchYear(matchYear);
		}

		Integer matchYearSeq = (Integer)attributes.get("matchYearSeq");

		if (matchYearSeq != null) {
			setMatchYearSeq(matchYearSeq);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfMatchRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfMatchRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_esfMatchRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartHour() {
		return _startHour;
	}

	@Override
	public void setStartHour(String startHour) {
		_startHour = startHour;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setStartHour", String.class);

				method.invoke(_esfMatchRemoteModel, startHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_esfMatchRemoteModel, esfSportTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchTypeId() {
		return _esfMatchTypeId;
	}

	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchTypeId = esfMatchTypeId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchTypeId", long.class);

				method.invoke(_esfMatchRemoteModel, esfMatchTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsDraft() {
		return _isDraft;
	}

	@Override
	public boolean isIsDraft() {
		return _isDraft;
	}

	@Override
	public void setIsDraft(boolean isDraft) {
		_isDraft = isDraft;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDraft", boolean.class);

				method.invoke(_esfMatchRemoteModel, isDraft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsTeamMatch() {
		return _isTeamMatch;
	}

	@Override
	public boolean isIsTeamMatch() {
		return _isTeamMatch;
	}

	@Override
	public void setIsTeamMatch(boolean isTeamMatch) {
		_isTeamMatch = isTeamMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsTeamMatch", boolean.class);

				method.invoke(_esfMatchRemoteModel, isTeamMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsIndividualMatch() {
		return _isIndividualMatch;
	}

	@Override
	public boolean isIsIndividualMatch() {
		return _isIndividualMatch;
	}

	@Override
	public void setIsIndividualMatch(boolean isIndividualMatch) {
		_isIndividualMatch = isIndividualMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsIndividualMatch",
						boolean.class);

				method.invoke(_esfMatchRemoteModel, isIndividualMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsJuniorMatch() {
		return _isJuniorMatch;
	}

	@Override
	public boolean isIsJuniorMatch() {
		return _isJuniorMatch;
	}

	@Override
	public void setIsJuniorMatch(boolean isJuniorMatch) {
		_isJuniorMatch = isJuniorMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsJuniorMatch",
						boolean.class);

				method.invoke(_esfMatchRemoteModel, isJuniorMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumDisk() {
		return _numDisk;
	}

	@Override
	public void setNumDisk(int numDisk) {
		_numDisk = numDisk;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setNumDisk", int.class);

				method.invoke(_esfMatchRemoteModel, numDisk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumDiskTeam() {
		return _numDiskTeam;
	}

	@Override
	public void setNumDiskTeam(int numDiskTeam) {
		_numDiskTeam = numDiskTeam;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setNumDiskTeam", int.class);

				method.invoke(_esfMatchRemoteModel, numDiskTeam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfAssociationId() {
		return _esfAssociationId;
	}

	@Override
	public void setEsfAssociationId(long esfAssociationId) {
		_esfAssociationId = esfAssociationId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfAssociationId",
						long.class);

				method.invoke(_esfMatchRemoteModel, esfAssociationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_esfMatchRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDescription() {
		return _description;
	}

	@Override
	public void setDescription(long description) {
		_description = description;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", long.class);

				method.invoke(_esfMatchRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfMatchRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumFields() {
		return _numFields;
	}

	@Override
	public void setNumFields(int numFields) {
		_numFields = numFields;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setNumFields", int.class);

				method.invoke(_esfMatchRemoteModel, numFields);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfMatchRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfMatchRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfMatchRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfMatchRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfMatchRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfMatchRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsSingleMatch() {
		return _isSingleMatch;
	}

	@Override
	public boolean isIsSingleMatch() {
		return _isSingleMatch;
	}

	@Override
	public void setIsSingleMatch(boolean isSingleMatch) {
		_isSingleMatch = isSingleMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSingleMatch",
						boolean.class);

				method.invoke(_esfMatchRemoteModel, isSingleMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSite() {
		return _site;
	}

	@Override
	public void setSite(String site) {
		_site = site;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setSite", String.class);

				method.invoke(_esfMatchRemoteModel, site);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_esfMatchRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfMatchRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsNational() {
		return _isNational;
	}

	@Override
	public boolean isIsNational() {
		return _isNational;
	}

	@Override
	public void setIsNational(boolean isNational) {
		_isNational = isNational;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsNational", boolean.class);

				method.invoke(_esfMatchRemoteModel, isNational);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasPenality() {
		return _HasPenality;
	}

	@Override
	public boolean isHasPenality() {
		return _HasPenality;
	}

	@Override
	public void setHasPenality(boolean HasPenality) {
		_HasPenality = HasPenality;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setHasPenality", boolean.class);

				method.invoke(_esfMatchRemoteModel, HasPenality);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsOlimpicQualificationMatch() {
		return _isOlimpicQualificationMatch;
	}

	@Override
	public boolean isIsOlimpicQualificationMatch() {
		return _isOlimpicQualificationMatch;
	}

	@Override
	public void setIsOlimpicQualificationMatch(
		boolean isOlimpicQualificationMatch) {
		_isOlimpicQualificationMatch = isOlimpicQualificationMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsOlimpicQualificationMatch",
						boolean.class);

				method.invoke(_esfMatchRemoteModel, isOlimpicQualificationMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventType() {
		return _eventType;
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_esfMatchRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotNationalAssotiation() {
		return _notNationalAssotiation;
	}

	@Override
	public void setNotNationalAssotiation(String notNationalAssotiation) {
		_notNationalAssotiation = notNationalAssotiation;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setNotNationalAssotiation",
						String.class);

				method.invoke(_esfMatchRemoteModel, notNationalAssotiation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsChangeCategoryMatch() {
		return _isChangeCategoryMatch;
	}

	@Override
	public boolean isIsChangeCategoryMatch() {
		return _isChangeCategoryMatch;
	}

	@Override
	public void setIsChangeCategoryMatch(boolean isChangeCategoryMatch) {
		_isChangeCategoryMatch = isChangeCategoryMatch;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setIsChangeCategoryMatch",
						boolean.class);

				method.invoke(_esfMatchRemoteModel, isChangeCategoryMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfNationalSportTypeId() {
		return _esfNationalSportTypeId;
	}

	@Override
	public void setEsfNationalSportTypeId(String esfNationalSportTypeId) {
		_esfNationalSportTypeId = esfNationalSportTypeId;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfNationalSportTypeId",
						String.class);

				method.invoke(_esfMatchRemoteModel, esfNationalSportTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOldCode() {
		return _oldCode;
	}

	@Override
	public void setOldCode(String oldCode) {
		_oldCode = oldCode;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setOldCode", String.class);

				method.invoke(_esfMatchRemoteModel, oldCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMatchYear() {
		return _matchYear;
	}

	@Override
	public void setMatchYear(int matchYear) {
		_matchYear = matchYear;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setMatchYear", int.class);

				method.invoke(_esfMatchRemoteModel, matchYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMatchYearSeq() {
		return _matchYearSeq;
	}

	@Override
	public void setMatchYearSeq(int matchYearSeq) {
		_matchYearSeq = matchYearSeq;

		if (_esfMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setMatchYearSeq", int.class);

				method.invoke(_esfMatchRemoteModel, matchYearSeq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFMatch.class.getName()));
	}

	public BaseModel<?> getESFMatchRemoteModel() {
		return _esfMatchRemoteModel;
	}

	public void setESFMatchRemoteModel(BaseModel<?> esfMatchRemoteModel) {
		_esfMatchRemoteModel = esfMatchRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfMatchRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfMatchRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFMatchLocalServiceUtil.addESFMatch(this);
		}
		else {
			ESFMatchLocalServiceUtil.updateESFMatch(this);
		}
	}

	@Override
	public ESFMatch toEscapedModel() {
		return (ESFMatch)ProxyUtil.newProxyInstance(ESFMatch.class.getClassLoader(),
			new Class[] { ESFMatch.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFMatchClp clone = new ESFMatchClp();

		clone.setUuid(getUuid());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setStartDate(getStartDate());
		clone.setStartHour(getStartHour());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setEsfMatchTypeId(getEsfMatchTypeId());
		clone.setIsDraft(getIsDraft());
		clone.setIsTeamMatch(getIsTeamMatch());
		clone.setIsIndividualMatch(getIsIndividualMatch());
		clone.setIsJuniorMatch(getIsJuniorMatch());
		clone.setNumDisk(getNumDisk());
		clone.setNumDiskTeam(getNumDiskTeam());
		clone.setEsfAssociationId(getEsfAssociationId());
		clone.setNotes(getNotes());
		clone.setDescription(getDescription());
		clone.setEndDate(getEndDate());
		clone.setNumFields(getNumFields());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIsSingleMatch(getIsSingleMatch());
		clone.setSite(getSite());
		clone.setCountryId(getCountryId());
		clone.setCode(getCode());
		clone.setIsNational(getIsNational());
		clone.setHasPenality(getHasPenality());
		clone.setIsOlimpicQualificationMatch(getIsOlimpicQualificationMatch());
		clone.setEventType(getEventType());
		clone.setNotNationalAssotiation(getNotNationalAssotiation());
		clone.setIsChangeCategoryMatch(getIsChangeCategoryMatch());
		clone.setEsfNationalSportTypeId(getEsfNationalSportTypeId());
		clone.setOldCode(getOldCode());
		clone.setMatchYear(getMatchYear());
		clone.setMatchYearSeq(getMatchYearSeq());

		return clone;
	}

	@Override
	public int compareTo(ESFMatch esfMatch) {
		long primaryKey = esfMatch.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFMatchClp)) {
			return false;
		}

		ESFMatchClp esfMatch = (ESFMatchClp)obj;

		long primaryKey = esfMatch.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", startHour=");
		sb.append(getStartHour());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", esfMatchTypeId=");
		sb.append(getEsfMatchTypeId());
		sb.append(", isDraft=");
		sb.append(getIsDraft());
		sb.append(", isTeamMatch=");
		sb.append(getIsTeamMatch());
		sb.append(", isIndividualMatch=");
		sb.append(getIsIndividualMatch());
		sb.append(", isJuniorMatch=");
		sb.append(getIsJuniorMatch());
		sb.append(", numDisk=");
		sb.append(getNumDisk());
		sb.append(", numDiskTeam=");
		sb.append(getNumDiskTeam());
		sb.append(", esfAssociationId=");
		sb.append(getEsfAssociationId());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", numFields=");
		sb.append(getNumFields());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", isSingleMatch=");
		sb.append(getIsSingleMatch());
		sb.append(", site=");
		sb.append(getSite());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", isNational=");
		sb.append(getIsNational());
		sb.append(", HasPenality=");
		sb.append(getHasPenality());
		sb.append(", isOlimpicQualificationMatch=");
		sb.append(getIsOlimpicQualificationMatch());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", notNationalAssotiation=");
		sb.append(getNotNationalAssotiation());
		sb.append(", isChangeCategoryMatch=");
		sb.append(getIsChangeCategoryMatch());
		sb.append(", esfNationalSportTypeId=");
		sb.append(getEsfNationalSportTypeId());
		sb.append(", oldCode=");
		sb.append(getOldCode());
		sb.append(", matchYear=");
		sb.append(getMatchYear());
		sb.append(", matchYearSeq=");
		sb.append(getMatchYearSeq());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFMatch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startHour</column-name><column-value><![CDATA[");
		sb.append(getStartHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDraft</column-name><column-value><![CDATA[");
		sb.append(getIsDraft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTeamMatch</column-name><column-value><![CDATA[");
		sb.append(getIsTeamMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isIndividualMatch</column-name><column-value><![CDATA[");
		sb.append(getIsIndividualMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isJuniorMatch</column-name><column-value><![CDATA[");
		sb.append(getIsJuniorMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numDisk</column-name><column-value><![CDATA[");
		sb.append(getNumDisk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numDiskTeam</column-name><column-value><![CDATA[");
		sb.append(getNumDiskTeam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfAssociationId</column-name><column-value><![CDATA[");
		sb.append(getEsfAssociationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numFields</column-name><column-value><![CDATA[");
		sb.append(getNumFields());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSingleMatch</column-name><column-value><![CDATA[");
		sb.append(getIsSingleMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>site</column-name><column-value><![CDATA[");
		sb.append(getSite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNational</column-name><column-value><![CDATA[");
		sb.append(getIsNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>HasPenality</column-name><column-value><![CDATA[");
		sb.append(getHasPenality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isOlimpicQualificationMatch</column-name><column-value><![CDATA[");
		sb.append(getIsOlimpicQualificationMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notNationalAssotiation</column-name><column-value><![CDATA[");
		sb.append(getNotNationalAssotiation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isChangeCategoryMatch</column-name><column-value><![CDATA[");
		sb.append(getIsChangeCategoryMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfNationalSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oldCode</column-name><column-value><![CDATA[");
		sb.append(getOldCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matchYear</column-name><column-value><![CDATA[");
		sb.append(getMatchYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matchYearSeq</column-name><column-value><![CDATA[");
		sb.append(getMatchYearSeq());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
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
	private int _matchYear;
	private int _matchYearSeq;
	private BaseModel<?> _esfMatchRemoteModel;
}