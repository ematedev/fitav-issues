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
 * The base model interface for the ESFCard service. Represents a row in the &quot;ESFCard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFCardModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFCardImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFCard
 * @see it.ethica.esf.model.impl.ESFCardImpl
 * @see it.ethica.esf.model.impl.ESFCardModelImpl
 * @generated
 */
public interface ESFCardModel extends BaseModel<ESFCard>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f card model instance should use the {@link ESFCard} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f card.
	 *
	 * @return the primary key of this e s f card
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f card.
	 *
	 * @param primaryKey the primary key of this e s f card
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f card.
	 *
	 * @return the uuid of this e s f card
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f card.
	 *
	 * @param uuid the uuid of this e s f card
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf card ID of this e s f card.
	 *
	 * @return the esf card ID of this e s f card
	 */
	public long getEsfCardId();

	/**
	 * Sets the esf card ID of this e s f card.
	 *
	 * @param esfCardId the esf card ID of this e s f card
	 */
	public void setEsfCardId(long esfCardId);

	/**
	 * Returns the group ID of this e s f card.
	 *
	 * @return the group ID of this e s f card
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f card.
	 *
	 * @param groupId the group ID of this e s f card
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f card.
	 *
	 * @return the company ID of this e s f card
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f card.
	 *
	 * @param companyId the company ID of this e s f card
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f card.
	 *
	 * @return the user ID of this e s f card
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f card.
	 *
	 * @param userId the user ID of this e s f card
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f card.
	 *
	 * @return the user uuid of this e s f card
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f card.
	 *
	 * @param userUuid the user uuid of this e s f card
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f card.
	 *
	 * @return the user name of this e s f card
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f card.
	 *
	 * @param userName the user name of this e s f card
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f card.
	 *
	 * @return the create date of this e s f card
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f card.
	 *
	 * @param createDate the create date of this e s f card
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f card.
	 *
	 * @return the modified date of this e s f card
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f card.
	 *
	 * @param modifiedDate the modified date of this e s f card
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the esf user ID of this e s f card.
	 *
	 * @return the esf user ID of this e s f card
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f card.
	 *
	 * @param esfUserId the esf user ID of this e s f card
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f card.
	 *
	 * @return the esf user uuid of this e s f card
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f card.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f card
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the esf organization ID of this e s f card.
	 *
	 * @return the esf organization ID of this e s f card
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f card.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f card
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

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
	public int compareTo(ESFCard esfCard);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFCard> toCacheModel();

	@Override
	public ESFCard toEscapedModel();

	@Override
	public ESFCard toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}