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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFPublicAuthority service. Represents a row in the &quot;ESFPublicAuthority&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFPublicAuthorityImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFPublicAuthority
 * @see it.ethica.esf.model.impl.ESFPublicAuthorityImpl
 * @see it.ethica.esf.model.impl.ESFPublicAuthorityModelImpl
 * @generated
 */
public interface ESFPublicAuthorityModel extends BaseModel<ESFPublicAuthority> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f public authority model instance should use the {@link ESFPublicAuthority} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f public authority.
	 *
	 * @return the primary key of this e s f public authority
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f public authority.
	 *
	 * @param primaryKey the primary key of this e s f public authority
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf public authority ID of this e s f public authority.
	 *
	 * @return the esf public authority ID of this e s f public authority
	 */
	public long getEsfPublicAuthorityId();

	/**
	 * Sets the esf public authority ID of this e s f public authority.
	 *
	 * @param esfPublicAuthorityId the esf public authority ID of this e s f public authority
	 */
	public void setEsfPublicAuthorityId(long esfPublicAuthorityId);

	/**
	 * Returns the create date of this e s f public authority.
	 *
	 * @return the create date of this e s f public authority
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f public authority.
	 *
	 * @param createDate the create date of this e s f public authority
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f public authority.
	 *
	 * @return the modified date of this e s f public authority
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f public authority.
	 *
	 * @param modifiedDate the modified date of this e s f public authority
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this e s f public authority.
	 *
	 * @return the description of this e s f public authority
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f public authority.
	 *
	 * @param description the description of this e s f public authority
	 */
	public void setDescription(String description);

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
	public int compareTo(ESFPublicAuthority esfPublicAuthority);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFPublicAuthority> toCacheModel();

	@Override
	public ESFPublicAuthority toEscapedModel();

	@Override
	public ESFPublicAuthority toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}