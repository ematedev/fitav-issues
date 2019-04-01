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
 * The base model interface for the ESFElectronic service. Represents a row in the &quot;ESFElectronic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFElectronicModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFElectronicImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFElectronic
 * @see it.ethica.esf.model.impl.ESFElectronicImpl
 * @see it.ethica.esf.model.impl.ESFElectronicModelImpl
 * @generated
 */
public interface ESFElectronicModel extends BaseModel<ESFElectronic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f electronic model instance should use the {@link ESFElectronic} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f electronic.
	 *
	 * @return the primary key of this e s f electronic
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f electronic.
	 *
	 * @param primaryKey the primary key of this e s f electronic
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the electronic ID of this e s f electronic.
	 *
	 * @return the electronic ID of this e s f electronic
	 */
	public long getElectronicId();

	/**
	 * Sets the electronic ID of this e s f electronic.
	 *
	 * @param electronicId the electronic ID of this e s f electronic
	 */
	public void setElectronicId(long electronicId);

	/**
	 * Returns the name of this e s f electronic.
	 *
	 * @return the name of this e s f electronic
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f electronic.
	 *
	 * @param name the name of this e s f electronic
	 */
	public void setName(String name);

	/**
	 * Returns the description of this e s f electronic.
	 *
	 * @return the description of this e s f electronic
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f electronic.
	 *
	 * @param description the description of this e s f electronic
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
	public int compareTo(ESFElectronic esfElectronic);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFElectronic> toCacheModel();

	@Override
	public ESFElectronic toEscapedModel();

	@Override
	public ESFElectronic toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}