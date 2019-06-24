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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFRadunoStaff}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoStaff
 * @generated
 */
public class ESFRadunoStaffWrapper implements ESFRadunoStaff,
	ModelWrapper<ESFRadunoStaff> {
	public ESFRadunoStaffWrapper(ESFRadunoStaff esfRadunoStaff) {
		_esfRadunoStaff = esfRadunoStaff;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoStaff.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoStaff.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_staff", getId_esf_raduno_staff());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_staff = (Long)attributes.get("id_esf_raduno_staff");

		if (id_esf_raduno_staff != null) {
			setId_esf_raduno_staff(id_esf_raduno_staff);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this e s f raduno staff.
	*
	* @return the primary key of this e s f raduno staff
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFRadunoStaffPK getPrimaryKey() {
		return _esfRadunoStaff.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno staff.
	*
	* @param primaryKey the primary key of this e s f raduno staff
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK primaryKey) {
		_esfRadunoStaff.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_staff of this e s f raduno staff.
	*
	* @return the id_esf_raduno_staff of this e s f raduno staff
	*/
	@Override
	public long getId_esf_raduno_staff() {
		return _esfRadunoStaff.getId_esf_raduno_staff();
	}

	/**
	* Sets the id_esf_raduno_staff of this e s f raduno staff.
	*
	* @param id_esf_raduno_staff the id_esf_raduno_staff of this e s f raduno staff
	*/
	@Override
	public void setId_esf_raduno_staff(long id_esf_raduno_staff) {
		_esfRadunoStaff.setId_esf_raduno_staff(id_esf_raduno_staff);
	}

	/**
	* Returns the id_esf_raduno of this e s f raduno staff.
	*
	* @return the id_esf_raduno of this e s f raduno staff
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRadunoStaff.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this e s f raduno staff.
	*
	* @param id_esf_raduno the id_esf_raduno of this e s f raduno staff
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRadunoStaff.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the user ID of this e s f raduno staff.
	*
	* @return the user ID of this e s f raduno staff
	*/
	@Override
	public long getUserId() {
		return _esfRadunoStaff.getUserId();
	}

	/**
	* Sets the user ID of this e s f raduno staff.
	*
	* @param userId the user ID of this e s f raduno staff
	*/
	@Override
	public void setUserId(long userId) {
		_esfRadunoStaff.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f raduno staff.
	*
	* @return the user uuid of this e s f raduno staff
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoStaff.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f raduno staff.
	*
	* @param userUuid the user uuid of this e s f raduno staff
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfRadunoStaff.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoStaff.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoStaff.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoStaff.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoStaff.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoStaff.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoStaff.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoStaff.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoStaff.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoStaff.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoStaff.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoStaff.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoStaffWrapper((ESFRadunoStaff)_esfRadunoStaff.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff) {
		return _esfRadunoStaff.compareTo(esfRadunoStaff);
	}

	@Override
	public int hashCode() {
		return _esfRadunoStaff.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRadunoStaff> toCacheModel() {
		return _esfRadunoStaff.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRadunoStaff toEscapedModel() {
		return new ESFRadunoStaffWrapper(_esfRadunoStaff.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRadunoStaff toUnescapedModel() {
		return new ESFRadunoStaffWrapper(_esfRadunoStaff.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoStaff.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoStaff.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoStaff.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoStaffWrapper)) {
			return false;
		}

		ESFRadunoStaffWrapper esfRadunoStaffWrapper = (ESFRadunoStaffWrapper)obj;

		if (Validator.equals(_esfRadunoStaff,
					esfRadunoStaffWrapper._esfRadunoStaff)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoStaff getWrappedESFRadunoStaff() {
		return _esfRadunoStaff;
	}

	@Override
	public ESFRadunoStaff getWrappedModel() {
		return _esfRadunoStaff;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoStaff.resetOriginalValues();
	}

	private ESFRadunoStaff _esfRadunoStaff;
}