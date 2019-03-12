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
 * The base model interface for the ESFTournament service. Represents a row in the &quot;ESFTournament&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFTournamentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFTournamentImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFTournament
 * @see it.ethica.esf.model.impl.ESFTournamentImpl
 * @see it.ethica.esf.model.impl.ESFTournamentModelImpl
 * @generated
 */
public interface ESFTournamentModel extends BaseModel<ESFTournament>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f tournament model instance should use the {@link ESFTournament} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f tournament.
	 *
	 * @return the primary key of this e s f tournament
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f tournament.
	 *
	 * @param primaryKey the primary key of this e s f tournament
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f tournament.
	 *
	 * @return the uuid of this e s f tournament
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f tournament.
	 *
	 * @param uuid the uuid of this e s f tournament
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf tournament ID of this e s f tournament.
	 *
	 * @return the esf tournament ID of this e s f tournament
	 */
	public long getEsfTournamentId();

	/**
	 * Sets the esf tournament ID of this e s f tournament.
	 *
	 * @param esfTournamentId the esf tournament ID of this e s f tournament
	 */
	public void setEsfTournamentId(long esfTournamentId);

	/**
	 * Returns the esf organization ID of this e s f tournament.
	 *
	 * @return the esf organization ID of this e s f tournament
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f tournament.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f tournament
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the title of this e s f tournament.
	 *
	 * @return the title of this e s f tournament
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this e s f tournament.
	 *
	 * @param title the title of this e s f tournament
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this e s f tournament.
	 *
	 * @return the description of this e s f tournament
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f tournament.
	 *
	 * @param description the description of this e s f tournament
	 */
	public void setDescription(String description);

	/**
	 * Returns the maxnum of this e s f tournament.
	 *
	 * @return the maxnum of this e s f tournament
	 */
	public long getMaxnum();

	/**
	 * Sets the maxnum of this e s f tournament.
	 *
	 * @param maxnum the maxnum of this e s f tournament
	 */
	public void setMaxnum(long maxnum);

	/**
	 * Returns the minnum of this e s f tournament.
	 *
	 * @return the minnum of this e s f tournament
	 */
	public long getMinnum();

	/**
	 * Sets the minnum of this e s f tournament.
	 *
	 * @param minnum the minnum of this e s f tournament
	 */
	public void setMinnum(long minnum);

	/**
	 * Returns the is single match of this e s f tournament.
	 *
	 * @return the is single match of this e s f tournament
	 */
	public boolean getIsSingleMatch();

	/**
	 * Returns <code>true</code> if this e s f tournament is is single match.
	 *
	 * @return <code>true</code> if this e s f tournament is is single match; <code>false</code> otherwise
	 */
	public boolean isIsSingleMatch();

	/**
	 * Sets whether this e s f tournament is is single match.
	 *
	 * @param isSingleMatch the is single match of this e s f tournament
	 */
	public void setIsSingleMatch(boolean isSingleMatch);

	/**
	 * Returns the is team match of this e s f tournament.
	 *
	 * @return the is team match of this e s f tournament
	 */
	public boolean getIsTeamMatch();

	/**
	 * Returns <code>true</code> if this e s f tournament is is team match.
	 *
	 * @return <code>true</code> if this e s f tournament is is team match; <code>false</code> otherwise
	 */
	public boolean isIsTeamMatch();

	/**
	 * Sets whether this e s f tournament is is team match.
	 *
	 * @param isTeamMatch the is team match of this e s f tournament
	 */
	public void setIsTeamMatch(boolean isTeamMatch);

	/**
	 * Returns the is individual match of this e s f tournament.
	 *
	 * @return the is individual match of this e s f tournament
	 */
	public boolean getIsIndividualMatch();

	/**
	 * Returns <code>true</code> if this e s f tournament is is individual match.
	 *
	 * @return <code>true</code> if this e s f tournament is is individual match; <code>false</code> otherwise
	 */
	public boolean isIsIndividualMatch();

	/**
	 * Sets whether this e s f tournament is is individual match.
	 *
	 * @param isIndividualMatch the is individual match of this e s f tournament
	 */
	public void setIsIndividualMatch(boolean isIndividualMatch);

	/**
	 * Returns the is junior match of this e s f tournament.
	 *
	 * @return the is junior match of this e s f tournament
	 */
	public boolean getIsJuniorMatch();

	/**
	 * Returns <code>true</code> if this e s f tournament is is junior match.
	 *
	 * @return <code>true</code> if this e s f tournament is is junior match; <code>false</code> otherwise
	 */
	public boolean isIsJuniorMatch();

	/**
	 * Sets whether this e s f tournament is is junior match.
	 *
	 * @param isJuniorMatch the is junior match of this e s f tournament
	 */
	public void setIsJuniorMatch(boolean isJuniorMatch);

	/**
	 * Returns the is national match of this e s f tournament.
	 *
	 * @return the is national match of this e s f tournament
	 */
	public boolean getIsNationalMatch();

	/**
	 * Returns <code>true</code> if this e s f tournament is is national match.
	 *
	 * @return <code>true</code> if this e s f tournament is is national match; <code>false</code> otherwise
	 */
	public boolean isIsNationalMatch();

	/**
	 * Sets whether this e s f tournament is is national match.
	 *
	 * @param isNationalMatch the is national match of this e s f tournament
	 */
	public void setIsNationalMatch(boolean isNationalMatch);

	/**
	 * Returns the is final of this e s f tournament.
	 *
	 * @return the is final of this e s f tournament
	 */
	public boolean getIsFinal();

	/**
	 * Returns <code>true</code> if this e s f tournament is is final.
	 *
	 * @return <code>true</code> if this e s f tournament is is final; <code>false</code> otherwise
	 */
	public boolean isIsFinal();

	/**
	 * Sets whether this e s f tournament is is final.
	 *
	 * @param isFinal the is final of this e s f tournament
	 */
	public void setIsFinal(boolean isFinal);

	/**
	 * Returns the start date of this e s f tournament.
	 *
	 * @return the start date of this e s f tournament
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this e s f tournament.
	 *
	 * @param startDate the start date of this e s f tournament
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this e s f tournament.
	 *
	 * @return the end date of this e s f tournament
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f tournament.
	 *
	 * @param endDate the end date of this e s f tournament
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the group ID of this e s f tournament.
	 *
	 * @return the group ID of this e s f tournament
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f tournament.
	 *
	 * @param groupId the group ID of this e s f tournament
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f tournament.
	 *
	 * @return the company ID of this e s f tournament
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f tournament.
	 *
	 * @param companyId the company ID of this e s f tournament
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f tournament.
	 *
	 * @return the user ID of this e s f tournament
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f tournament.
	 *
	 * @param userId the user ID of this e s f tournament
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f tournament.
	 *
	 * @return the user uuid of this e s f tournament
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f tournament.
	 *
	 * @param userUuid the user uuid of this e s f tournament
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f tournament.
	 *
	 * @return the user name of this e s f tournament
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f tournament.
	 *
	 * @param userName the user name of this e s f tournament
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f tournament.
	 *
	 * @return the create date of this e s f tournament
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f tournament.
	 *
	 * @param createDate the create date of this e s f tournament
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f tournament.
	 *
	 * @return the modified date of this e s f tournament
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f tournament.
	 *
	 * @param modifiedDate the modified date of this e s f tournament
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(it.ethica.esf.model.ESFTournament esfTournament);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFTournament> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFTournament toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFTournament toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}