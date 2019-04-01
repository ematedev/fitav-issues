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
 * The base model interface for the ESFGun service. Represents a row in the &quot;ESFGun&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFGunModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFGunImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFGun
 * @see it.ethica.esf.model.impl.ESFGunImpl
 * @see it.ethica.esf.model.impl.ESFGunModelImpl
 * @generated
 */
public interface ESFGunModel extends BaseModel<ESFGun>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f gun model instance should use the {@link ESFGun} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f gun.
	 *
	 * @return the primary key of this e s f gun
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f gun.
	 *
	 * @param primaryKey the primary key of this e s f gun
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f gun.
	 *
	 * @return the uuid of this e s f gun
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f gun.
	 *
	 * @param uuid the uuid of this e s f gun
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf gun ID of this e s f gun.
	 *
	 * @return the esf gun ID of this e s f gun
	 */
	public long getEsfGunId();

	/**
	 * Sets the esf gun ID of this e s f gun.
	 *
	 * @param esfGunId the esf gun ID of this e s f gun
	 */
	public void setEsfGunId(long esfGunId);

	/**
	 * Returns the group ID of this e s f gun.
	 *
	 * @return the group ID of this e s f gun
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f gun.
	 *
	 * @param groupId the group ID of this e s f gun
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f gun.
	 *
	 * @return the company ID of this e s f gun
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f gun.
	 *
	 * @param companyId the company ID of this e s f gun
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f gun.
	 *
	 * @return the user ID of this e s f gun
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f gun.
	 *
	 * @param userId the user ID of this e s f gun
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f gun.
	 *
	 * @return the user uuid of this e s f gun
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f gun.
	 *
	 * @param userUuid the user uuid of this e s f gun
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f gun.
	 *
	 * @return the user name of this e s f gun
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f gun.
	 *
	 * @param userName the user name of this e s f gun
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f gun.
	 *
	 * @return the create date of this e s f gun
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f gun.
	 *
	 * @param createDate the create date of this e s f gun
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f gun.
	 *
	 * @return the modified date of this e s f gun
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f gun.
	 *
	 * @param modifiedDate the modified date of this e s f gun
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the esf user ID of this e s f gun.
	 *
	 * @return the esf user ID of this e s f gun
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f gun.
	 *
	 * @param esfUserId the esf user ID of this e s f gun
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f gun.
	 *
	 * @return the esf user uuid of this e s f gun
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f gun.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f gun
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the code of this e s f gun.
	 *
	 * @return the code of this e s f gun
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f gun.
	 *
	 * @param code the code of this e s f gun
	 */
	public void setCode(String code);

	/**
	 * Returns the esf gun kind ID of this e s f gun.
	 *
	 * @return the esf gun kind ID of this e s f gun
	 */
	public long getEsfGunKindId();

	/**
	 * Sets the esf gun kind ID of this e s f gun.
	 *
	 * @param esfGunKindId the esf gun kind ID of this e s f gun
	 */
	public void setEsfGunKindId(long esfGunKindId);

	/**
	 * Returns the esf organization ID of this e s f gun.
	 *
	 * @return the esf organization ID of this e s f gun
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f gun.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f gun
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the registration number of this e s f gun.
	 *
	 * @return the registration number of this e s f gun
	 */
	@AutoEscape
	public String getRegistrationNumber();

	/**
	 * Sets the registration number of this e s f gun.
	 *
	 * @param registrationNumber the registration number of this e s f gun
	 */
	public void setRegistrationNumber(String registrationNumber);

	/**
	 * Returns the catridge caliber of this e s f gun.
	 *
	 * @return the catridge caliber of this e s f gun
	 */
	public long getCatridgeCaliber();

	/**
	 * Sets the catridge caliber of this e s f gun.
	 *
	 * @param catridgeCaliber the catridge caliber of this e s f gun
	 */
	public void setCatridgeCaliber(long catridgeCaliber);

	/**
	 * Returns the is favorite gun of this e s f gun.
	 *
	 * @return the is favorite gun of this e s f gun
	 */
	public boolean getIsFavoriteGun();

	/**
	 * Returns <code>true</code> if this e s f gun is is favorite gun.
	 *
	 * @return <code>true</code> if this e s f gun is is favorite gun; <code>false</code> otherwise
	 */
	public boolean isIsFavoriteGun();

	/**
	 * Sets whether this e s f gun is is favorite gun.
	 *
	 * @param isFavoriteGun the is favorite gun of this e s f gun
	 */
	public void setIsFavoriteGun(boolean isFavoriteGun);

	/**
	 * Returns the type ID of this e s f gun.
	 *
	 * @return the type ID of this e s f gun
	 */
	public int getTypeId();

	/**
	 * Sets the type ID of this e s f gun.
	 *
	 * @param typeId the type ID of this e s f gun
	 */
	public void setTypeId(int typeId);

	/**
	 * Returns the measures of this e s f gun.
	 *
	 * @return the measures of this e s f gun
	 */
	@AutoEscape
	public String getMeasures();

	/**
	 * Sets the measures of this e s f gun.
	 *
	 * @param measures the measures of this e s f gun
	 */
	public void setMeasures(String measures);

	/**
	 * Returns the note of this e s f gun.
	 *
	 * @return the note of this e s f gun
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this e s f gun.
	 *
	 * @param note the note of this e s f gun
	 */
	public void setNote(String note);

	/**
	 * Returns the name of this e s f gun.
	 *
	 * @return the name of this e s f gun
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f gun.
	 *
	 * @param name the name of this e s f gun
	 */
	public void setName(String name);

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
	public int compareTo(ESFGun esfGun);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFGun> toCacheModel();

	@Override
	public ESFGun toEscapedModel();

	@Override
	public ESFGun toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}