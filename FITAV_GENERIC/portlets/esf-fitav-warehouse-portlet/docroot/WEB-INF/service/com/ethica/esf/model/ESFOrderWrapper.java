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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFOrder}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrder
 * @generated
 */
public class ESFOrderWrapper implements ESFOrder, ModelWrapper<ESFOrder> {
	public ESFOrderWrapper(ESFOrder esfOrder) {
		_esfOrder = esfOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("date", getDate());
		attributes.put("note", getNote());
		attributes.put("protocolCode", getProtocolCode());
		attributes.put("attachment", getAttachment());
		attributes.put("state", getState());
		attributes.put("esfStockistId", getEsfStockistId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String protocolCode = (String)attributes.get("protocolCode");

		if (protocolCode != null) {
			setProtocolCode(protocolCode);
		}

		String attachment = (String)attributes.get("attachment");

		if (attachment != null) {
			setAttachment(attachment);
		}

		Integer state = (Integer)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}
	}

	/**
	* Returns the primary key of this e s f order.
	*
	* @return the primary key of this e s f order
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f order.
	*
	* @param primaryKey the primary key of this e s f order
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf order ID of this e s f order.
	*
	* @return the esf order ID of this e s f order
	*/
	@Override
	public long getEsfOrderId() {
		return _esfOrder.getEsfOrderId();
	}

	/**
	* Sets the esf order ID of this e s f order.
	*
	* @param esfOrderId the esf order ID of this e s f order
	*/
	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfOrder.setEsfOrderId(esfOrderId);
	}

	/**
	* Returns the code of this e s f order.
	*
	* @return the code of this e s f order
	*/
	@Override
	public java.lang.String getCode() {
		return _esfOrder.getCode();
	}

	/**
	* Sets the code of this e s f order.
	*
	* @param code the code of this e s f order
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfOrder.setCode(code);
	}

	/**
	* Returns the name of this e s f order.
	*
	* @return the name of this e s f order
	*/
	@Override
	public java.lang.String getName() {
		return _esfOrder.getName();
	}

	/**
	* Sets the name of this e s f order.
	*
	* @param name the name of this e s f order
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfOrder.setName(name);
	}

	/**
	* Returns the description of this e s f order.
	*
	* @return the description of this e s f order
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfOrder.getDescription();
	}

	/**
	* Sets the description of this e s f order.
	*
	* @param description the description of this e s f order
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfOrder.setDescription(description);
	}

	/**
	* Returns the date of this e s f order.
	*
	* @return the date of this e s f order
	*/
	@Override
	public java.util.Date getDate() {
		return _esfOrder.getDate();
	}

	/**
	* Sets the date of this e s f order.
	*
	* @param date the date of this e s f order
	*/
	@Override
	public void setDate(java.util.Date date) {
		_esfOrder.setDate(date);
	}

	/**
	* Returns the note of this e s f order.
	*
	* @return the note of this e s f order
	*/
	@Override
	public java.lang.String getNote() {
		return _esfOrder.getNote();
	}

	/**
	* Sets the note of this e s f order.
	*
	* @param note the note of this e s f order
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfOrder.setNote(note);
	}

	/**
	* Returns the protocol code of this e s f order.
	*
	* @return the protocol code of this e s f order
	*/
	@Override
	public java.lang.String getProtocolCode() {
		return _esfOrder.getProtocolCode();
	}

	/**
	* Sets the protocol code of this e s f order.
	*
	* @param protocolCode the protocol code of this e s f order
	*/
	@Override
	public void setProtocolCode(java.lang.String protocolCode) {
		_esfOrder.setProtocolCode(protocolCode);
	}

	/**
	* Returns the attachment of this e s f order.
	*
	* @return the attachment of this e s f order
	*/
	@Override
	public java.lang.String getAttachment() {
		return _esfOrder.getAttachment();
	}

	/**
	* Sets the attachment of this e s f order.
	*
	* @param attachment the attachment of this e s f order
	*/
	@Override
	public void setAttachment(java.lang.String attachment) {
		_esfOrder.setAttachment(attachment);
	}

	/**
	* Returns the state of this e s f order.
	*
	* @return the state of this e s f order
	*/
	@Override
	public int getState() {
		return _esfOrder.getState();
	}

	/**
	* Sets the state of this e s f order.
	*
	* @param state the state of this e s f order
	*/
	@Override
	public void setState(int state) {
		_esfOrder.setState(state);
	}

	/**
	* Returns the esf stockist ID of this e s f order.
	*
	* @return the esf stockist ID of this e s f order
	*/
	@Override
	public long getEsfStockistId() {
		return _esfOrder.getEsfStockistId();
	}

	/**
	* Sets the esf stockist ID of this e s f order.
	*
	* @param esfStockistId the esf stockist ID of this e s f order
	*/
	@Override
	public void setEsfStockistId(long esfStockistId) {
		_esfOrder.setEsfStockistId(esfStockistId);
	}

	@Override
	public boolean isNew() {
		return _esfOrder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrderWrapper((ESFOrder)_esfOrder.clone());
	}

	@Override
	public int compareTo(com.ethica.esf.model.ESFOrder esfOrder) {
		return _esfOrder.compareTo(esfOrder);
	}

	@Override
	public int hashCode() {
		return _esfOrder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFOrder> toCacheModel() {
		return _esfOrder.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFOrder toEscapedModel() {
		return new ESFOrderWrapper(_esfOrder.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFOrder toUnescapedModel() {
		return new ESFOrderWrapper(_esfOrder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrderWrapper)) {
			return false;
		}

		ESFOrderWrapper esfOrderWrapper = (ESFOrderWrapper)obj;

		if (Validator.equals(_esfOrder, esfOrderWrapper._esfOrder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrder getWrappedESFOrder() {
		return _esfOrder;
	}

	@Override
	public ESFOrder getWrappedModel() {
		return _esfOrder;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrder.resetOriginalValues();
	}

	private ESFOrder _esfOrder;
}