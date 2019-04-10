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
 * This class is a wrapper for {@link ESFPhone}.
 * </p>
 *
 * @author Ethica
 * @see ESFPhone
 * @generated
 */
public class ESFPhoneWrapper implements ESFPhone, ModelWrapper<ESFPhone> {
	public ESFPhoneWrapper(ESFPhone esfPhone) {
		_esfPhone = esfPhone;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPhone.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPhone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPhoneId", getEsfPhoneId());
		attributes.put("listTypeId", getListTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPhoneId = (Long)attributes.get("esfPhoneId");

		if (esfPhoneId != null) {
			setEsfPhoneId(esfPhoneId);
		}

		Integer listTypeId = (Integer)attributes.get("listTypeId");

		if (listTypeId != null) {
			setListTypeId(listTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f phone.
	*
	* @return the primary key of this e s f phone
	*/
	@Override
	public long getPrimaryKey() {
		return _esfPhone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f phone.
	*
	* @param primaryKey the primary key of this e s f phone
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfPhone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf phone ID of this e s f phone.
	*
	* @return the esf phone ID of this e s f phone
	*/
	@Override
	public long getEsfPhoneId() {
		return _esfPhone.getEsfPhoneId();
	}

	/**
	* Sets the esf phone ID of this e s f phone.
	*
	* @param esfPhoneId the esf phone ID of this e s f phone
	*/
	@Override
	public void setEsfPhoneId(long esfPhoneId) {
		_esfPhone.setEsfPhoneId(esfPhoneId);
	}

	/**
	* Returns the list type ID of this e s f phone.
	*
	* @return the list type ID of this e s f phone
	*/
	@Override
	public int getListTypeId() {
		return _esfPhone.getListTypeId();
	}

	/**
	* Sets the list type ID of this e s f phone.
	*
	* @param listTypeId the list type ID of this e s f phone
	*/
	@Override
	public void setListTypeId(int listTypeId) {
		_esfPhone.setListTypeId(listTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfPhone.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfPhone.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfPhone.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfPhone.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfPhone.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfPhone.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfPhone.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfPhone.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfPhone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfPhone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfPhone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFPhoneWrapper((ESFPhone)_esfPhone.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFPhone esfPhone) {
		return _esfPhone.compareTo(esfPhone);
	}

	@Override
	public int hashCode() {
		return _esfPhone.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFPhone> toCacheModel() {
		return _esfPhone.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFPhone toEscapedModel() {
		return new ESFPhoneWrapper(_esfPhone.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFPhone toUnescapedModel() {
		return new ESFPhoneWrapper(_esfPhone.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfPhone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfPhone.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPhone.persist();
	}

	@Override
	public long getCompanyId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getCompanyId();
	}

	@Override
	public void setCompanyId(long companyId) {
		_esfPhone.setCompanyId(companyId);
	}

	@Override
	public long getUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getUserId();
	}

	@Override
	public void setUserId(long userId) {
		_esfPhone.setUserId(userId);
	}

	@Override
	public java.lang.String getUserName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getUserName();
	}

	@Override
	public void setUserName(java.lang.String userName) {
		_esfPhone.setUserName(userName);
	}

	@Override
	public java.util.Date getCreateDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getCreateDate();
	}

	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfPhone.setCreateDate(createDate);
	}

	@Override
	public java.util.Date getModifiedDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getModifiedDate();
	}

	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfPhone.setModifiedDate(modifiedDate);
	}

	@Override
	public long getClassNameId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getClassNameId();
	}

	@Override
	public void setClassNameId(long classNameId) {
		_esfPhone.setClassNameId(classNameId);
	}

	@Override
	public long getClassPk()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getClassPk();
	}

	@Override
	public void setClassPk(long classPk) {
		_esfPhone.setClassPk(classPk);
	}

	@Override
	public java.lang.String getNumber()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getNumber();
	}

	@Override
	public void setNumber(java.lang.String number) {
		_esfPhone.setNumber(number);
	}

	@Override
	public int getTypeId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.getTypeId();
	}

	@Override
	public void setTypeId(int typeId) {
		_esfPhone.setTypeId(typeId);
	}

	@Override
	public boolean isPrimary()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPhone.isPrimary();
	}

	@Override
	public void setPrimary(boolean primary) {
		_esfPhone.setPrimary(primary);
	}

	@Override
	public boolean isWrapper() {
		return _esfPhone.isWrapper();
	}

	@Override
	public void setWrapper(boolean isWrapper) {
		_esfPhone.setWrapper(isWrapper);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPhoneWrapper)) {
			return false;
		}

		ESFPhoneWrapper esfPhoneWrapper = (ESFPhoneWrapper)obj;

		if (Validator.equals(_esfPhone, esfPhoneWrapper._esfPhone)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFPhone getWrappedESFPhone() {
		return _esfPhone;
	}

	@Override
	public ESFPhone getWrappedModel() {
		return _esfPhone;
	}

	@Override
	public void resetOriginalValues() {
		_esfPhone.resetOriginalValues();
	}

	private ESFPhone _esfPhone;
}