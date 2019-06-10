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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFMatch service. Represents a row in the &quot;ESFMatch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFMatchModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFMatchImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFMatch
 * @see it.ethica.esf.model.impl.ESFMatchImpl
 * @see it.ethica.esf.model.impl.ESFMatchModelImpl
 * @generated
 */
public interface ESFMatchModel extends BaseModel<ESFMatch>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f match model instance should use the {@link ESFMatch} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f match.
	 *
	 * @return the primary key of this e s f match
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f match.
	 *
	 * @param primaryKey the primary key of this e s f match
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f match.
	 *
	 * @return the uuid of this e s f match
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f match.
	 *
	 * @param uuid the uuid of this e s f match
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf match ID of this e s f match.
	 *
	 * @return the esf match ID of this e s f match
	 */
	public long getEsfMatchId();

	/**
	 * Sets the esf match ID of this e s f match.
	 *
	 * @param esfMatchId the esf match ID of this e s f match
	 */
	public void setEsfMatchId(long esfMatchId);

	/**
	 * Returns the start date of this e s f match.
	 *
	 * @return the start date of this e s f match
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this e s f match.
	 *
	 * @param startDate the start date of this e s f match
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the start hour of this e s f match.
	 *
	 * @return the start hour of this e s f match
	 */
	@AutoEscape
	public String getStartHour();

	/**
	 * Sets the start hour of this e s f match.
	 *
	 * @param startHour the start hour of this e s f match
	 */
	public void setStartHour(String startHour);

	/**
	 * Returns the esf sport type ID of this e s f match.
	 *
	 * @return the esf sport type ID of this e s f match
	 */
	public long getEsfSportTypeId();

	/**
	 * Sets the esf sport type ID of this e s f match.
	 *
	 * @param esfSportTypeId the esf sport type ID of this e s f match
	 */
	public void setEsfSportTypeId(long esfSportTypeId);

	/**
	 * Returns the esf match type ID of this e s f match.
	 *
	 * @return the esf match type ID of this e s f match
	 */
	public long getEsfMatchTypeId();

	/**
	 * Sets the esf match type ID of this e s f match.
	 *
	 * @param esfMatchTypeId the esf match type ID of this e s f match
	 */
	public void setEsfMatchTypeId(long esfMatchTypeId);

	/**
	 * Returns the is draft of this e s f match.
	 *
	 * @return the is draft of this e s f match
	 */
	public boolean getIsDraft();

	/**
	 * Returns <code>true</code> if this e s f match is is draft.
	 *
	 * @return <code>true</code> if this e s f match is is draft; <code>false</code> otherwise
	 */
	public boolean isIsDraft();

	/**
	 * Sets whether this e s f match is is draft.
	 *
	 * @param isDraft the is draft of this e s f match
	 */
	public void setIsDraft(boolean isDraft);

	/**
	 * Returns the is team match of this e s f match.
	 *
	 * @return the is team match of this e s f match
	 */
	public boolean getIsTeamMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is team match.
	 *
	 * @return <code>true</code> if this e s f match is is team match; <code>false</code> otherwise
	 */
	public boolean isIsTeamMatch();

	/**
	 * Sets whether this e s f match is is team match.
	 *
	 * @param isTeamMatch the is team match of this e s f match
	 */
	public void setIsTeamMatch(boolean isTeamMatch);

	/**
	 * Returns the is individual match of this e s f match.
	 *
	 * @return the is individual match of this e s f match
	 */
	public boolean getIsIndividualMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is individual match.
	 *
	 * @return <code>true</code> if this e s f match is is individual match; <code>false</code> otherwise
	 */
	public boolean isIsIndividualMatch();

	/**
	 * Sets whether this e s f match is is individual match.
	 *
	 * @param isIndividualMatch the is individual match of this e s f match
	 */
	public void setIsIndividualMatch(boolean isIndividualMatch);

	/**
	 * Returns the is junior match of this e s f match.
	 *
	 * @return the is junior match of this e s f match
	 */
	public boolean getIsJuniorMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is junior match.
	 *
	 * @return <code>true</code> if this e s f match is is junior match; <code>false</code> otherwise
	 */
	public boolean isIsJuniorMatch();

	/**
	 * Sets whether this e s f match is is junior match.
	 *
	 * @param isJuniorMatch the is junior match of this e s f match
	 */
	public void setIsJuniorMatch(boolean isJuniorMatch);

	/**
	 * Returns the num disk of this e s f match.
	 *
	 * @return the num disk of this e s f match
	 */
	public int getNumDisk();

	/**
	 * Sets the num disk of this e s f match.
	 *
	 * @param numDisk the num disk of this e s f match
	 */
	public void setNumDisk(int numDisk);

	/**
	 * Returns the num disk team of this e s f match.
	 *
	 * @return the num disk team of this e s f match
	 */
	public int getNumDiskTeam();

	/**
	 * Sets the num disk team of this e s f match.
	 *
	 * @param numDiskTeam the num disk team of this e s f match
	 */
	public void setNumDiskTeam(int numDiskTeam);

	/**
	 * Returns the esf association ID of this e s f match.
	 *
	 * @return the esf association ID of this e s f match
	 */
	public long getEsfAssociationId();

	/**
	 * Sets the esf association ID of this e s f match.
	 *
	 * @param esfAssociationId the esf association ID of this e s f match
	 */
	public void setEsfAssociationId(long esfAssociationId);

	/**
	 * Returns the notes of this e s f match.
	 *
	 * @return the notes of this e s f match
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this e s f match.
	 *
	 * @param notes the notes of this e s f match
	 */
	public void setNotes(String notes);

	/**
	 * Returns the description of this e s f match.
	 *
	 * @return the description of this e s f match
	 */
	public long getDescription();

	/**
	 * Sets the description of this e s f match.
	 *
	 * @param description the description of this e s f match
	 */
	public void setDescription(long description);

	/**
	 * Returns the end date of this e s f match.
	 *
	 * @return the end date of this e s f match
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f match.
	 *
	 * @param endDate the end date of this e s f match
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the num fields of this e s f match.
	 *
	 * @return the num fields of this e s f match
	 */
	public int getNumFields();

	/**
	 * Sets the num fields of this e s f match.
	 *
	 * @param numFields the num fields of this e s f match
	 */
	public void setNumFields(int numFields);

	/**
	 * Returns the group ID of this e s f match.
	 *
	 * @return the group ID of this e s f match
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f match.
	 *
	 * @param groupId the group ID of this e s f match
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f match.
	 *
	 * @return the company ID of this e s f match
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f match.
	 *
	 * @param companyId the company ID of this e s f match
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f match.
	 *
	 * @return the user ID of this e s f match
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f match.
	 *
	 * @param userId the user ID of this e s f match
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f match.
	 *
	 * @return the user uuid of this e s f match
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f match.
	 *
	 * @param userUuid the user uuid of this e s f match
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f match.
	 *
	 * @return the user name of this e s f match
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f match.
	 *
	 * @param userName the user name of this e s f match
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f match.
	 *
	 * @return the create date of this e s f match
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f match.
	 *
	 * @param createDate the create date of this e s f match
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f match.
	 *
	 * @return the modified date of this e s f match
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f match.
	 *
	 * @param modifiedDate the modified date of this e s f match
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the is single match of this e s f match.
	 *
	 * @return the is single match of this e s f match
	 */
	public boolean getIsSingleMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is single match.
	 *
	 * @return <code>true</code> if this e s f match is is single match; <code>false</code> otherwise
	 */
	public boolean isIsSingleMatch();

	/**
	 * Sets whether this e s f match is is single match.
	 *
	 * @param isSingleMatch the is single match of this e s f match
	 */
	public void setIsSingleMatch(boolean isSingleMatch);

	/**
	 * Returns the site of this e s f match.
	 *
	 * @return the site of this e s f match
	 */
	@AutoEscape
	public String getSite();

	/**
	 * Sets the site of this e s f match.
	 *
	 * @param site the site of this e s f match
	 */
	public void setSite(String site);

	/**
	 * Returns the country ID of this e s f match.
	 *
	 * @return the country ID of this e s f match
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this e s f match.
	 *
	 * @param countryId the country ID of this e s f match
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the code of this e s f match.
	 *
	 * @return the code of this e s f match
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f match.
	 *
	 * @param code the code of this e s f match
	 */
	public void setCode(String code);

	/**
	 * Returns the is national of this e s f match.
	 *
	 * @return the is national of this e s f match
	 */
	public boolean getIsNational();

	/**
	 * Returns <code>true</code> if this e s f match is is national.
	 *
	 * @return <code>true</code> if this e s f match is is national; <code>false</code> otherwise
	 */
	public boolean isIsNational();

	/**
	 * Sets whether this e s f match is is national.
	 *
	 * @param isNational the is national of this e s f match
	 */
	public void setIsNational(boolean isNational);

	/**
	 * Returns the has penality of this e s f match.
	 *
	 * @return the has penality of this e s f match
	 */
	public boolean getHasPenality();

	/**
	 * Returns <code>true</code> if this e s f match is has penality.
	 *
	 * @return <code>true</code> if this e s f match is has penality; <code>false</code> otherwise
	 */
	public boolean isHasPenality();

	/**
	 * Sets whether this e s f match is has penality.
	 *
	 * @param HasPenality the has penality of this e s f match
	 */
	public void setHasPenality(boolean HasPenality);

	/**
	 * Returns the is olimpic qualification match of this e s f match.
	 *
	 * @return the is olimpic qualification match of this e s f match
	 */
	public boolean getIsOlimpicQualificationMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is olimpic qualification match.
	 *
	 * @return <code>true</code> if this e s f match is is olimpic qualification match; <code>false</code> otherwise
	 */
	public boolean isIsOlimpicQualificationMatch();

	/**
	 * Sets whether this e s f match is is olimpic qualification match.
	 *
	 * @param isOlimpicQualificationMatch the is olimpic qualification match of this e s f match
	 */
	public void setIsOlimpicQualificationMatch(
		boolean isOlimpicQualificationMatch);

	/**
	 * Returns the event type of this e s f match.
	 *
	 * @return the event type of this e s f match
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this e s f match.
	 *
	 * @param eventType the event type of this e s f match
	 */
	public void setEventType(String eventType);

	/**
	 * Returns the not national assotiation of this e s f match.
	 *
	 * @return the not national assotiation of this e s f match
	 */
	@AutoEscape
	public String getNotNationalAssotiation();

	/**
	 * Sets the not national assotiation of this e s f match.
	 *
	 * @param notNationalAssotiation the not national assotiation of this e s f match
	 */
	public void setNotNationalAssotiation(String notNationalAssotiation);

	/**
	 * Returns the is change category match of this e s f match.
	 *
	 * @return the is change category match of this e s f match
	 */
	public boolean getIsChangeCategoryMatch();

	/**
	 * Returns <code>true</code> if this e s f match is is change category match.
	 *
	 * @return <code>true</code> if this e s f match is is change category match; <code>false</code> otherwise
	 */
	public boolean isIsChangeCategoryMatch();

	/**
	 * Sets whether this e s f match is is change category match.
	 *
	 * @param isChangeCategoryMatch the is change category match of this e s f match
	 */
	public void setIsChangeCategoryMatch(boolean isChangeCategoryMatch);

	/**
	 * Returns the esf national sport type ID of this e s f match.
	 *
	 * @return the esf national sport type ID of this e s f match
	 */
	@AutoEscape
	public String getEsfNationalSportTypeId();

	/**
	 * Sets the esf national sport type ID of this e s f match.
	 *
	 * @param esfNationalSportTypeId the esf national sport type ID of this e s f match
	 */
	public void setEsfNationalSportTypeId(String esfNationalSportTypeId);

	/**
	 * Returns the old code of this e s f match.
	 *
	 * @return the old code of this e s f match
	 */
	@AutoEscape
	public String getOldCode();

	/**
	 * Sets the old code of this e s f match.
	 *
	 * @param oldCode the old code of this e s f match
	 */
	public void setOldCode(String oldCode);

	/**
	 * Returns the match year of this e s f match.
	 *
	 * @return the match year of this e s f match
	 */
	public int getMatchYear();

	/**
	 * Sets the match year of this e s f match.
	 *
	 * @param matchYear the match year of this e s f match
	 */
	public void setMatchYear(int matchYear);

	/**
	 * Returns the match year seq of this e s f match.
	 *
	 * @return the match year seq of this e s f match
	 */
	public int getMatchYearSeq();

	/**
	 * Sets the match year seq of this e s f match.
	 *
	 * @param matchYearSeq the match year seq of this e s f match
	 */
	public void setMatchYearSeq(int matchYearSeq);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ESFMatch esfMatch);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFMatch> toCacheModel();

	@Override
	public ESFMatch toEscapedModel();

	@Override
	public ESFMatch toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}