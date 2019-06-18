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
 * This class is a wrapper for {@link VW_Azzurri}.
 * </p>
 *
 * @author Ethica
 * @see VW_Azzurri
 * @generated
 */
public class VW_AzzurriWrapper implements VW_Azzurri, ModelWrapper<VW_Azzurri> {
	public VW_AzzurriWrapper(VW_Azzurri vw_Azzurri) {
		_vw_Azzurri = vw_Azzurri;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Azzurri.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Azzurri.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfNationalId", getEsfNationalId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("invitato", getInvitato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfNationalId = (Long)attributes.get("esfNationalId");

		if (esfNationalId != null) {
			setEsfNationalId(esfNationalId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer invitato = (Integer)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}
	}

	/**
	* Returns the primary key of this v w_ azzurri.
	*
	* @return the primary key of this v w_ azzurri
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_AzzurriPK getPrimaryKey() {
		return _vw_Azzurri.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ azzurri.
	*
	* @param primaryKey the primary key of this v w_ azzurri
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_AzzurriPK primaryKey) {
		_vw_Azzurri.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf national ID of this v w_ azzurri.
	*
	* @return the esf national ID of this v w_ azzurri
	*/
	@Override
	public long getEsfNationalId() {
		return _vw_Azzurri.getEsfNationalId();
	}

	/**
	* Sets the esf national ID of this v w_ azzurri.
	*
	* @param esfNationalId the esf national ID of this v w_ azzurri
	*/
	@Override
	public void setEsfNationalId(long esfNationalId) {
		_vw_Azzurri.setEsfNationalId(esfNationalId);
	}

	/**
	* Returns the user ID of this v w_ azzurri.
	*
	* @return the user ID of this v w_ azzurri
	*/
	@Override
	public long getUserId() {
		return _vw_Azzurri.getUserId();
	}

	/**
	* Sets the user ID of this v w_ azzurri.
	*
	* @param userId the user ID of this v w_ azzurri
	*/
	@Override
	public void setUserId(long userId) {
		_vw_Azzurri.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v w_ azzurri.
	*
	* @return the user uuid of this v w_ azzurri
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_Azzurri.getUserUuid();
	}

	/**
	* Sets the user uuid of this v w_ azzurri.
	*
	* @param userUuid the user uuid of this v w_ azzurri
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vw_Azzurri.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v w_ azzurri.
	*
	* @return the user name of this v w_ azzurri
	*/
	@Override
	public java.lang.String getUserName() {
		return _vw_Azzurri.getUserName();
	}

	/**
	* Sets the user name of this v w_ azzurri.
	*
	* @param userName the user name of this v w_ azzurri
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vw_Azzurri.setUserName(userName);
	}

	/**
	* Returns the esf user ID of this v w_ azzurri.
	*
	* @return the esf user ID of this v w_ azzurri
	*/
	@Override
	public long getEsfUserId() {
		return _vw_Azzurri.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this v w_ azzurri.
	*
	* @param esfUserId the esf user ID of this v w_ azzurri
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_vw_Azzurri.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this v w_ azzurri.
	*
	* @return the esf user uuid of this v w_ azzurri
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_Azzurri.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this v w_ azzurri.
	*
	* @param esfUserUuid the esf user uuid of this v w_ azzurri
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_vw_Azzurri.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf sport type ID of this v w_ azzurri.
	*
	* @return the esf sport type ID of this v w_ azzurri
	*/
	@Override
	public long getEsfSportTypeId() {
		return _vw_Azzurri.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this v w_ azzurri.
	*
	* @param esfSportTypeId the esf sport type ID of this v w_ azzurri
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_vw_Azzurri.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the start date of this v w_ azzurri.
	*
	* @return the start date of this v w_ azzurri
	*/
	@Override
	public java.util.Date getStartDate() {
		return _vw_Azzurri.getStartDate();
	}

	/**
	* Sets the start date of this v w_ azzurri.
	*
	* @param startDate the start date of this v w_ azzurri
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_vw_Azzurri.setStartDate(startDate);
	}

	/**
	* Returns the end date of this v w_ azzurri.
	*
	* @return the end date of this v w_ azzurri
	*/
	@Override
	public java.util.Date getEndDate() {
		return _vw_Azzurri.getEndDate();
	}

	/**
	* Sets the end date of this v w_ azzurri.
	*
	* @param endDate the end date of this v w_ azzurri
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_vw_Azzurri.setEndDate(endDate);
	}

	/**
	* Returns the name of this v w_ azzurri.
	*
	* @return the name of this v w_ azzurri
	*/
	@Override
	public java.lang.String getName() {
		return _vw_Azzurri.getName();
	}

	/**
	* Sets the name of this v w_ azzurri.
	*
	* @param name the name of this v w_ azzurri
	*/
	@Override
	public void setName(java.lang.String name) {
		_vw_Azzurri.setName(name);
	}

	/**
	* Returns the description of this v w_ azzurri.
	*
	* @return the description of this v w_ azzurri
	*/
	@Override
	public java.lang.String getDescription() {
		return _vw_Azzurri.getDescription();
	}

	/**
	* Sets the description of this v w_ azzurri.
	*
	* @param description the description of this v w_ azzurri
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vw_Azzurri.setDescription(description);
	}

	/**
	* Returns the invitato of this v w_ azzurri.
	*
	* @return the invitato of this v w_ azzurri
	*/
	@Override
	public int getInvitato() {
		return _vw_Azzurri.getInvitato();
	}

	/**
	* Sets the invitato of this v w_ azzurri.
	*
	* @param invitato the invitato of this v w_ azzurri
	*/
	@Override
	public void setInvitato(int invitato) {
		_vw_Azzurri.setInvitato(invitato);
	}

	@Override
	public boolean isNew() {
		return _vw_Azzurri.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_Azzurri.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_Azzurri.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_Azzurri.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_Azzurri.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_Azzurri.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_Azzurri.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_Azzurri.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_Azzurri.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_Azzurri.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_Azzurri.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_AzzurriWrapper((VW_Azzurri)_vw_Azzurri.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.VW_Azzurri vw_Azzurri) {
		return _vw_Azzurri.compareTo(vw_Azzurri);
	}

	@Override
	public int hashCode() {
		return _vw_Azzurri.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_Azzurri> toCacheModel() {
		return _vw_Azzurri.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.VW_Azzurri toEscapedModel() {
		return new VW_AzzurriWrapper(_vw_Azzurri.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.VW_Azzurri toUnescapedModel() {
		return new VW_AzzurriWrapper(_vw_Azzurri.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_Azzurri.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_Azzurri.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_Azzurri.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_AzzurriWrapper)) {
			return false;
		}

		VW_AzzurriWrapper vw_AzzurriWrapper = (VW_AzzurriWrapper)obj;

		if (Validator.equals(_vw_Azzurri, vw_AzzurriWrapper._vw_Azzurri)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_Azzurri getWrappedVW_Azzurri() {
		return _vw_Azzurri;
	}

	@Override
	public VW_Azzurri getWrappedModel() {
		return _vw_Azzurri;
	}

	@Override
	public void resetOriginalValues() {
		_vw_Azzurri.resetOriginalValues();
	}

	private VW_Azzurri _vw_Azzurri;
}