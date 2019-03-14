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
		attributes.put("data", getData());
		attributes.put("description", getDescription());
		attributes.put("esfStockistId", getEsfStockistId());
		attributes.put("qty", getQty());
		attributes.put("esfArticleId", getEsfArticleId());

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

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}

		Long qty = (Long)attributes.get("qty");

		if (qty != null) {
			setQty(qty);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
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
	* Returns the data of this e s f order.
	*
	* @return the data of this e s f order
	*/
	@Override
	public java.util.Date getData() {
		return _esfOrder.getData();
	}

	/**
	* Sets the data of this e s f order.
	*
	* @param data the data of this e s f order
	*/
	@Override
	public void setData(java.util.Date data) {
		_esfOrder.setData(data);
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

	/**
	* Returns the qty of this e s f order.
	*
	* @return the qty of this e s f order
	*/
	@Override
	public long getQty() {
		return _esfOrder.getQty();
	}

	/**
	* Sets the qty of this e s f order.
	*
	* @param qty the qty of this e s f order
	*/
	@Override
	public void setQty(long qty) {
		_esfOrder.setQty(qty);
	}

	/**
	* Returns the esf article ID of this e s f order.
	*
	* @return the esf article ID of this e s f order
	*/
	@Override
	public long getEsfArticleId() {
		return _esfOrder.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f order.
	*
	* @param esfArticleId the esf article ID of this e s f order
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfOrder.setEsfArticleId(esfArticleId);
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