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
 * This class is a wrapper for {@link VW_Staff}.
 * </p>
 *
 * @author Ethica
 * @see VW_Staff
 * @generated
 */
public class VW_StaffWrapper implements VW_Staff, ModelWrapper<VW_Staff> {
	public VW_StaffWrapper(VW_Staff vw_Staff) {
		_vw_Staff = vw_Staff;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Staff.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Staff.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("createDate", getCreateDate());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("esfShootingDirectorQualificationDesc",
			getEsfShootingDirectorQualificationDesc());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("name", getName());
		attributes.put("invitato", getInvitato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String esfShootingDirectorQualificationDesc = (String)attributes.get(
				"esfShootingDirectorQualificationDesc");

		if (esfShootingDirectorQualificationDesc != null) {
			setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long invitato = (Long)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}
	}

	/**
	* Returns the primary key of this v w_ staff.
	*
	* @return the primary key of this v w_ staff
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_StaffPK getPrimaryKey() {
		return _vw_Staff.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ staff.
	*
	* @param primaryKey the primary key of this v w_ staff
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_StaffPK primaryKey) {
		_vw_Staff.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this v w_ staff.
	*
	* @return the user ID of this v w_ staff
	*/
	@Override
	public long getUserId() {
		return _vw_Staff.getUserId();
	}

	/**
	* Sets the user ID of this v w_ staff.
	*
	* @param userId the user ID of this v w_ staff
	*/
	@Override
	public void setUserId(long userId) {
		_vw_Staff.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v w_ staff.
	*
	* @return the user uuid of this v w_ staff
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_Staff.getUserUuid();
	}

	/**
	* Sets the user uuid of this v w_ staff.
	*
	* @param userUuid the user uuid of this v w_ staff
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vw_Staff.setUserUuid(userUuid);
	}

	/**
	* Returns the email address of this v w_ staff.
	*
	* @return the email address of this v w_ staff
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _vw_Staff.getEmailAddress();
	}

	/**
	* Sets the email address of this v w_ staff.
	*
	* @param emailAddress the email address of this v w_ staff
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_vw_Staff.setEmailAddress(emailAddress);
	}

	/**
	* Returns the first name of this v w_ staff.
	*
	* @return the first name of this v w_ staff
	*/
	@Override
	public java.lang.String getFirstName() {
		return _vw_Staff.getFirstName();
	}

	/**
	* Sets the first name of this v w_ staff.
	*
	* @param firstName the first name of this v w_ staff
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_vw_Staff.setFirstName(firstName);
	}

	/**
	* Returns the last name of this v w_ staff.
	*
	* @return the last name of this v w_ staff
	*/
	@Override
	public java.lang.String getLastName() {
		return _vw_Staff.getLastName();
	}

	/**
	* Sets the last name of this v w_ staff.
	*
	* @param lastName the last name of this v w_ staff
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_vw_Staff.setLastName(lastName);
	}

	/**
	* Returns the create date of this v w_ staff.
	*
	* @return the create date of this v w_ staff
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vw_Staff.getCreateDate();
	}

	/**
	* Sets the create date of this v w_ staff.
	*
	* @param createDate the create date of this v w_ staff
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vw_Staff.setCreateDate(createDate);
	}

	/**
	* Returns the esf start data of this v w_ staff.
	*
	* @return the esf start data of this v w_ staff
	*/
	@Override
	public java.util.Date getEsfStartData() {
		return _vw_Staff.getEsfStartData();
	}

	/**
	* Sets the esf start data of this v w_ staff.
	*
	* @param esfStartData the esf start data of this v w_ staff
	*/
	@Override
	public void setEsfStartData(java.util.Date esfStartData) {
		_vw_Staff.setEsfStartData(esfStartData);
	}

	/**
	* Returns the esf end data of this v w_ staff.
	*
	* @return the esf end data of this v w_ staff
	*/
	@Override
	public java.util.Date getEsfEndData() {
		return _vw_Staff.getEsfEndData();
	}

	/**
	* Sets the esf end data of this v w_ staff.
	*
	* @param esfEndData the esf end data of this v w_ staff
	*/
	@Override
	public void setEsfEndData(java.util.Date esfEndData) {
		_vw_Staff.setEsfEndData(esfEndData);
	}

	/**
	* Returns the region ID of this v w_ staff.
	*
	* @return the region ID of this v w_ staff
	*/
	@Override
	public java.lang.String getRegionId() {
		return _vw_Staff.getRegionId();
	}

	/**
	* Sets the region ID of this v w_ staff.
	*
	* @param regionId the region ID of this v w_ staff
	*/
	@Override
	public void setRegionId(java.lang.String regionId) {
		_vw_Staff.setRegionId(regionId);
	}

	/**
	* Returns the province ID of this v w_ staff.
	*
	* @return the province ID of this v w_ staff
	*/
	@Override
	public java.lang.String getProvinceId() {
		return _vw_Staff.getProvinceId();
	}

	/**
	* Sets the province ID of this v w_ staff.
	*
	* @param provinceId the province ID of this v w_ staff
	*/
	@Override
	public void setProvinceId(java.lang.String provinceId) {
		_vw_Staff.setProvinceId(provinceId);
	}

	/**
	* Returns the esf shooting director qualification desc of this v w_ staff.
	*
	* @return the esf shooting director qualification desc of this v w_ staff
	*/
	@Override
	public java.lang.String getEsfShootingDirectorQualificationDesc() {
		return _vw_Staff.getEsfShootingDirectorQualificationDesc();
	}

	/**
	* Sets the esf shooting director qualification desc of this v w_ staff.
	*
	* @param esfShootingDirectorQualificationDesc the esf shooting director qualification desc of this v w_ staff
	*/
	@Override
	public void setEsfShootingDirectorQualificationDesc(
		java.lang.String esfShootingDirectorQualificationDesc) {
		_vw_Staff.setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
	}

	/**
	* Returns the esf sport type ID of this v w_ staff.
	*
	* @return the esf sport type ID of this v w_ staff
	*/
	@Override
	public long getEsfSportTypeId() {
		return _vw_Staff.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this v w_ staff.
	*
	* @param esfSportTypeId the esf sport type ID of this v w_ staff
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_vw_Staff.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the name of this v w_ staff.
	*
	* @return the name of this v w_ staff
	*/
	@Override
	public java.lang.String getName() {
		return _vw_Staff.getName();
	}

	/**
	* Sets the name of this v w_ staff.
	*
	* @param name the name of this v w_ staff
	*/
	@Override
	public void setName(java.lang.String name) {
		_vw_Staff.setName(name);
	}

	/**
	* Returns the invitato of this v w_ staff.
	*
	* @return the invitato of this v w_ staff
	*/
	@Override
	public long getInvitato() {
		return _vw_Staff.getInvitato();
	}

	/**
	* Sets the invitato of this v w_ staff.
	*
	* @param invitato the invitato of this v w_ staff
	*/
	@Override
	public void setInvitato(long invitato) {
		_vw_Staff.setInvitato(invitato);
	}

	@Override
	public boolean isNew() {
		return _vw_Staff.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_Staff.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_Staff.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_Staff.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_Staff.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_Staff.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_Staff.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_Staff.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_Staff.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_Staff.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_Staff.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_StaffWrapper((VW_Staff)_vw_Staff.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.VW_Staff vw_Staff) {
		return _vw_Staff.compareTo(vw_Staff);
	}

	@Override
	public int hashCode() {
		return _vw_Staff.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_Staff> toCacheModel() {
		return _vw_Staff.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.VW_Staff toEscapedModel() {
		return new VW_StaffWrapper(_vw_Staff.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.VW_Staff toUnescapedModel() {
		return new VW_StaffWrapper(_vw_Staff.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_Staff.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_Staff.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_Staff.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_StaffWrapper)) {
			return false;
		}

		VW_StaffWrapper vw_StaffWrapper = (VW_StaffWrapper)obj;

		if (Validator.equals(_vw_Staff, vw_StaffWrapper._vw_Staff)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_Staff getWrappedVW_Staff() {
		return _vw_Staff;
	}

	@Override
	public VW_Staff getWrappedModel() {
		return _vw_Staff;
	}

	@Override
	public void resetOriginalValues() {
		_vw_Staff.resetOriginalValues();
	}

	private VW_Staff _vw_Staff;
}