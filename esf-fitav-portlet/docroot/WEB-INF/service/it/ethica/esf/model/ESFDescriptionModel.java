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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ESFDescription service. Represents a row in the &quot;ESFDescription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFDescriptionImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFDescription
 * @see it.ethica.esf.model.impl.ESFDescriptionImpl
 * @see it.ethica.esf.model.impl.ESFDescriptionModelImpl
 * @generated
 */
public interface ESFDescriptionModel extends BaseModel<ESFDescription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f description model instance should use the {@link ESFDescription} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f description.
	 *
	 * @return the primary key of this e s f description
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f description.
	 *
	 * @param primaryKey the primary key of this e s f description
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf description ID of this e s f description.
	 *
	 * @return the esf description ID of this e s f description
	 */
	public long getEsfDescriptionId();

	/**
	 * Sets the esf description ID of this e s f description.
	 *
	 * @param esfDescriptionId the esf description ID of this e s f description
	 */
	public void setEsfDescriptionId(long esfDescriptionId);

	/**
	 * Returns the is national of this e s f description.
	 *
	 * @return the is national of this e s f description
	 */
	public boolean getIsNational();

	/**
	 * Returns <code>true</code> if this e s f description is is national.
	 *
	 * @return <code>true</code> if this e s f description is is national; <code>false</code> otherwise
	 */
	public boolean isIsNational();

	/**
	 * Sets whether this e s f description is is national.
	 *
	 * @param isNational the is national of this e s f description
	 */
	public void setIsNational(boolean isNational);

	/**
	 * Returns the name of this e s f description.
	 *
	 * @return the name of this e s f description
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f description.
	 *
	 * @param name the name of this e s f description
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
	public int compareTo(ESFDescription esfDescription);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFDescription> toCacheModel();

	@Override
	public ESFDescription toEscapedModel();

	@Override
	public ESFDescription toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}