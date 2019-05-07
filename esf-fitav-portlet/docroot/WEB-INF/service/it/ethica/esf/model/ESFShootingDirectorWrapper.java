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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFShootingDirector}.
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirector
 * @generated
 */
public class ESFShootingDirectorWrapper implements ESFShootingDirector,
	ModelWrapper<ESFShootingDirector> {
	public ESFShootingDirectorWrapper(ESFShootingDirector esfShootingDirector) {
		_esfShootingDirector = esfShootingDirector;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShootingDirector.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorId", getEsfShootingDirectorId());
		attributes.put("esfCodeData", getEsfCodeData());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("codeUser", getCodeUser());
		attributes.put("shootingDirectorQualificationId",
			getShootingDirectorQualificationId());
		attributes.put("sportTypeId", getSportTypeId());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("flagCrea", getFlagCrea());
		attributes.put("DateVar", getDateVar());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorId = (Long)attributes.get(
				"esfShootingDirectorId");

		if (esfShootingDirectorId != null) {
			setEsfShootingDirectorId(esfShootingDirectorId);
		}

		String esfCodeData = (String)attributes.get("esfCodeData");

		if (esfCodeData != null) {
			setEsfCodeData(esfCodeData);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long codeUser = (Long)attributes.get("codeUser");

		if (codeUser != null) {
			setCodeUser(codeUser);
		}

		Long shootingDirectorQualificationId = (Long)attributes.get(
				"shootingDirectorQualificationId");

		if (shootingDirectorQualificationId != null) {
			setShootingDirectorQualificationId(shootingDirectorQualificationId);
		}

		Long sportTypeId = (Long)attributes.get("sportTypeId");

		if (sportTypeId != null) {
			setSportTypeId(sportTypeId);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String flagCrea = (String)attributes.get("flagCrea");

		if (flagCrea != null) {
			setFlagCrea(flagCrea);
		}

		Date DateVar = (Date)attributes.get("DateVar");

		if (DateVar != null) {
			setDateVar(DateVar);
		}
	}

	/**
	* Returns the primary key of this e s f shooting director.
	*
	* @return the primary key of this e s f shooting director
	*/
	@Override
	public long getPrimaryKey() {
		return _esfShootingDirector.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooting director.
	*
	* @param primaryKey the primary key of this e s f shooting director
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfShootingDirector.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf shooting director ID of this e s f shooting director.
	*
	* @return the esf shooting director ID of this e s f shooting director
	*/
	@Override
	public long getEsfShootingDirectorId() {
		return _esfShootingDirector.getEsfShootingDirectorId();
	}

	/**
	* Sets the esf shooting director ID of this e s f shooting director.
	*
	* @param esfShootingDirectorId the esf shooting director ID of this e s f shooting director
	*/
	@Override
	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_esfShootingDirector.setEsfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Returns the esf code data of this e s f shooting director.
	*
	* @return the esf code data of this e s f shooting director
	*/
	@Override
	public java.lang.String getEsfCodeData() {
		return _esfShootingDirector.getEsfCodeData();
	}

	/**
	* Sets the esf code data of this e s f shooting director.
	*
	* @param esfCodeData the esf code data of this e s f shooting director
	*/
	@Override
	public void setEsfCodeData(java.lang.String esfCodeData) {
		_esfShootingDirector.setEsfCodeData(esfCodeData);
	}

	/**
	* Returns the esf start data of this e s f shooting director.
	*
	* @return the esf start data of this e s f shooting director
	*/
	@Override
	public java.util.Date getEsfStartData() {
		return _esfShootingDirector.getEsfStartData();
	}

	/**
	* Sets the esf start data of this e s f shooting director.
	*
	* @param esfStartData the esf start data of this e s f shooting director
	*/
	@Override
	public void setEsfStartData(java.util.Date esfStartData) {
		_esfShootingDirector.setEsfStartData(esfStartData);
	}

	/**
	* Returns the esf end data of this e s f shooting director.
	*
	* @return the esf end data of this e s f shooting director
	*/
	@Override
	public java.util.Date getEsfEndData() {
		return _esfShootingDirector.getEsfEndData();
	}

	/**
	* Sets the esf end data of this e s f shooting director.
	*
	* @param esfEndData the esf end data of this e s f shooting director
	*/
	@Override
	public void setEsfEndData(java.util.Date esfEndData) {
		_esfShootingDirector.setEsfEndData(esfEndData);
	}

	/**
	* Returns the esf user ID of this e s f shooting director.
	*
	* @return the esf user ID of this e s f shooting director
	*/
	@Override
	public long getEsfUserId() {
		return _esfShootingDirector.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f shooting director.
	*
	* @param esfUserId the esf user ID of this e s f shooting director
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfShootingDirector.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f shooting director.
	*
	* @return the esf user uuid of this e s f shooting director
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShootingDirector.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f shooting director.
	*
	* @param esfUserUuid the esf user uuid of this e s f shooting director
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfShootingDirector.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the code user of this e s f shooting director.
	*
	* @return the code user of this e s f shooting director
	*/
	@Override
	public long getCodeUser() {
		return _esfShootingDirector.getCodeUser();
	}

	/**
	* Sets the code user of this e s f shooting director.
	*
	* @param codeUser the code user of this e s f shooting director
	*/
	@Override
	public void setCodeUser(long codeUser) {
		_esfShootingDirector.setCodeUser(codeUser);
	}

	/**
	* Returns the shooting director qualification ID of this e s f shooting director.
	*
	* @return the shooting director qualification ID of this e s f shooting director
	*/
	@Override
	public long getShootingDirectorQualificationId() {
		return _esfShootingDirector.getShootingDirectorQualificationId();
	}

	/**
	* Sets the shooting director qualification ID of this e s f shooting director.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID of this e s f shooting director
	*/
	@Override
	public void setShootingDirectorQualificationId(
		long shootingDirectorQualificationId) {
		_esfShootingDirector.setShootingDirectorQualificationId(shootingDirectorQualificationId);
	}

	/**
	* Returns the sport type ID of this e s f shooting director.
	*
	* @return the sport type ID of this e s f shooting director
	*/
	@Override
	public long getSportTypeId() {
		return _esfShootingDirector.getSportTypeId();
	}

	/**
	* Sets the sport type ID of this e s f shooting director.
	*
	* @param sportTypeId the sport type ID of this e s f shooting director
	*/
	@Override
	public void setSportTypeId(long sportTypeId) {
		_esfShootingDirector.setSportTypeId(sportTypeId);
	}

	/**
	* Returns the region ID of this e s f shooting director.
	*
	* @return the region ID of this e s f shooting director
	*/
	@Override
	public java.lang.String getRegionId() {
		return _esfShootingDirector.getRegionId();
	}

	/**
	* Sets the region ID of this e s f shooting director.
	*
	* @param regionId the region ID of this e s f shooting director
	*/
	@Override
	public void setRegionId(java.lang.String regionId) {
		_esfShootingDirector.setRegionId(regionId);
	}

	/**
	* Returns the province ID of this e s f shooting director.
	*
	* @return the province ID of this e s f shooting director
	*/
	@Override
	public java.lang.String getProvinceId() {
		return _esfShootingDirector.getProvinceId();
	}

	/**
	* Sets the province ID of this e s f shooting director.
	*
	* @param provinceId the province ID of this e s f shooting director
	*/
	@Override
	public void setProvinceId(java.lang.String provinceId) {
		_esfShootingDirector.setProvinceId(provinceId);
	}

	/**
	* Returns the flag crea of this e s f shooting director.
	*
	* @return the flag crea of this e s f shooting director
	*/
	@Override
	public java.lang.String getFlagCrea() {
		return _esfShootingDirector.getFlagCrea();
	}

	/**
	* Sets the flag crea of this e s f shooting director.
	*
	* @param flagCrea the flag crea of this e s f shooting director
	*/
	@Override
	public void setFlagCrea(java.lang.String flagCrea) {
		_esfShootingDirector.setFlagCrea(flagCrea);
	}

	/**
	* Returns the date var of this e s f shooting director.
	*
	* @return the date var of this e s f shooting director
	*/
	@Override
	public java.util.Date getDateVar() {
		return _esfShootingDirector.getDateVar();
	}

	/**
	* Sets the date var of this e s f shooting director.
	*
	* @param DateVar the date var of this e s f shooting director
	*/
	@Override
	public void setDateVar(java.util.Date DateVar) {
		_esfShootingDirector.setDateVar(DateVar);
	}

	@Override
	public boolean isNew() {
		return _esfShootingDirector.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShootingDirector.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShootingDirector.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShootingDirector.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShootingDirector.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShootingDirector.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShootingDirector.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShootingDirector.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShootingDirector.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShootingDirector.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShootingDirector.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShootingDirectorWrapper((ESFShootingDirector)_esfShootingDirector.clone());
	}

	@Override
	public int compareTo(ESFShootingDirector esfShootingDirector) {
		return _esfShootingDirector.compareTo(esfShootingDirector);
	}

	@Override
	public int hashCode() {
		return _esfShootingDirector.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFShootingDirector> toCacheModel() {
		return _esfShootingDirector.toCacheModel();
	}

	@Override
	public ESFShootingDirector toEscapedModel() {
		return new ESFShootingDirectorWrapper(_esfShootingDirector.toEscapedModel());
	}

	@Override
	public ESFShootingDirector toUnescapedModel() {
		return new ESFShootingDirectorWrapper(_esfShootingDirector.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShootingDirector.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShootingDirector.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShootingDirector.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShootingDirectorWrapper)) {
			return false;
		}

		ESFShootingDirectorWrapper esfShootingDirectorWrapper = (ESFShootingDirectorWrapper)obj;

		if (Validator.equals(_esfShootingDirector,
					esfShootingDirectorWrapper._esfShootingDirector)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShootingDirector getWrappedESFShootingDirector() {
		return _esfShootingDirector;
	}

	@Override
	public ESFShootingDirector getWrappedModel() {
		return _esfShootingDirector;
	}

	@Override
	public void resetOriginalValues() {
		_esfShootingDirector.resetOriginalValues();
	}

	private ESFShootingDirector _esfShootingDirector;
}