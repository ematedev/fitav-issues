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

package com.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFStockist}.
 * </p>
 *
 * @author Ethica
 * @see ESFStockist
 * @generated
 */
public class ESFStockistWrapper implements ESFStockist,
	ModelWrapper<ESFStockist> {
	public ESFStockistWrapper(ESFStockist esfStockist) {
		_esfStockist = esfStockist;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFStockist.class;
	}

	@Override
	public String getModelClassName() {
		return ESFStockist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStockistId", getEsfStockistId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("address", getAddress());
		attributes.put("nameReference", getNameReference());
		attributes.put("lastNameReference", getLastNameReference());
		attributes.put("emailReference", getEmailReference());
		attributes.put("phoneReference", getPhoneReference());
		attributes.put("description", getDescription());
		attributes.put("other", getOther());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String nameReference = (String)attributes.get("nameReference");

		if (nameReference != null) {
			setNameReference(nameReference);
		}

		String lastNameReference = (String)attributes.get("lastNameReference");

		if (lastNameReference != null) {
			setLastNameReference(lastNameReference);
		}

		String emailReference = (String)attributes.get("emailReference");

		if (emailReference != null) {
			setEmailReference(emailReference);
		}

		String phoneReference = (String)attributes.get("phoneReference");

		if (phoneReference != null) {
			setPhoneReference(phoneReference);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String other = (String)attributes.get("other");

		if (other != null) {
			setOther(other);
		}
	}

	/**
	* Returns the primary key of this e s f stockist.
	*
	* @return the primary key of this e s f stockist
	*/
	@Override
	public long getPrimaryKey() {
		return _esfStockist.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f stockist.
	*
	* @param primaryKey the primary key of this e s f stockist
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfStockist.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf stockist ID of this e s f stockist.
	*
	* @return the esf stockist ID of this e s f stockist
	*/
	@Override
	public long getEsfStockistId() {
		return _esfStockist.getEsfStockistId();
	}

	/**
	* Sets the esf stockist ID of this e s f stockist.
	*
	* @param esfStockistId the esf stockist ID of this e s f stockist
	*/
	@Override
	public void setEsfStockistId(long esfStockistId) {
		_esfStockist.setEsfStockistId(esfStockistId);
	}

	/**
	* Returns the name of this e s f stockist.
	*
	* @return the name of this e s f stockist
	*/
	@Override
	public java.lang.String getName() {
		return _esfStockist.getName();
	}

	/**
	* Sets the name of this e s f stockist.
	*
	* @param name the name of this e s f stockist
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfStockist.setName(name);
	}

	/**
	* Returns the email of this e s f stockist.
	*
	* @return the email of this e s f stockist
	*/
	@Override
	public java.lang.String getEmail() {
		return _esfStockist.getEmail();
	}

	/**
	* Sets the email of this e s f stockist.
	*
	* @param email the email of this e s f stockist
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_esfStockist.setEmail(email);
	}

	/**
	* Returns the phone of this e s f stockist.
	*
	* @return the phone of this e s f stockist
	*/
	@Override
	public java.lang.String getPhone() {
		return _esfStockist.getPhone();
	}

	/**
	* Sets the phone of this e s f stockist.
	*
	* @param phone the phone of this e s f stockist
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_esfStockist.setPhone(phone);
	}

	/**
	* Returns the address of this e s f stockist.
	*
	* @return the address of this e s f stockist
	*/
	@Override
	public java.lang.String getAddress() {
		return _esfStockist.getAddress();
	}

	/**
	* Sets the address of this e s f stockist.
	*
	* @param address the address of this e s f stockist
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_esfStockist.setAddress(address);
	}

	/**
	* Returns the name reference of this e s f stockist.
	*
	* @return the name reference of this e s f stockist
	*/
	@Override
	public java.lang.String getNameReference() {
		return _esfStockist.getNameReference();
	}

	/**
	* Sets the name reference of this e s f stockist.
	*
	* @param nameReference the name reference of this e s f stockist
	*/
	@Override
	public void setNameReference(java.lang.String nameReference) {
		_esfStockist.setNameReference(nameReference);
	}

	/**
	* Returns the last name reference of this e s f stockist.
	*
	* @return the last name reference of this e s f stockist
	*/
	@Override
	public java.lang.String getLastNameReference() {
		return _esfStockist.getLastNameReference();
	}

	/**
	* Sets the last name reference of this e s f stockist.
	*
	* @param lastNameReference the last name reference of this e s f stockist
	*/
	@Override
	public void setLastNameReference(java.lang.String lastNameReference) {
		_esfStockist.setLastNameReference(lastNameReference);
	}

	/**
	* Returns the email reference of this e s f stockist.
	*
	* @return the email reference of this e s f stockist
	*/
	@Override
	public java.lang.String getEmailReference() {
		return _esfStockist.getEmailReference();
	}

	/**
	* Sets the email reference of this e s f stockist.
	*
	* @param emailReference the email reference of this e s f stockist
	*/
	@Override
	public void setEmailReference(java.lang.String emailReference) {
		_esfStockist.setEmailReference(emailReference);
	}

	/**
	* Returns the phone reference of this e s f stockist.
	*
	* @return the phone reference of this e s f stockist
	*/
	@Override
	public java.lang.String getPhoneReference() {
		return _esfStockist.getPhoneReference();
	}

	/**
	* Sets the phone reference of this e s f stockist.
	*
	* @param phoneReference the phone reference of this e s f stockist
	*/
	@Override
	public void setPhoneReference(java.lang.String phoneReference) {
		_esfStockist.setPhoneReference(phoneReference);
	}

	/**
	* Returns the description of this e s f stockist.
	*
	* @return the description of this e s f stockist
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfStockist.getDescription();
	}

	/**
	* Sets the description of this e s f stockist.
	*
	* @param description the description of this e s f stockist
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfStockist.setDescription(description);
	}

	/**
	* Returns the other of this e s f stockist.
	*
	* @return the other of this e s f stockist
	*/
	@Override
	public java.lang.String getOther() {
		return _esfStockist.getOther();
	}

	/**
	* Sets the other of this e s f stockist.
	*
	* @param other the other of this e s f stockist
	*/
	@Override
	public void setOther(java.lang.String other) {
		_esfStockist.setOther(other);
	}

	@Override
	public boolean isNew() {
		return _esfStockist.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfStockist.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfStockist.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfStockist.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfStockist.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfStockist.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfStockist.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfStockist.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfStockist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfStockist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfStockist.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFStockistWrapper((ESFStockist)_esfStockist.clone());
	}

	@Override
	public int compareTo(com.ethica.esf.model.ESFStockist esfStockist) {
		return _esfStockist.compareTo(esfStockist);
	}

	@Override
	public int hashCode() {
		return _esfStockist.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFStockist> toCacheModel() {
		return _esfStockist.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFStockist toEscapedModel() {
		return new ESFStockistWrapper(_esfStockist.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFStockist toUnescapedModel() {
		return new ESFStockistWrapper(_esfStockist.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfStockist.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfStockist.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfStockist.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStockistWrapper)) {
			return false;
		}

		ESFStockistWrapper esfStockistWrapper = (ESFStockistWrapper)obj;

		if (Validator.equals(_esfStockist, esfStockistWrapper._esfStockist)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFStockist getWrappedESFStockist() {
		return _esfStockist;
	}

	@Override
	public ESFStockist getWrappedModel() {
		return _esfStockist;
	}

	@Override
	public void resetOriginalValues() {
		_esfStockist.resetOriginalValues();
	}

	private ESFStockist _esfStockist;
}