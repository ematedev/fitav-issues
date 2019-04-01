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
 * The base model interface for the ESFJob service. Represents a row in the &quot;ESFJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFJobModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFJobImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFJob
 * @see it.ethica.esf.model.impl.ESFJobImpl
 * @see it.ethica.esf.model.impl.ESFJobModelImpl
 * @generated
 */
public interface ESFJobModel extends BaseModel<ESFJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f job model instance should use the {@link ESFJob} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f job.
	 *
	 * @return the primary key of this e s f job
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f job.
	 *
	 * @param primaryKey the primary key of this e s f job
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf job ID of this e s f job.
	 *
	 * @return the esf job ID of this e s f job
	 */
	public long getEsfJobId();

	/**
	 * Sets the esf job ID of this e s f job.
	 *
	 * @param esfJobId the esf job ID of this e s f job
	 */
	public void setEsfJobId(long esfJobId);

	/**
	 * Returns the esf name of this e s f job.
	 *
	 * @return the esf name of this e s f job
	 */
	@AutoEscape
	public String getEsfName();

	/**
	 * Sets the esf name of this e s f job.
	 *
	 * @param esfName the esf name of this e s f job
	 */
	public void setEsfName(String esfName);

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
	public int compareTo(ESFJob esfJob);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFJob> toCacheModel();

	@Override
	public ESFJob toEscapedModel();

	@Override
	public ESFJob toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}