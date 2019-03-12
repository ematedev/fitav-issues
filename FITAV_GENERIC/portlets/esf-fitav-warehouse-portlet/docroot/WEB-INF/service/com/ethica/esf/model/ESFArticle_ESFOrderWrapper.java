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
 * This class is a wrapper for {@link ESFArticle_ESFOrder}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFOrder
 * @generated
 */
public class ESFArticle_ESFOrderWrapper implements ESFArticle_ESFOrder,
	ModelWrapper<ESFArticle_ESFOrder> {
	public ESFArticle_ESFOrderWrapper(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		_esfArticle_ESFOrder = esfArticle_ESFOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle_ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle_ESFOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());
		attributes.put("totalQty", getTotalQty());
		attributes.put("price", getPrice());
		attributes.put("vat", getVat());
		attributes.put("sale", getSale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		Long xxxlQty = (Long)attributes.get("xxxlQty");

		if (xxxlQty != null) {
			setXxxlQty(xxxlQty);
		}

		Long xxlQty = (Long)attributes.get("xxlQty");

		if (xxlQty != null) {
			setXxlQty(xxlQty);
		}

		Long xlQty = (Long)attributes.get("xlQty");

		if (xlQty != null) {
			setXlQty(xlQty);
		}

		Long lQty = (Long)attributes.get("lQty");

		if (lQty != null) {
			setLQty(lQty);
		}

		Long mQty = (Long)attributes.get("mQty");

		if (mQty != null) {
			setMQty(mQty);
		}

		Long sQty = (Long)attributes.get("sQty");

		if (sQty != null) {
			setSQty(sQty);
		}

		Long xsQty = (Long)attributes.get("xsQty");

		if (xsQty != null) {
			setXsQty(xsQty);
		}

		Long xxsQty = (Long)attributes.get("xxsQty");

		if (xxsQty != null) {
			setXxsQty(xxsQty);
		}

		Long otherQty = (Long)attributes.get("otherQty");

		if (otherQty != null) {
			setOtherQty(otherQty);
		}

		Long totalQty = (Long)attributes.get("totalQty");

		if (totalQty != null) {
			setTotalQty(totalQty);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double vat = (Double)attributes.get("vat");

		if (vat != null) {
			setVat(vat);
		}

		Double sale = (Double)attributes.get("sale");

		if (sale != null) {
			setSale(sale);
		}
	}

	/**
	* Returns the primary key of this e s f article_ e s f order.
	*
	* @return the primary key of this e s f article_ e s f order
	*/
	@Override
	public com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK getPrimaryKey() {
		return _esfArticle_ESFOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f article_ e s f order.
	*
	* @param primaryKey the primary key of this e s f article_ e s f order
	*/
	@Override
	public void setPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK primaryKey) {
		_esfArticle_ESFOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf article ID of this e s f article_ e s f order.
	*
	* @return the esf article ID of this e s f article_ e s f order
	*/
	@Override
	public long getEsfArticleId() {
		return _esfArticle_ESFOrder.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f article_ e s f order.
	*
	* @param esfArticleId the esf article ID of this e s f article_ e s f order
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticle_ESFOrder.setEsfArticleId(esfArticleId);
	}

	/**
	* Returns the esf order ID of this e s f article_ e s f order.
	*
	* @return the esf order ID of this e s f article_ e s f order
	*/
	@Override
	public long getEsfOrderId() {
		return _esfArticle_ESFOrder.getEsfOrderId();
	}

	/**
	* Sets the esf order ID of this e s f article_ e s f order.
	*
	* @param esfOrderId the esf order ID of this e s f article_ e s f order
	*/
	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfArticle_ESFOrder.setEsfOrderId(esfOrderId);
	}

	/**
	* Returns the xxxl qty of this e s f article_ e s f order.
	*
	* @return the xxxl qty of this e s f article_ e s f order
	*/
	@Override
	public long getXxxlQty() {
		return _esfArticle_ESFOrder.getXxxlQty();
	}

	/**
	* Sets the xxxl qty of this e s f article_ e s f order.
	*
	* @param xxxlQty the xxxl qty of this e s f article_ e s f order
	*/
	@Override
	public void setXxxlQty(long xxxlQty) {
		_esfArticle_ESFOrder.setXxxlQty(xxxlQty);
	}

	/**
	* Returns the xxl qty of this e s f article_ e s f order.
	*
	* @return the xxl qty of this e s f article_ e s f order
	*/
	@Override
	public long getXxlQty() {
		return _esfArticle_ESFOrder.getXxlQty();
	}

	/**
	* Sets the xxl qty of this e s f article_ e s f order.
	*
	* @param xxlQty the xxl qty of this e s f article_ e s f order
	*/
	@Override
	public void setXxlQty(long xxlQty) {
		_esfArticle_ESFOrder.setXxlQty(xxlQty);
	}

	/**
	* Returns the xl qty of this e s f article_ e s f order.
	*
	* @return the xl qty of this e s f article_ e s f order
	*/
	@Override
	public long getXlQty() {
		return _esfArticle_ESFOrder.getXlQty();
	}

	/**
	* Sets the xl qty of this e s f article_ e s f order.
	*
	* @param xlQty the xl qty of this e s f article_ e s f order
	*/
	@Override
	public void setXlQty(long xlQty) {
		_esfArticle_ESFOrder.setXlQty(xlQty);
	}

	/**
	* Returns the l qty of this e s f article_ e s f order.
	*
	* @return the l qty of this e s f article_ e s f order
	*/
	@Override
	public long getLQty() {
		return _esfArticle_ESFOrder.getLQty();
	}

	/**
	* Sets the l qty of this e s f article_ e s f order.
	*
	* @param lQty the l qty of this e s f article_ e s f order
	*/
	@Override
	public void setLQty(long lQty) {
		_esfArticle_ESFOrder.setLQty(lQty);
	}

	/**
	* Returns the m qty of this e s f article_ e s f order.
	*
	* @return the m qty of this e s f article_ e s f order
	*/
	@Override
	public long getMQty() {
		return _esfArticle_ESFOrder.getMQty();
	}

	/**
	* Sets the m qty of this e s f article_ e s f order.
	*
	* @param mQty the m qty of this e s f article_ e s f order
	*/
	@Override
	public void setMQty(long mQty) {
		_esfArticle_ESFOrder.setMQty(mQty);
	}

	/**
	* Returns the s qty of this e s f article_ e s f order.
	*
	* @return the s qty of this e s f article_ e s f order
	*/
	@Override
	public long getSQty() {
		return _esfArticle_ESFOrder.getSQty();
	}

	/**
	* Sets the s qty of this e s f article_ e s f order.
	*
	* @param sQty the s qty of this e s f article_ e s f order
	*/
	@Override
	public void setSQty(long sQty) {
		_esfArticle_ESFOrder.setSQty(sQty);
	}

	/**
	* Returns the xs qty of this e s f article_ e s f order.
	*
	* @return the xs qty of this e s f article_ e s f order
	*/
	@Override
	public long getXsQty() {
		return _esfArticle_ESFOrder.getXsQty();
	}

	/**
	* Sets the xs qty of this e s f article_ e s f order.
	*
	* @param xsQty the xs qty of this e s f article_ e s f order
	*/
	@Override
	public void setXsQty(long xsQty) {
		_esfArticle_ESFOrder.setXsQty(xsQty);
	}

	/**
	* Returns the xxs qty of this e s f article_ e s f order.
	*
	* @return the xxs qty of this e s f article_ e s f order
	*/
	@Override
	public long getXxsQty() {
		return _esfArticle_ESFOrder.getXxsQty();
	}

	/**
	* Sets the xxs qty of this e s f article_ e s f order.
	*
	* @param xxsQty the xxs qty of this e s f article_ e s f order
	*/
	@Override
	public void setXxsQty(long xxsQty) {
		_esfArticle_ESFOrder.setXxsQty(xxsQty);
	}

	/**
	* Returns the other qty of this e s f article_ e s f order.
	*
	* @return the other qty of this e s f article_ e s f order
	*/
	@Override
	public long getOtherQty() {
		return _esfArticle_ESFOrder.getOtherQty();
	}

	/**
	* Sets the other qty of this e s f article_ e s f order.
	*
	* @param otherQty the other qty of this e s f article_ e s f order
	*/
	@Override
	public void setOtherQty(long otherQty) {
		_esfArticle_ESFOrder.setOtherQty(otherQty);
	}

	/**
	* Returns the total qty of this e s f article_ e s f order.
	*
	* @return the total qty of this e s f article_ e s f order
	*/
	@Override
	public long getTotalQty() {
		return _esfArticle_ESFOrder.getTotalQty();
	}

	/**
	* Sets the total qty of this e s f article_ e s f order.
	*
	* @param totalQty the total qty of this e s f article_ e s f order
	*/
	@Override
	public void setTotalQty(long totalQty) {
		_esfArticle_ESFOrder.setTotalQty(totalQty);
	}

	/**
	* Returns the price of this e s f article_ e s f order.
	*
	* @return the price of this e s f article_ e s f order
	*/
	@Override
	public double getPrice() {
		return _esfArticle_ESFOrder.getPrice();
	}

	/**
	* Sets the price of this e s f article_ e s f order.
	*
	* @param price the price of this e s f article_ e s f order
	*/
	@Override
	public void setPrice(double price) {
		_esfArticle_ESFOrder.setPrice(price);
	}

	/**
	* Returns the vat of this e s f article_ e s f order.
	*
	* @return the vat of this e s f article_ e s f order
	*/
	@Override
	public double getVat() {
		return _esfArticle_ESFOrder.getVat();
	}

	/**
	* Sets the vat of this e s f article_ e s f order.
	*
	* @param vat the vat of this e s f article_ e s f order
	*/
	@Override
	public void setVat(double vat) {
		_esfArticle_ESFOrder.setVat(vat);
	}

	/**
	* Returns the sale of this e s f article_ e s f order.
	*
	* @return the sale of this e s f article_ e s f order
	*/
	@Override
	public double getSale() {
		return _esfArticle_ESFOrder.getSale();
	}

	/**
	* Sets the sale of this e s f article_ e s f order.
	*
	* @param sale the sale of this e s f article_ e s f order
	*/
	@Override
	public void setSale(double sale) {
		_esfArticle_ESFOrder.setSale(sale);
	}

	@Override
	public boolean isNew() {
		return _esfArticle_ESFOrder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfArticle_ESFOrder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfArticle_ESFOrder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfArticle_ESFOrder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfArticle_ESFOrder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfArticle_ESFOrder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfArticle_ESFOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfArticle_ESFOrder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfArticle_ESFOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfArticle_ESFOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfArticle_ESFOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFArticle_ESFOrderWrapper((ESFArticle_ESFOrder)_esfArticle_ESFOrder.clone());
	}

	@Override
	public int compareTo(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder) {
		return _esfArticle_ESFOrder.compareTo(esfArticle_ESFOrder);
	}

	@Override
	public int hashCode() {
		return _esfArticle_ESFOrder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFArticle_ESFOrder> toCacheModel() {
		return _esfArticle_ESFOrder.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder toEscapedModel() {
		return new ESFArticle_ESFOrderWrapper(_esfArticle_ESFOrder.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFOrder toUnescapedModel() {
		return new ESFArticle_ESFOrderWrapper(_esfArticle_ESFOrder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfArticle_ESFOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfArticle_ESFOrder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfArticle_ESFOrder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticle_ESFOrderWrapper)) {
			return false;
		}

		ESFArticle_ESFOrderWrapper esfArticle_ESFOrderWrapper = (ESFArticle_ESFOrderWrapper)obj;

		if (Validator.equals(_esfArticle_ESFOrder,
					esfArticle_ESFOrderWrapper._esfArticle_ESFOrder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFArticle_ESFOrder getWrappedESFArticle_ESFOrder() {
		return _esfArticle_ESFOrder;
	}

	@Override
	public ESFArticle_ESFOrder getWrappedModel() {
		return _esfArticle_ESFOrder;
	}

	@Override
	public void resetOriginalValues() {
		_esfArticle_ESFOrder.resetOriginalValues();
	}

	private ESFArticle_ESFOrder _esfArticle_ESFOrder;
}