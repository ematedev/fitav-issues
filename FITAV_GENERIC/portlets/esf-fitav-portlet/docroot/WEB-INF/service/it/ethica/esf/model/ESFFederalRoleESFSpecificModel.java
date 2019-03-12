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

import it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK;

import java.io.Serializable;

/**
 * The base model interface for the ESFFederalRoleESFSpecific service. Represents a row in the &quot;ESFFederalRoleESFSpecific&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecific
 * @see it.ethica.esf.model.impl.ESFFederalRoleESFSpecificImpl
 * @see it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl
 * @generated
 */
public interface ESFFederalRoleESFSpecificModel extends BaseModel<ESFFederalRoleESFSpecific> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f federal role e s f specific model instance should use the {@link ESFFederalRoleESFSpecific} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f federal role e s f specific.
	 *
	 * @return the primary key of this e s f federal role e s f specific
	 */
	public ESFFederalRoleESFSpecificPK getPrimaryKey();

	/**
	 * Sets the primary key of this e s f federal role e s f specific.
	 *
	 * @param primaryKey the primary key of this e s f federal role e s f specific
	 */
	public void setPrimaryKey(ESFFederalRoleESFSpecificPK primaryKey);

	/**
	 * Returns the uuid of this e s f federal role e s f specific.
	 *
	 * @return the uuid of this e s f federal role e s f specific
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this e s f federal role e s f specific.
	 *
	 * @param uuid the uuid of this e s f federal role e s f specific
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the esf specific ID of this e s f federal role e s f specific.
	 *
	 * @return the esf specific ID of this e s f federal role e s f specific
	 */
	public long getEsfSpecificId();

	/**
	 * Sets the esf specific ID of this e s f federal role e s f specific.
	 *
	 * @param esfSpecificId the esf specific ID of this e s f federal role e s f specific
	 */
	public void setEsfSpecificId(long esfSpecificId);

	/**
	 * Returns the esf federal role ID of this e s f federal role e s f specific.
	 *
	 * @return the esf federal role ID of this e s f federal role e s f specific
	 */
	public long getEsfFederalRoleId();

	/**
	 * Sets the esf federal role ID of this e s f federal role e s f specific.
	 *
	 * @param esfFederalRoleId the esf federal role ID of this e s f federal role e s f specific
	 */
	public void setEsfFederalRoleId(long esfFederalRoleId);

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
	public int compareTo(ESFFederalRoleESFSpecific esfFederalRoleESFSpecific);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFFederalRoleESFSpecific> toCacheModel();

	@Override
	public ESFFederalRoleESFSpecific toEscapedModel();

	@Override
	public ESFFederalRoleESFSpecific toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}