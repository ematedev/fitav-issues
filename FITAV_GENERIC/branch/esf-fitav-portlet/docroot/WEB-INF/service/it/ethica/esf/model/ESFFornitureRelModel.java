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
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.ESFFornitureRelPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFFornitureRel service. Represents a row in the &quot;ESFFornitureRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFFornitureRelModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFFornitureRelImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureRel
 * @see it.ethica.esf.model.impl.ESFFornitureRelImpl
 * @see it.ethica.esf.model.impl.ESFFornitureRelModelImpl
 * @generated
 */
public interface ESFFornitureRelModel extends BaseModel<ESFFornitureRel>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f forniture rel model instance should use the {@link ESFFornitureRel} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f forniture rel.
	 *
	 * @return the primary key of this e s f forniture rel
	 */
	public ESFFornitureRelPK getPrimaryKey();

	/**
	 * Sets the primary key of this e s f forniture rel.
	 *
	 * @param primaryKey the primary key of this e s f forniture rel
	 */
	public void setPrimaryKey(ESFFornitureRelPK primaryKey);

	/**
	 * Returns the esf tool ID of this e s f forniture rel.
	 *
	 * @return the esf tool ID of this e s f forniture rel
	 */
	public long getEsfToolId();

	/**
	 * Sets the esf tool ID of this e s f forniture rel.
	 *
	 * @param esfToolId the esf tool ID of this e s f forniture rel
	 */
	public void setEsfToolId(long esfToolId);

	/**
	 * Returns the class name of this e s f forniture rel.
	 *
	 * @return the class name of this e s f forniture rel
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this e s f forniture rel.
	 *
	 * @param className the class name of this e s f forniture rel
	 */
	public void setClassName(String className);

	/**
	 * Returns the class p k of this e s f forniture rel.
	 *
	 * @return the class p k of this e s f forniture rel
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this e s f forniture rel.
	 *
	 * @param classPK the class p k of this e s f forniture rel
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the group ID of this e s f forniture rel.
	 *
	 * @return the group ID of this e s f forniture rel
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f forniture rel.
	 *
	 * @param groupId the group ID of this e s f forniture rel
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f forniture rel.
	 *
	 * @return the company ID of this e s f forniture rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f forniture rel.
	 *
	 * @param companyId the company ID of this e s f forniture rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f forniture rel.
	 *
	 * @return the user ID of this e s f forniture rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f forniture rel.
	 *
	 * @param userId the user ID of this e s f forniture rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f forniture rel.
	 *
	 * @return the user uuid of this e s f forniture rel
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f forniture rel.
	 *
	 * @param userUuid the user uuid of this e s f forniture rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f forniture rel.
	 *
	 * @return the user name of this e s f forniture rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f forniture rel.
	 *
	 * @param userName the user name of this e s f forniture rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f forniture rel.
	 *
	 * @return the create date of this e s f forniture rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f forniture rel.
	 *
	 * @param createDate the create date of this e s f forniture rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f forniture rel.
	 *
	 * @return the modified date of this e s f forniture rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f forniture rel.
	 *
	 * @param modifiedDate the modified date of this e s f forniture rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the assignment date of this e s f forniture rel.
	 *
	 * @return the assignment date of this e s f forniture rel
	 */
	public Date getAssignmentDate();

	/**
	 * Sets the assignment date of this e s f forniture rel.
	 *
	 * @param assignmentDate the assignment date of this e s f forniture rel
	 */
	public void setAssignmentDate(Date assignmentDate);

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
	public int compareTo(it.ethica.esf.model.ESFFornitureRel esfFornitureRel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFFornitureRel> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFFornitureRel toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFFornitureRel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}