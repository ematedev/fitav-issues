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
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFNationalMatchResult service. Represents a row in the &quot;ESFNationalMatchResult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFNationalMatchResultImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResult
 * @see it.ethica.esf.model.impl.ESFNationalMatchResultImpl
 * @see it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl
 * @generated
 */
public interface ESFNationalMatchResultModel extends BaseModel<ESFNationalMatchResult>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f national match result model instance should use the {@link ESFNationalMatchResult} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f national match result.
	 *
	 * @return the primary key of this e s f national match result
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f national match result.
	 *
	 * @param primaryKey the primary key of this e s f national match result
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf national match result ID of this e s f national match result.
	 *
	 * @return the esf national match result ID of this e s f national match result
	 */
	public long getEsfNationalMatchResultId();

	/**
	 * Sets the esf national match result ID of this e s f national match result.
	 *
	 * @param esfNationalMatchResultId the esf national match result ID of this e s f national match result
	 */
	public void setEsfNationalMatchResultId(long esfNationalMatchResultId);

	/**
	 * Returns the group ID of this e s f national match result.
	 *
	 * @return the group ID of this e s f national match result
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f national match result.
	 *
	 * @param groupId the group ID of this e s f national match result
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f national match result.
	 *
	 * @return the company ID of this e s f national match result
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f national match result.
	 *
	 * @param companyId the company ID of this e s f national match result
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f national match result.
	 *
	 * @return the user ID of this e s f national match result
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f national match result.
	 *
	 * @param userId the user ID of this e s f national match result
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f national match result.
	 *
	 * @return the user uuid of this e s f national match result
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f national match result.
	 *
	 * @param userUuid the user uuid of this e s f national match result
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f national match result.
	 *
	 * @return the user name of this e s f national match result
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f national match result.
	 *
	 * @param userName the user name of this e s f national match result
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f national match result.
	 *
	 * @return the create date of this e s f national match result
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f national match result.
	 *
	 * @param createDate the create date of this e s f national match result
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f national match result.
	 *
	 * @return the modified date of this e s f national match result
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f national match result.
	 *
	 * @param modifiedDate the modified date of this e s f national match result
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the esf match ID of this e s f national match result.
	 *
	 * @return the esf match ID of this e s f national match result
	 */
	public long getEsfMatchId();

	/**
	 * Sets the esf match ID of this e s f national match result.
	 *
	 * @param esfMatchId the esf match ID of this e s f national match result
	 */
	public void setEsfMatchId(long esfMatchId);

	/**
	 * Returns the esf user ID of this e s f national match result.
	 *
	 * @return the esf user ID of this e s f national match result
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f national match result.
	 *
	 * @param esfUserId the esf user ID of this e s f national match result
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f national match result.
	 *
	 * @return the esf user uuid of this e s f national match result
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f national match result.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f national match result
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the position of this e s f national match result.
	 *
	 * @return the position of this e s f national match result
	 */
	public int getPosition();

	/**
	 * Sets the position of this e s f national match result.
	 *
	 * @param position the position of this e s f national match result
	 */
	public void setPosition(int position);

	/**
	 * Returns the qualification of this e s f national match result.
	 *
	 * @return the qualification of this e s f national match result
	 */
	public int getQualification();

	/**
	 * Sets the qualification of this e s f national match result.
	 *
	 * @param qualification the qualification of this e s f national match result
	 */
	public void setQualification(int qualification);

	/**
	 * Returns the shoot off of this e s f national match result.
	 *
	 * @return the shoot off of this e s f national match result
	 */
	public int getShootOff();

	/**
	 * Sets the shoot off of this e s f national match result.
	 *
	 * @param shootOff the shoot off of this e s f national match result
	 */
	public void setShootOff(int shootOff);

	/**
	 * Returns the clay pigeon total of this e s f national match result.
	 *
	 * @return the clay pigeon total of this e s f national match result
	 */
	public int getClayPigeonTotal();

	/**
	 * Sets the clay pigeon total of this e s f national match result.
	 *
	 * @param clayPigeonTotal the clay pigeon total of this e s f national match result
	 */
	public void setClayPigeonTotal(int clayPigeonTotal);

	/**
	 * Returns the final result of this e s f national match result.
	 *
	 * @return the final result of this e s f national match result
	 */
	public int getFinalResult();

	/**
	 * Sets the final result of this e s f national match result.
	 *
	 * @param finalResult the final result of this e s f national match result
	 */
	public void setFinalResult(int finalResult);

	/**
	 * Returns the shoot off final of this e s f national match result.
	 *
	 * @return the shoot off final of this e s f national match result
	 */
	public int getShootOffFinal();

	/**
	 * Sets the shoot off final of this e s f national match result.
	 *
	 * @param shootOffFinal the shoot off final of this e s f national match result
	 */
	public void setShootOffFinal(int shootOffFinal);

	/**
	 * Returns the external shooter of this e s f national match result.
	 *
	 * @return the external shooter of this e s f national match result
	 */
	public boolean getExternalShooter();

	/**
	 * Returns <code>true</code> if this e s f national match result is external shooter.
	 *
	 * @return <code>true</code> if this e s f national match result is external shooter; <code>false</code> otherwise
	 */
	public boolean isExternalShooter();

	/**
	 * Sets whether this e s f national match result is external shooter.
	 *
	 * @param externalShooter the external shooter of this e s f national match result
	 */
	public void setExternalShooter(boolean externalShooter);

	/**
	 * Returns the external name of this e s f national match result.
	 *
	 * @return the external name of this e s f national match result
	 */
	@AutoEscape
	public String getExternalName();

	/**
	 * Sets the external name of this e s f national match result.
	 *
	 * @param externalName the external name of this e s f national match result
	 */
	public void setExternalName(String externalName);

	/**
	 * Returns the esf sport type ID of this e s f national match result.
	 *
	 * @return the esf sport type ID of this e s f national match result
	 */
	public long getEsfSportTypeId();

	/**
	 * Sets the esf sport type ID of this e s f national match result.
	 *
	 * @param esfSportTypeId the esf sport type ID of this e s f national match result
	 */
	public void setEsfSportTypeId(long esfSportTypeId);

	/**
	 * Returns the user nationality of this e s f national match result.
	 *
	 * @return the user nationality of this e s f national match result
	 */
	@AutoEscape
	public String getUserNationality();

	/**
	 * Sets the user nationality of this e s f national match result.
	 *
	 * @param userNationality the user nationality of this e s f national match result
	 */
	public void setUserNationality(String userNationality);

	/**
	 * Returns the esf user qualification of this e s f national match result.
	 *
	 * @return the esf user qualification of this e s f national match result
	 */
	public long getEsfUserQualification();

	/**
	 * Sets the esf user qualification of this e s f national match result.
	 *
	 * @param esfUserQualification the esf user qualification of this e s f national match result
	 */
	public void setEsfUserQualification(long esfUserQualification);

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
	public int compareTo(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFNationalMatchResult> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}