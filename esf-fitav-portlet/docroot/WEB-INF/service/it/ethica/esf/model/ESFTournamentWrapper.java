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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFTournament}.
 * </p>
 *
 * @author Ethica
 * @see ESFTournament
 * @generated
 */
public class ESFTournamentWrapper implements ESFTournament,
	ModelWrapper<ESFTournament> {
	public ESFTournamentWrapper(ESFTournament esfTournament) {
		_esfTournament = esfTournament;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTournament.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("maxnum", getMaxnum());
		attributes.put("minnum", getMinnum());
		attributes.put("isSingleMatch", getIsSingleMatch());
		attributes.put("isTeamMatch", getIsTeamMatch());
		attributes.put("isIndividualMatch", getIsIndividualMatch());
		attributes.put("isJuniorMatch", getIsJuniorMatch());
		attributes.put("isNationalMatch", getIsNationalMatch());
		attributes.put("isFinal", getIsFinal());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long maxnum = (Long)attributes.get("maxnum");

		if (maxnum != null) {
			setMaxnum(maxnum);
		}

		Long minnum = (Long)attributes.get("minnum");

		if (minnum != null) {
			setMinnum(minnum);
		}

		Boolean isSingleMatch = (Boolean)attributes.get("isSingleMatch");

		if (isSingleMatch != null) {
			setIsSingleMatch(isSingleMatch);
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

		Boolean isNationalMatch = (Boolean)attributes.get("isNationalMatch");

		if (isNationalMatch != null) {
			setIsNationalMatch(isNationalMatch);
		}

		Boolean isFinal = (Boolean)attributes.get("isFinal");

		if (isFinal != null) {
			setIsFinal(isFinal);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
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
	}

	/**
	* Returns the primary key of this e s f tournament.
	*
	* @return the primary key of this e s f tournament
	*/
	@Override
	public long getPrimaryKey() {
		return _esfTournament.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f tournament.
	*
	* @param primaryKey the primary key of this e s f tournament
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfTournament.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f tournament.
	*
	* @return the uuid of this e s f tournament
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfTournament.getUuid();
	}

	/**
	* Sets the uuid of this e s f tournament.
	*
	* @param uuid the uuid of this e s f tournament
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfTournament.setUuid(uuid);
	}

	/**
	* Returns the esf tournament ID of this e s f tournament.
	*
	* @return the esf tournament ID of this e s f tournament
	*/
	@Override
	public long getEsfTournamentId() {
		return _esfTournament.getEsfTournamentId();
	}

	/**
	* Sets the esf tournament ID of this e s f tournament.
	*
	* @param esfTournamentId the esf tournament ID of this e s f tournament
	*/
	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournament.setEsfTournamentId(esfTournamentId);
	}

	/**
	* Returns the esf organization ID of this e s f tournament.
	*
	* @return the esf organization ID of this e s f tournament
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfTournament.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f tournament.
	*
	* @param esfOrganizationId the esf organization ID of this e s f tournament
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfTournament.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the title of this e s f tournament.
	*
	* @return the title of this e s f tournament
	*/
	@Override
	public java.lang.String getTitle() {
		return _esfTournament.getTitle();
	}

	/**
	* Sets the title of this e s f tournament.
	*
	* @param title the title of this e s f tournament
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_esfTournament.setTitle(title);
	}

	/**
	* Returns the description of this e s f tournament.
	*
	* @return the description of this e s f tournament
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfTournament.getDescription();
	}

	/**
	* Sets the description of this e s f tournament.
	*
	* @param description the description of this e s f tournament
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfTournament.setDescription(description);
	}

	/**
	* Returns the maxnum of this e s f tournament.
	*
	* @return the maxnum of this e s f tournament
	*/
	@Override
	public long getMaxnum() {
		return _esfTournament.getMaxnum();
	}

	/**
	* Sets the maxnum of this e s f tournament.
	*
	* @param maxnum the maxnum of this e s f tournament
	*/
	@Override
	public void setMaxnum(long maxnum) {
		_esfTournament.setMaxnum(maxnum);
	}

	/**
	* Returns the minnum of this e s f tournament.
	*
	* @return the minnum of this e s f tournament
	*/
	@Override
	public long getMinnum() {
		return _esfTournament.getMinnum();
	}

	/**
	* Sets the minnum of this e s f tournament.
	*
	* @param minnum the minnum of this e s f tournament
	*/
	@Override
	public void setMinnum(long minnum) {
		_esfTournament.setMinnum(minnum);
	}

	/**
	* Returns the is single match of this e s f tournament.
	*
	* @return the is single match of this e s f tournament
	*/
	@Override
	public boolean getIsSingleMatch() {
		return _esfTournament.getIsSingleMatch();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is single match.
	*
	* @return <code>true</code> if this e s f tournament is is single match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSingleMatch() {
		return _esfTournament.isIsSingleMatch();
	}

	/**
	* Sets whether this e s f tournament is is single match.
	*
	* @param isSingleMatch the is single match of this e s f tournament
	*/
	@Override
	public void setIsSingleMatch(boolean isSingleMatch) {
		_esfTournament.setIsSingleMatch(isSingleMatch);
	}

	/**
	* Returns the is team match of this e s f tournament.
	*
	* @return the is team match of this e s f tournament
	*/
	@Override
	public boolean getIsTeamMatch() {
		return _esfTournament.getIsTeamMatch();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is team match.
	*
	* @return <code>true</code> if this e s f tournament is is team match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsTeamMatch() {
		return _esfTournament.isIsTeamMatch();
	}

	/**
	* Sets whether this e s f tournament is is team match.
	*
	* @param isTeamMatch the is team match of this e s f tournament
	*/
	@Override
	public void setIsTeamMatch(boolean isTeamMatch) {
		_esfTournament.setIsTeamMatch(isTeamMatch);
	}

	/**
	* Returns the is individual match of this e s f tournament.
	*
	* @return the is individual match of this e s f tournament
	*/
	@Override
	public boolean getIsIndividualMatch() {
		return _esfTournament.getIsIndividualMatch();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is individual match.
	*
	* @return <code>true</code> if this e s f tournament is is individual match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsIndividualMatch() {
		return _esfTournament.isIsIndividualMatch();
	}

	/**
	* Sets whether this e s f tournament is is individual match.
	*
	* @param isIndividualMatch the is individual match of this e s f tournament
	*/
	@Override
	public void setIsIndividualMatch(boolean isIndividualMatch) {
		_esfTournament.setIsIndividualMatch(isIndividualMatch);
	}

	/**
	* Returns the is junior match of this e s f tournament.
	*
	* @return the is junior match of this e s f tournament
	*/
	@Override
	public boolean getIsJuniorMatch() {
		return _esfTournament.getIsJuniorMatch();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is junior match.
	*
	* @return <code>true</code> if this e s f tournament is is junior match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsJuniorMatch() {
		return _esfTournament.isIsJuniorMatch();
	}

	/**
	* Sets whether this e s f tournament is is junior match.
	*
	* @param isJuniorMatch the is junior match of this e s f tournament
	*/
	@Override
	public void setIsJuniorMatch(boolean isJuniorMatch) {
		_esfTournament.setIsJuniorMatch(isJuniorMatch);
	}

	/**
	* Returns the is national match of this e s f tournament.
	*
	* @return the is national match of this e s f tournament
	*/
	@Override
	public boolean getIsNationalMatch() {
		return _esfTournament.getIsNationalMatch();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is national match.
	*
	* @return <code>true</code> if this e s f tournament is is national match; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNationalMatch() {
		return _esfTournament.isIsNationalMatch();
	}

	/**
	* Sets whether this e s f tournament is is national match.
	*
	* @param isNationalMatch the is national match of this e s f tournament
	*/
	@Override
	public void setIsNationalMatch(boolean isNationalMatch) {
		_esfTournament.setIsNationalMatch(isNationalMatch);
	}

	/**
	* Returns the is final of this e s f tournament.
	*
	* @return the is final of this e s f tournament
	*/
	@Override
	public boolean getIsFinal() {
		return _esfTournament.getIsFinal();
	}

	/**
	* Returns <code>true</code> if this e s f tournament is is final.
	*
	* @return <code>true</code> if this e s f tournament is is final; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsFinal() {
		return _esfTournament.isIsFinal();
	}

	/**
	* Sets whether this e s f tournament is is final.
	*
	* @param isFinal the is final of this e s f tournament
	*/
	@Override
	public void setIsFinal(boolean isFinal) {
		_esfTournament.setIsFinal(isFinal);
	}

	/**
	* Returns the start date of this e s f tournament.
	*
	* @return the start date of this e s f tournament
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfTournament.getStartDate();
	}

	/**
	* Sets the start date of this e s f tournament.
	*
	* @param startDate the start date of this e s f tournament
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfTournament.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f tournament.
	*
	* @return the end date of this e s f tournament
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfTournament.getEndDate();
	}

	/**
	* Sets the end date of this e s f tournament.
	*
	* @param endDate the end date of this e s f tournament
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfTournament.setEndDate(endDate);
	}

	/**
	* Returns the group ID of this e s f tournament.
	*
	* @return the group ID of this e s f tournament
	*/
	@Override
	public long getGroupId() {
		return _esfTournament.getGroupId();
	}

	/**
	* Sets the group ID of this e s f tournament.
	*
	* @param groupId the group ID of this e s f tournament
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfTournament.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f tournament.
	*
	* @return the company ID of this e s f tournament
	*/
	@Override
	public long getCompanyId() {
		return _esfTournament.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f tournament.
	*
	* @param companyId the company ID of this e s f tournament
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfTournament.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f tournament.
	*
	* @return the user ID of this e s f tournament
	*/
	@Override
	public long getUserId() {
		return _esfTournament.getUserId();
	}

	/**
	* Sets the user ID of this e s f tournament.
	*
	* @param userId the user ID of this e s f tournament
	*/
	@Override
	public void setUserId(long userId) {
		_esfTournament.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f tournament.
	*
	* @return the user uuid of this e s f tournament
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTournament.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f tournament.
	*
	* @param userUuid the user uuid of this e s f tournament
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfTournament.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f tournament.
	*
	* @return the user name of this e s f tournament
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfTournament.getUserName();
	}

	/**
	* Sets the user name of this e s f tournament.
	*
	* @param userName the user name of this e s f tournament
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfTournament.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f tournament.
	*
	* @return the create date of this e s f tournament
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfTournament.getCreateDate();
	}

	/**
	* Sets the create date of this e s f tournament.
	*
	* @param createDate the create date of this e s f tournament
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfTournament.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f tournament.
	*
	* @return the modified date of this e s f tournament
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfTournament.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f tournament.
	*
	* @param modifiedDate the modified date of this e s f tournament
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfTournament.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfTournament.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfTournament.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfTournament.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfTournament.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfTournament.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfTournament.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfTournament.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfTournament.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfTournament.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfTournament.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfTournament.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFTournamentWrapper((ESFTournament)_esfTournament.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFTournament esfTournament) {
		return _esfTournament.compareTo(esfTournament);
	}

	@Override
	public int hashCode() {
		return _esfTournament.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFTournament> toCacheModel() {
		return _esfTournament.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFTournament toEscapedModel() {
		return new ESFTournamentWrapper(_esfTournament.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFTournament toUnescapedModel() {
		return new ESFTournamentWrapper(_esfTournament.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfTournament.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfTournament.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfTournament.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFTournamentWrapper)) {
			return false;
		}

		ESFTournamentWrapper esfTournamentWrapper = (ESFTournamentWrapper)obj;

		if (Validator.equals(_esfTournament, esfTournamentWrapper._esfTournament)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfTournament.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFTournament getWrappedESFTournament() {
		return _esfTournament;
	}

	@Override
	public ESFTournament getWrappedModel() {
		return _esfTournament;
	}

	@Override
	public void resetOriginalValues() {
		_esfTournament.resetOriginalValues();
	}

	private ESFTournament _esfTournament;
}