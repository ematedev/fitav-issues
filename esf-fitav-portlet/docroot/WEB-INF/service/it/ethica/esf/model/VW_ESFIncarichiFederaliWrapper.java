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
 * This class is a wrapper for {@link VW_ESFIncarichiFederali}.
 * </p>
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederali
 * @generated
 */
public class VW_ESFIncarichiFederaliWrapper implements VW_ESFIncarichiFederali,
	ModelWrapper<VW_ESFIncarichiFederali> {
	public VW_ESFIncarichiFederaliWrapper(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		_vw_esfIncarichiFederali = vw_esfIncarichiFederali;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_ESFIncarichiFederali.class;
	}

	@Override
	public String getModelClassName() {
		return VW_ESFIncarichiFederali.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("code_", getCode_());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active_", getActive_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
		}

		String code_ = (String)attributes.get("code_");

		if (code_ != null) {
			setCode_(code_);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long startDate = (Long)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active_ = (Boolean)attributes.get("active_");

		if (active_ != null) {
			setActive_(active_);
		}
	}

	/**
	* Returns the primary key of this v w_ e s f incarichi federali.
	*
	* @return the primary key of this v w_ e s f incarichi federali
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK getPrimaryKey() {
		return _vw_esfIncarichiFederali.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ e s f incarichi federali.
	*
	* @param primaryKey the primary key of this v w_ e s f incarichi federali
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK primaryKey) {
		_vw_esfIncarichiFederali.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf user ID of this v w_ e s f incarichi federali.
	*
	* @return the esf user ID of this v w_ e s f incarichi federali
	*/
	@Override
	public long getEsfUserId() {
		return _vw_esfIncarichiFederali.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this v w_ e s f incarichi federali.
	*
	* @param esfUserId the esf user ID of this v w_ e s f incarichi federali
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_vw_esfIncarichiFederali.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this v w_ e s f incarichi federali.
	*
	* @return the esf user uuid of this v w_ e s f incarichi federali
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederali.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this v w_ e s f incarichi federali.
	*
	* @param esfUserUuid the esf user uuid of this v w_ e s f incarichi federali
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_vw_esfIncarichiFederali.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf federal role ID of this v w_ e s f incarichi federali.
	*
	* @return the esf federal role ID of this v w_ e s f incarichi federali
	*/
	@Override
	public long getEsfFederalRoleId() {
		return _vw_esfIncarichiFederali.getEsfFederalRoleId();
	}

	/**
	* Sets the esf federal role ID of this v w_ e s f incarichi federali.
	*
	* @param esfFederalRoleId the esf federal role ID of this v w_ e s f incarichi federali
	*/
	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_vw_esfIncarichiFederali.setEsfFederalRoleId(esfFederalRoleId);
	}

	/**
	* Returns the code_ of this v w_ e s f incarichi federali.
	*
	* @return the code_ of this v w_ e s f incarichi federali
	*/
	@Override
	public java.lang.String getCode_() {
		return _vw_esfIncarichiFederali.getCode_();
	}

	/**
	* Sets the code_ of this v w_ e s f incarichi federali.
	*
	* @param code_ the code_ of this v w_ e s f incarichi federali
	*/
	@Override
	public void setCode_(java.lang.String code_) {
		_vw_esfIncarichiFederali.setCode_(code_);
	}

	/**
	* Returns the description of this v w_ e s f incarichi federali.
	*
	* @return the description of this v w_ e s f incarichi federali
	*/
	@Override
	public java.lang.String getDescription() {
		return _vw_esfIncarichiFederali.getDescription();
	}

	/**
	* Sets the description of this v w_ e s f incarichi federali.
	*
	* @param description the description of this v w_ e s f incarichi federali
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vw_esfIncarichiFederali.setDescription(description);
	}

	/**
	* Returns the start date of this v w_ e s f incarichi federali.
	*
	* @return the start date of this v w_ e s f incarichi federali
	*/
	@Override
	public long getStartDate() {
		return _vw_esfIncarichiFederali.getStartDate();
	}

	/**
	* Sets the start date of this v w_ e s f incarichi federali.
	*
	* @param startDate the start date of this v w_ e s f incarichi federali
	*/
	@Override
	public void setStartDate(long startDate) {
		_vw_esfIncarichiFederali.setStartDate(startDate);
	}

	/**
	* Returns the end date of this v w_ e s f incarichi federali.
	*
	* @return the end date of this v w_ e s f incarichi federali
	*/
	@Override
	public java.util.Date getEndDate() {
		return _vw_esfIncarichiFederali.getEndDate();
	}

	/**
	* Sets the end date of this v w_ e s f incarichi federali.
	*
	* @param endDate the end date of this v w_ e s f incarichi federali
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_vw_esfIncarichiFederali.setEndDate(endDate);
	}

	/**
	* Returns the active_ of this v w_ e s f incarichi federali.
	*
	* @return the active_ of this v w_ e s f incarichi federali
	*/
	@Override
	public boolean getActive_() {
		return _vw_esfIncarichiFederali.getActive_();
	}

	/**
	* Returns <code>true</code> if this v w_ e s f incarichi federali is active_.
	*
	* @return <code>true</code> if this v w_ e s f incarichi federali is active_; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive_() {
		return _vw_esfIncarichiFederali.isActive_();
	}

	/**
	* Sets whether this v w_ e s f incarichi federali is active_.
	*
	* @param active_ the active_ of this v w_ e s f incarichi federali
	*/
	@Override
	public void setActive_(boolean active_) {
		_vw_esfIncarichiFederali.setActive_(active_);
	}

	@Override
	public boolean isNew() {
		return _vw_esfIncarichiFederali.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_esfIncarichiFederali.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_esfIncarichiFederali.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_esfIncarichiFederali.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_esfIncarichiFederali.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_esfIncarichiFederali.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_esfIncarichiFederali.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_esfIncarichiFederali.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_esfIncarichiFederali.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_esfIncarichiFederali.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_esfIncarichiFederali.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_ESFIncarichiFederaliWrapper((VW_ESFIncarichiFederali)_vw_esfIncarichiFederali.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		return _vw_esfIncarichiFederali.compareTo(vw_esfIncarichiFederali);
	}

	@Override
	public int hashCode() {
		return _vw_esfIncarichiFederali.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_ESFIncarichiFederali> toCacheModel() {
		return _vw_esfIncarichiFederali.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali toEscapedModel() {
		return new VW_ESFIncarichiFederaliWrapper(_vw_esfIncarichiFederali.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali toUnescapedModel() {
		return new VW_ESFIncarichiFederaliWrapper(_vw_esfIncarichiFederali.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_esfIncarichiFederali.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_esfIncarichiFederali.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_esfIncarichiFederali.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ESFIncarichiFederaliWrapper)) {
			return false;
		}

		VW_ESFIncarichiFederaliWrapper vw_esfIncarichiFederaliWrapper = (VW_ESFIncarichiFederaliWrapper)obj;

		if (Validator.equals(_vw_esfIncarichiFederali,
					vw_esfIncarichiFederaliWrapper._vw_esfIncarichiFederali)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_ESFIncarichiFederali getWrappedVW_ESFIncarichiFederali() {
		return _vw_esfIncarichiFederali;
	}

	@Override
	public VW_ESFIncarichiFederali getWrappedModel() {
		return _vw_esfIncarichiFederali;
	}

	@Override
	public void resetOriginalValues() {
		_vw_esfIncarichiFederali.resetOriginalValues();
	}

	private VW_ESFIncarichiFederali _vw_esfIncarichiFederali;
}