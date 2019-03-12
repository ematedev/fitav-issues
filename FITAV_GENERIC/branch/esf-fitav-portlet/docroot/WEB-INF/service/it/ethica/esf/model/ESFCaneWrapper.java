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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFCane}.
 * </p>
 *
 * @author Ethica
 * @see ESFCane
 * @generated
 */
public class ESFCaneWrapper implements ESFCane, ModelWrapper<ESFCane> {
	public ESFCaneWrapper(ESFCane esfCane) {
		_esfCane = esfCane;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCane.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCane.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCaneId", getEsfCaneId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("caneCaliber", getCaneCaliber());
		attributes.put("isFavoriteGun", getIsFavoriteGun());
		attributes.put("typeId", getTypeId());
		attributes.put("measures", getMeasures());
		attributes.put("shooterId", getShooterId());
		attributes.put("esfGunTypeId", getEsfGunTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCaneId = (Long)attributes.get("esfCaneId");

		if (esfCaneId != null) {
			setEsfCaneId(esfCaneId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long caneCaliber = (Long)attributes.get("caneCaliber");

		if (caneCaliber != null) {
			setCaneCaliber(caneCaliber);
		}

		Boolean isFavoriteGun = (Boolean)attributes.get("isFavoriteGun");

		if (isFavoriteGun != null) {
			setIsFavoriteGun(isFavoriteGun);
		}

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String measures = (String)attributes.get("measures");

		if (measures != null) {
			setMeasures(measures);
		}

		Long shooterId = (Long)attributes.get("shooterId");

		if (shooterId != null) {
			setShooterId(shooterId);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f cane.
	*
	* @return the primary key of this e s f cane
	*/
	@Override
	public long getPrimaryKey() {
		return _esfCane.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f cane.
	*
	* @param primaryKey the primary key of this e s f cane
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfCane.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f cane.
	*
	* @return the uuid of this e s f cane
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfCane.getUuid();
	}

	/**
	* Sets the uuid of this e s f cane.
	*
	* @param uuid the uuid of this e s f cane
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfCane.setUuid(uuid);
	}

	/**
	* Returns the esf cane ID of this e s f cane.
	*
	* @return the esf cane ID of this e s f cane
	*/
	@Override
	public long getEsfCaneId() {
		return _esfCane.getEsfCaneId();
	}

	/**
	* Sets the esf cane ID of this e s f cane.
	*
	* @param esfCaneId the esf cane ID of this e s f cane
	*/
	@Override
	public void setEsfCaneId(long esfCaneId) {
		_esfCane.setEsfCaneId(esfCaneId);
	}

	/**
	* Returns the esf user ID of this e s f cane.
	*
	* @return the esf user ID of this e s f cane
	*/
	@Override
	public long getEsfUserId() {
		return _esfCane.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f cane.
	*
	* @param esfUserId the esf user ID of this e s f cane
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfCane.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f cane.
	*
	* @return the esf user uuid of this e s f cane
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCane.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f cane.
	*
	* @param esfUserUuid the esf user uuid of this e s f cane
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfCane.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the code of this e s f cane.
	*
	* @return the code of this e s f cane
	*/
	@Override
	public java.lang.String getCode() {
		return _esfCane.getCode();
	}

	/**
	* Sets the code of this e s f cane.
	*
	* @param code the code of this e s f cane
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfCane.setCode(code);
	}

	/**
	* Returns the esf gun kind ID of this e s f cane.
	*
	* @return the esf gun kind ID of this e s f cane
	*/
	@Override
	public long getEsfGunKindId() {
		return _esfCane.getEsfGunKindId();
	}

	/**
	* Sets the esf gun kind ID of this e s f cane.
	*
	* @param esfGunKindId the esf gun kind ID of this e s f cane
	*/
	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfCane.setEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns the esf organization ID of this e s f cane.
	*
	* @return the esf organization ID of this e s f cane
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfCane.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f cane.
	*
	* @param esfOrganizationId the esf organization ID of this e s f cane
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfCane.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the cane caliber of this e s f cane.
	*
	* @return the cane caliber of this e s f cane
	*/
	@Override
	public long getCaneCaliber() {
		return _esfCane.getCaneCaliber();
	}

	/**
	* Sets the cane caliber of this e s f cane.
	*
	* @param caneCaliber the cane caliber of this e s f cane
	*/
	@Override
	public void setCaneCaliber(long caneCaliber) {
		_esfCane.setCaneCaliber(caneCaliber);
	}

	/**
	* Returns the is favorite gun of this e s f cane.
	*
	* @return the is favorite gun of this e s f cane
	*/
	@Override
	public boolean getIsFavoriteGun() {
		return _esfCane.getIsFavoriteGun();
	}

	/**
	* Returns <code>true</code> if this e s f cane is is favorite gun.
	*
	* @return <code>true</code> if this e s f cane is is favorite gun; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsFavoriteGun() {
		return _esfCane.isIsFavoriteGun();
	}

	/**
	* Sets whether this e s f cane is is favorite gun.
	*
	* @param isFavoriteGun the is favorite gun of this e s f cane
	*/
	@Override
	public void setIsFavoriteGun(boolean isFavoriteGun) {
		_esfCane.setIsFavoriteGun(isFavoriteGun);
	}

	/**
	* Returns the type ID of this e s f cane.
	*
	* @return the type ID of this e s f cane
	*/
	@Override
	public int getTypeId() {
		return _esfCane.getTypeId();
	}

	/**
	* Sets the type ID of this e s f cane.
	*
	* @param typeId the type ID of this e s f cane
	*/
	@Override
	public void setTypeId(int typeId) {
		_esfCane.setTypeId(typeId);
	}

	/**
	* Returns the measures of this e s f cane.
	*
	* @return the measures of this e s f cane
	*/
	@Override
	public java.lang.String getMeasures() {
		return _esfCane.getMeasures();
	}

	/**
	* Sets the measures of this e s f cane.
	*
	* @param measures the measures of this e s f cane
	*/
	@Override
	public void setMeasures(java.lang.String measures) {
		_esfCane.setMeasures(measures);
	}

	/**
	* Returns the shooter ID of this e s f cane.
	*
	* @return the shooter ID of this e s f cane
	*/
	@Override
	public long getShooterId() {
		return _esfCane.getShooterId();
	}

	/**
	* Sets the shooter ID of this e s f cane.
	*
	* @param shooterId the shooter ID of this e s f cane
	*/
	@Override
	public void setShooterId(long shooterId) {
		_esfCane.setShooterId(shooterId);
	}

	/**
	* Returns the esf gun type ID of this e s f cane.
	*
	* @return the esf gun type ID of this e s f cane
	*/
	@Override
	public long getEsfGunTypeId() {
		return _esfCane.getEsfGunTypeId();
	}

	/**
	* Sets the esf gun type ID of this e s f cane.
	*
	* @param esfGunTypeId the esf gun type ID of this e s f cane
	*/
	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfCane.setEsfGunTypeId(esfGunTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfCane.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCane.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCane.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCane.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCane.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCane.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCane.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCane.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCane.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCane.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCane.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCaneWrapper((ESFCane)_esfCane.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCane esfCane) {
		return _esfCane.compareTo(esfCane);
	}

	@Override
	public int hashCode() {
		return _esfCane.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCane> toCacheModel() {
		return _esfCane.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCane toEscapedModel() {
		return new ESFCaneWrapper(_esfCane.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCane toUnescapedModel() {
		return new ESFCaneWrapper(_esfCane.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCane.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCane.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCane.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCaneWrapper)) {
			return false;
		}

		ESFCaneWrapper esfCaneWrapper = (ESFCaneWrapper)obj;

		if (Validator.equals(_esfCane, esfCaneWrapper._esfCane)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCane getWrappedESFCane() {
		return _esfCane;
	}

	@Override
	public ESFCane getWrappedModel() {
		return _esfCane;
	}

	@Override
	public void resetOriginalValues() {
		_esfCane.resetOriginalValues();
	}

	private ESFCane _esfCane;
}