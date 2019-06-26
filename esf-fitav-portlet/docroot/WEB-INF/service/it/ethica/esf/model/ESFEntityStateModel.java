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
 * The base model interface for the ESFEntityState service. Represents a row in the &quot;ESFEntityState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFEntityStateImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFEntityState
 * @see it.ethica.esf.model.impl.ESFEntityStateImpl
 * @see it.ethica.esf.model.impl.ESFEntityStateModelImpl
 * @generated
 */
public interface ESFEntityStateModel extends BaseModel<ESFEntityState>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f entity state model instance should use the {@link ESFEntityState} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f entity state.
	 *
	 * @return the primary key of this e s f entity state
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f entity state.
	 *
	 * @param primaryKey the primary key of this e s f entity state
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf entity state ID of this e s f entity state.
	 *
	 * @return the esf entity state ID of this e s f entity state
	 */
	public long getEsfEntityStateId();

	/**
	 * Sets the esf entity state ID of this e s f entity state.
	 *
	 * @param esfEntityStateId the esf entity state ID of this e s f entity state
	 */
	public void setEsfEntityStateId(long esfEntityStateId);

	/**
	 * Returns the group ID of this e s f entity state.
	 *
	 * @return the group ID of this e s f entity state
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f entity state.
	 *
	 * @param groupId the group ID of this e s f entity state
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f entity state.
	 *
	 * @return the company ID of this e s f entity state
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f entity state.
	 *
	 * @param companyId the company ID of this e s f entity state
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f entity state.
	 *
	 * @return the user ID of this e s f entity state
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f entity state.
	 *
	 * @param userId the user ID of this e s f entity state
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f entity state.
	 *
	 * @return the user uuid of this e s f entity state
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f entity state.
	 *
	 * @param userUuid the user uuid of this e s f entity state
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f entity state.
	 *
	 * @return the user name of this e s f entity state
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f entity state.
	 *
	 * @param userName the user name of this e s f entity state
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f entity state.
	 *
	 * @return the create date of this e s f entity state
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f entity state.
	 *
	 * @param createDate the create date of this e s f entity state
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f entity state.
	 *
	 * @return the modified date of this e s f entity state
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f entity state.
	 *
	 * @param modifiedDate the modified date of this e s f entity state
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the class name of this e s f entity state.
	 *
	 * @return the class name of this e s f entity state
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this e s f entity state.
	 *
	 * @param className the class name of this e s f entity state
	 */
	public void setClassName(String className);

	/**
	 * Returns the class p k of this e s f entity state.
	 *
	 * @return the class p k of this e s f entity state
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this e s f entity state.
	 *
	 * @param classPK the class p k of this e s f entity state
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the start date of this e s f entity state.
	 *
	 * @return the start date of this e s f entity state
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this e s f entity state.
	 *
	 * @param startDate the start date of this e s f entity state
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this e s f entity state.
	 *
	 * @return the end date of this e s f entity state
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f entity state.
	 *
	 * @param endDate the end date of this e s f entity state
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the esf state ID of this e s f entity state.
	 *
	 * @return the esf state ID of this e s f entity state
	 */
	public long getEsfStateId();

	/**
	 * Sets the esf state ID of this e s f entity state.
	 *
	 * @param esfStateId the esf state ID of this e s f entity state
	 */
	public void setEsfStateId(long esfStateId);

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
	public int compareTo(it.ethica.esf.model.ESFEntityState esfEntityState);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFEntityState> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFEntityState toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFEntityState toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}