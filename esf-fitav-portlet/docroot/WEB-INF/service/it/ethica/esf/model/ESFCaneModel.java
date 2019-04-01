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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ESFCane service. Represents a row in the &quot;ESFCane&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFCaneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFCaneImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFCane
 * @see it.ethica.esf.model.impl.ESFCaneImpl
 * @see it.ethica.esf.model.impl.ESFCaneModelImpl
 * @generated
 */
public interface ESFCaneModel extends BaseModel<ESFCane> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f cane model instance should use the {@link ESFCane} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f cane.
	 *
	 * @return the primary key of this e s f cane
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f cane.
	 *
	 * @param primaryKey the primary key of this e s f cane
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f cane.
	 *
	 * @return the uuid of this e s f cane
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this e s f cane.
	 *
	 * @param uuid the uuid of this e s f cane
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the esf cane ID of this e s f cane.
	 *
	 * @return the esf cane ID of this e s f cane
	 */
	public long getEsfCaneId();

	/**
	 * Sets the esf cane ID of this e s f cane.
	 *
	 * @param esfCaneId the esf cane ID of this e s f cane
	 */
	public void setEsfCaneId(long esfCaneId);

	/**
	 * Returns the esf user ID of this e s f cane.
	 *
	 * @return the esf user ID of this e s f cane
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f cane.
	 *
	 * @param esfUserId the esf user ID of this e s f cane
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f cane.
	 *
	 * @return the esf user uuid of this e s f cane
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f cane.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f cane
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the code of this e s f cane.
	 *
	 * @return the code of this e s f cane
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f cane.
	 *
	 * @param code the code of this e s f cane
	 */
	public void setCode(String code);

	/**
	 * Returns the esf gun kind ID of this e s f cane.
	 *
	 * @return the esf gun kind ID of this e s f cane
	 */
	public long getEsfGunKindId();

	/**
	 * Sets the esf gun kind ID of this e s f cane.
	 *
	 * @param esfGunKindId the esf gun kind ID of this e s f cane
	 */
	public void setEsfGunKindId(long esfGunKindId);

	/**
	 * Returns the esf organization ID of this e s f cane.
	 *
	 * @return the esf organization ID of this e s f cane
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f cane.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f cane
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the cane caliber of this e s f cane.
	 *
	 * @return the cane caliber of this e s f cane
	 */
	public long getCaneCaliber();

	/**
	 * Sets the cane caliber of this e s f cane.
	 *
	 * @param caneCaliber the cane caliber of this e s f cane
	 */
	public void setCaneCaliber(long caneCaliber);

	/**
	 * Returns the is favorite gun of this e s f cane.
	 *
	 * @return the is favorite gun of this e s f cane
	 */
	public boolean getIsFavoriteGun();

	/**
	 * Returns <code>true</code> if this e s f cane is is favorite gun.
	 *
	 * @return <code>true</code> if this e s f cane is is favorite gun; <code>false</code> otherwise
	 */
	public boolean isIsFavoriteGun();

	/**
	 * Sets whether this e s f cane is is favorite gun.
	 *
	 * @param isFavoriteGun the is favorite gun of this e s f cane
	 */
	public void setIsFavoriteGun(boolean isFavoriteGun);

	/**
	 * Returns the type ID of this e s f cane.
	 *
	 * @return the type ID of this e s f cane
	 */
	public int getTypeId();

	/**
	 * Sets the type ID of this e s f cane.
	 *
	 * @param typeId the type ID of this e s f cane
	 */
	public void setTypeId(int typeId);

	/**
	 * Returns the measures of this e s f cane.
	 *
	 * @return the measures of this e s f cane
	 */
	@AutoEscape
	public String getMeasures();

	/**
	 * Sets the measures of this e s f cane.
	 *
	 * @param measures the measures of this e s f cane
	 */
	public void setMeasures(String measures);

	/**
	 * Returns the shooter ID of this e s f cane.
	 *
	 * @return the shooter ID of this e s f cane
	 */
	public long getShooterId();

	/**
	 * Sets the shooter ID of this e s f cane.
	 *
	 * @param shooterId the shooter ID of this e s f cane
	 */
	public void setShooterId(long shooterId);

	/**
	 * Returns the esf gun type ID of this e s f cane.
	 *
	 * @return the esf gun type ID of this e s f cane
	 */
	public long getEsfGunTypeId();

	/**
	 * Sets the esf gun type ID of this e s f cane.
	 *
	 * @param esfGunTypeId the esf gun type ID of this e s f cane
	 */
	public void setEsfGunTypeId(long esfGunTypeId);

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
	public int compareTo(ESFCane esfCane);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFCane> toCacheModel();

	@Override
	public ESFCane toEscapedModel();

	@Override
	public ESFCane toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}