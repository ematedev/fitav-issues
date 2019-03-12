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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ESFPhone service. Represents a row in the &quot;ESFPhone&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFPhoneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFPhoneImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFPhone
 * @see it.ethica.esf.model.impl.ESFPhoneImpl
 * @see it.ethica.esf.model.impl.ESFPhoneModelImpl
 * @generated
 */
public interface ESFPhoneModel extends BaseModel<ESFPhone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f phone model instance should use the {@link ESFPhone} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f phone.
	 *
	 * @return the primary key of this e s f phone
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f phone.
	 *
	 * @param primaryKey the primary key of this e s f phone
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf phone ID of this e s f phone.
	 *
	 * @return the esf phone ID of this e s f phone
	 */
	public long getEsfPhoneId();

	/**
	 * Sets the esf phone ID of this e s f phone.
	 *
	 * @param esfPhoneId the esf phone ID of this e s f phone
	 */
	public void setEsfPhoneId(long esfPhoneId);

	/**
	 * Returns the list type ID of this e s f phone.
	 *
	 * @return the list type ID of this e s f phone
	 */
	public int getListTypeId();

	/**
	 * Sets the list type ID of this e s f phone.
	 *
	 * @param listTypeId the list type ID of this e s f phone
	 */
	public void setListTypeId(int listTypeId);

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
	public int compareTo(it.ethica.esf.model.ESFPhone esfPhone);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFPhone> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFPhone toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFPhone toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}