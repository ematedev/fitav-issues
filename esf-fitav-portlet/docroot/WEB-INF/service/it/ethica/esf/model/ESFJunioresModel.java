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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFJuniores service. Represents a row in the &quot;ESFJuniores&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFJunioresModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFJunioresImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFJuniores
 * @see it.ethica.esf.model.impl.ESFJunioresImpl
 * @see it.ethica.esf.model.impl.ESFJunioresModelImpl
 * @generated
 */
public interface ESFJunioresModel extends BaseModel<ESFJuniores> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f juniores model instance should use the {@link ESFJuniores} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f juniores.
	 *
	 * @return the primary key of this e s f juniores
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f juniores.
	 *
	 * @param primaryKey the primary key of this e s f juniores
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the e s f user ID of this e s f juniores.
	 *
	 * @return the e s f user ID of this e s f juniores
	 */
	public long getESFUserId();

	/**
	 * Sets the e s f user ID of this e s f juniores.
	 *
	 * @param ESFUserId the e s f user ID of this e s f juniores
	 */
	public void setESFUserId(long ESFUserId);

	/**
	 * Returns the e s f user uuid of this e s f juniores.
	 *
	 * @return the e s f user uuid of this e s f juniores
	 * @throws SystemException if a system exception occurred
	 */
	public String getESFUserUuid() throws SystemException;

	/**
	 * Sets the e s f user uuid of this e s f juniores.
	 *
	 * @param ESFUserUuid the e s f user uuid of this e s f juniores
	 */
	public void setESFUserUuid(String ESFUserUuid);

	/**
	 * Returns the start date of this e s f juniores.
	 *
	 * @return the start date of this e s f juniores
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this e s f juniores.
	 *
	 * @param startDate the start date of this e s f juniores
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this e s f juniores.
	 *
	 * @return the end date of this e s f juniores
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f juniores.
	 *
	 * @param endDate the end date of this e s f juniores
	 */
	public void setEndDate(Date endDate);

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
	public int compareTo(ESFJuniores esfJuniores);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFJuniores> toCacheModel();

	@Override
	public ESFJuniores toEscapedModel();

	@Override
	public ESFJuniores toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}