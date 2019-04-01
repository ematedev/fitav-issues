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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFUser service. Represents a row in the &quot;ESFUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFUserImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUser
 * @see it.ethica.esf.model.impl.ESFUserImpl
 * @see it.ethica.esf.model.impl.ESFUserModelImpl
 * @generated
 */
public interface ESFUserModel extends BaseModel<ESFUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f user model instance should use the {@link ESFUser} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f user.
	 *
	 * @return the primary key of this e s f user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f user.
	 *
	 * @param primaryKey the primary key of this e s f user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f user.
	 *
	 * @return the uuid of this e s f user
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this e s f user.
	 *
	 * @param uuid the uuid of this e s f user
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the esf user ID of this e s f user.
	 *
	 * @return the esf user ID of this e s f user
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f user.
	 *
	 * @param esfUserId the esf user ID of this e s f user
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f user.
	 *
	 * @return the esf user uuid of this e s f user
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f user.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f user
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the code of this e s f user.
	 *
	 * @return the code of this e s f user
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f user.
	 *
	 * @param code the code of this e s f user
	 */
	public void setCode(String code);

	/**
	 * Returns the typearmy of this e s f user.
	 *
	 * @return the typearmy of this e s f user
	 */
	public long getTypearmy();

	/**
	 * Sets the typearmy of this e s f user.
	 *
	 * @param typearmy the typearmy of this e s f user
	 */
	public void setTypearmy(long typearmy);

	/**
	 * Returns the fiscal code of this e s f user.
	 *
	 * @return the fiscal code of this e s f user
	 */
	@AutoEscape
	public String getFiscalCode();

	/**
	 * Sets the fiscal code of this e s f user.
	 *
	 * @param fiscalCode the fiscal code of this e s f user
	 */
	public void setFiscalCode(String fiscalCode);

	/**
	 * Returns the birthcity of this e s f user.
	 *
	 * @return the birthcity of this e s f user
	 */
	@AutoEscape
	public String getBirthcity();

	/**
	 * Sets the birthcity of this e s f user.
	 *
	 * @param birthcity the birthcity of this e s f user
	 */
	public void setBirthcity(String birthcity);

	/**
	 * Returns the nationality of this e s f user.
	 *
	 * @return the nationality of this e s f user
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this e s f user.
	 *
	 * @param nationality the nationality of this e s f user
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the is sports groups of this e s f user.
	 *
	 * @return the is sports groups of this e s f user
	 */
	public boolean getIsSportsGroups();

	/**
	 * Returns <code>true</code> if this e s f user is is sports groups.
	 *
	 * @return <code>true</code> if this e s f user is is sports groups; <code>false</code> otherwise
	 */
	public boolean isIsSportsGroups();

	/**
	 * Sets whether this e s f user is is sports groups.
	 *
	 * @param isSportsGroups the is sports groups of this e s f user
	 */
	public void setIsSportsGroups(boolean isSportsGroups);

	/**
	 * Returns the job of this e s f user.
	 *
	 * @return the job of this e s f user
	 */
	@AutoEscape
	public String getJob();

	/**
	 * Sets the job of this e s f user.
	 *
	 * @param job the job of this e s f user
	 */
	public void setJob(String job);

	/**
	 * Returns the issf ID number of this e s f user.
	 *
	 * @return the issf ID number of this e s f user
	 */
	@AutoEscape
	public String getIssfIdNumber();

	/**
	 * Sets the issf ID number of this e s f user.
	 *
	 * @param issfIdNumber the issf ID number of this e s f user
	 */
	public void setIssfIdNumber(String issfIdNumber);

	/**
	 * Returns the category ID of this e s f user.
	 *
	 * @return the category ID of this e s f user
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this e s f user.
	 *
	 * @param categoryId the category ID of this e s f user
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the pin of this e s f user.
	 *
	 * @return the pin of this e s f user
	 */
	public long getPin();

	/**
	 * Sets the pin of this e s f user.
	 *
	 * @param pin the pin of this e s f user
	 */
	public void setPin(long pin);

	/**
	 * Returns the code user of this e s f user.
	 *
	 * @return the code user of this e s f user
	 */
	public long getCodeUser();

	/**
	 * Sets the code user of this e s f user.
	 *
	 * @param codeUser the code user of this e s f user
	 */
	public void setCodeUser(long codeUser);

	/**
	 * Returns the date of death of this e s f user.
	 *
	 * @return the date of death of this e s f user
	 */
	public Date getDateOfDeath();

	/**
	 * Sets the date of death of this e s f user.
	 *
	 * @param DateOfDeath the date of death of this e s f user
	 */
	public void setDateOfDeath(Date DateOfDeath);

	/**
	 * Returns the privacy1 of this e s f user.
	 *
	 * @return the privacy1 of this e s f user
	 */
	public boolean getPrivacy1();

	/**
	 * Returns <code>true</code> if this e s f user is privacy1.
	 *
	 * @return <code>true</code> if this e s f user is privacy1; <code>false</code> otherwise
	 */
	public boolean isPrivacy1();

	/**
	 * Sets whether this e s f user is privacy1.
	 *
	 * @param privacy1 the privacy1 of this e s f user
	 */
	public void setPrivacy1(boolean privacy1);

	/**
	 * Returns the privacy2 of this e s f user.
	 *
	 * @return the privacy2 of this e s f user
	 */
	public boolean getPrivacy2();

	/**
	 * Returns <code>true</code> if this e s f user is privacy2.
	 *
	 * @return <code>true</code> if this e s f user is privacy2; <code>false</code> otherwise
	 */
	public boolean isPrivacy2();

	/**
	 * Sets whether this e s f user is privacy2.
	 *
	 * @param privacy2 the privacy2 of this e s f user
	 */
	public void setPrivacy2(boolean privacy2);

	/**
	 * Returns the privacy3 of this e s f user.
	 *
	 * @return the privacy3 of this e s f user
	 */
	public boolean getPrivacy3();

	/**
	 * Returns <code>true</code> if this e s f user is privacy3.
	 *
	 * @return <code>true</code> if this e s f user is privacy3; <code>false</code> otherwise
	 */
	public boolean isPrivacy3();

	/**
	 * Sets whether this e s f user is privacy3.
	 *
	 * @param privacy3 the privacy3 of this e s f user
	 */
	public void setPrivacy3(boolean privacy3);

	/**
	 * Returns the date privacy1 of this e s f user.
	 *
	 * @return the date privacy1 of this e s f user
	 */
	public Date getDatePrivacy1();

	/**
	 * Sets the date privacy1 of this e s f user.
	 *
	 * @param datePrivacy1 the date privacy1 of this e s f user
	 */
	public void setDatePrivacy1(Date datePrivacy1);

	/**
	 * Returns the date privacy2 of this e s f user.
	 *
	 * @return the date privacy2 of this e s f user
	 */
	public Date getDatePrivacy2();

	/**
	 * Sets the date privacy2 of this e s f user.
	 *
	 * @param datePrivacy2 the date privacy2 of this e s f user
	 */
	public void setDatePrivacy2(Date datePrivacy2);

	/**
	 * Returns the date privacy3 of this e s f user.
	 *
	 * @return the date privacy3 of this e s f user
	 */
	public Date getDatePrivacy3();

	/**
	 * Sets the date privacy3 of this e s f user.
	 *
	 * @param datePrivacy3 the date privacy3 of this e s f user
	 */
	public void setDatePrivacy3(Date datePrivacy3);

	/**
	 * Returns the validate c f of this e s f user.
	 *
	 * @return the validate c f of this e s f user
	 */
	public boolean getValidateCF();

	/**
	 * Returns <code>true</code> if this e s f user is validate c f.
	 *
	 * @return <code>true</code> if this e s f user is validate c f; <code>false</code> otherwise
	 */
	public boolean isValidateCF();

	/**
	 * Sets whether this e s f user is validate c f.
	 *
	 * @param validateCF the validate c f of this e s f user
	 */
	public void setValidateCF(boolean validateCF);

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
	public int compareTo(ESFUser esfUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFUser> toCacheModel();

	@Override
	public ESFUser toEscapedModel();

	@Override
	public ESFUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}