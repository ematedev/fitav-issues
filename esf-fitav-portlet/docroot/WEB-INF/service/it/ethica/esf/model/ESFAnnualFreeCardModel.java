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
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFAnnualFreeCard service. Represents a row in the &quot;ESFAnnualFreeCard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFAnnualFreeCardImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualFreeCard
 * @see it.ethica.esf.model.impl.ESFAnnualFreeCardImpl
 * @see it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl
 * @generated
 */
public interface ESFAnnualFreeCardModel extends AuditedModel,
	BaseModel<ESFAnnualFreeCard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f annual free card model instance should use the {@link ESFAnnualFreeCard} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f annual free card.
	 *
	 * @return the primary key of this e s f annual free card
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f annual free card.
	 *
	 * @param primaryKey the primary key of this e s f annual free card
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the annual free card ID of this e s f annual free card.
	 *
	 * @return the annual free card ID of this e s f annual free card
	 */
	public long getAnnualFreeCardId();

	/**
	 * Sets the annual free card ID of this e s f annual free card.
	 *
	 * @param annualFreeCardId the annual free card ID of this e s f annual free card
	 */
	public void setAnnualFreeCardId(long annualFreeCardId);

	/**
	 * Returns the company ID of this e s f annual free card.
	 *
	 * @return the company ID of this e s f annual free card
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f annual free card.
	 *
	 * @param companyId the company ID of this e s f annual free card
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f annual free card.
	 *
	 * @return the user ID of this e s f annual free card
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f annual free card.
	 *
	 * @param userId the user ID of this e s f annual free card
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f annual free card.
	 *
	 * @return the user uuid of this e s f annual free card
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f annual free card.
	 *
	 * @param userUuid the user uuid of this e s f annual free card
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f annual free card.
	 *
	 * @return the user name of this e s f annual free card
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f annual free card.
	 *
	 * @param userName the user name of this e s f annual free card
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f annual free card.
	 *
	 * @return the create date of this e s f annual free card
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f annual free card.
	 *
	 * @param createDate the create date of this e s f annual free card
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f annual free card.
	 *
	 * @return the modified date of this e s f annual free card
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f annual free card.
	 *
	 * @param modifiedDate the modified date of this e s f annual free card
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ass ID of this e s f annual free card.
	 *
	 * @return the ass ID of this e s f annual free card
	 */
	public long getAssId();

	/**
	 * Sets the ass ID of this e s f annual free card.
	 *
	 * @param assId the ass ID of this e s f annual free card
	 */
	public void setAssId(long assId);

	/**
	 * Returns the code of this e s f annual free card.
	 *
	 * @return the code of this e s f annual free card
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f annual free card.
	 *
	 * @param code the code of this e s f annual free card
	 */
	public void setCode(String code);

	/**
	 * Returns the card code of this e s f annual free card.
	 *
	 * @return the card code of this e s f annual free card
	 */
	@AutoEscape
	public String getCardCode();

	/**
	 * Sets the card code of this e s f annual free card.
	 *
	 * @param cardCode the card code of this e s f annual free card
	 */
	public void setCardCode(String cardCode);

	/**
	 * Returns the ass code of this e s f annual free card.
	 *
	 * @return the ass code of this e s f annual free card
	 */
	@AutoEscape
	public String getAssCode();

	/**
	 * Sets the ass code of this e s f annual free card.
	 *
	 * @param assCode the ass code of this e s f annual free card
	 */
	public void setAssCode(String assCode);

	/**
	 * Returns the ass name of this e s f annual free card.
	 *
	 * @return the ass name of this e s f annual free card
	 */
	@AutoEscape
	public String getAssName();

	/**
	 * Sets the ass name of this e s f annual free card.
	 *
	 * @param assName the ass name of this e s f annual free card
	 */
	public void setAssName(String assName);

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
	public int compareTo(ESFAnnualFreeCard esfAnnualFreeCard);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFAnnualFreeCard> toCacheModel();

	@Override
	public ESFAnnualFreeCard toEscapedModel();

	@Override
	public ESFAnnualFreeCard toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}