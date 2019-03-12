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
 * This class is a wrapper for {@link ESFArticle}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle
 * @generated
 */
public class ESFArticleWrapper implements ESFArticle, ModelWrapper<ESFArticle> {
	public ESFArticleWrapper(ESFArticle esfArticle) {
		_esfArticle = esfArticle;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("esfArticleTypeId", getEsfArticleTypeId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());
		attributes.put("price", getPrice());
		attributes.put("tax", getTax());
		attributes.put("sale", getSale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
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

		Long esfArticleTypeId = (Long)attributes.get("esfArticleTypeId");

		if (esfArticleTypeId != null) {
			setEsfArticleTypeId(esfArticleTypeId);
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

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double tax = (Double)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		Double sale = (Double)attributes.get("sale");

		if (sale != null) {
			setSale(sale);
		}
	}

	/**
	* Returns the primary key of this e s f article.
	*
	* @return the primary key of this e s f article
	*/
	@Override
	public long getPrimaryKey() {
		return _esfArticle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f article.
	*
	* @param primaryKey the primary key of this e s f article
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfArticle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf article ID of this e s f article.
	*
	* @return the esf article ID of this e s f article
	*/
	@Override
	public long getEsfArticleId() {
		return _esfArticle.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f article.
	*
	* @param esfArticleId the esf article ID of this e s f article
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticle.setEsfArticleId(esfArticleId);
	}

	/**
	* Returns the code of this e s f article.
	*
	* @return the code of this e s f article
	*/
	@Override
	public java.lang.String getCode() {
		return _esfArticle.getCode();
	}

	/**
	* Sets the code of this e s f article.
	*
	* @param code the code of this e s f article
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfArticle.setCode(code);
	}

	/**
	* Returns the name of this e s f article.
	*
	* @return the name of this e s f article
	*/
	@Override
	public java.lang.String getName() {
		return _esfArticle.getName();
	}

	/**
	* Sets the name of this e s f article.
	*
	* @param name the name of this e s f article
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfArticle.setName(name);
	}

	/**
	* Returns the description of this e s f article.
	*
	* @return the description of this e s f article
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfArticle.getDescription();
	}

	/**
	* Sets the description of this e s f article.
	*
	* @param description the description of this e s f article
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfArticle.setDescription(description);
	}

	/**
	* Returns the esf article type ID of this e s f article.
	*
	* @return the esf article type ID of this e s f article
	*/
	@Override
	public long getEsfArticleTypeId() {
		return _esfArticle.getEsfArticleTypeId();
	}

	/**
	* Sets the esf article type ID of this e s f article.
	*
	* @param esfArticleTypeId the esf article type ID of this e s f article
	*/
	@Override
	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticle.setEsfArticleTypeId(esfArticleTypeId);
	}

	/**
	* Returns the xxxl qty of this e s f article.
	*
	* @return the xxxl qty of this e s f article
	*/
	@Override
	public long getXxxlQty() {
		return _esfArticle.getXxxlQty();
	}

	/**
	* Sets the xxxl qty of this e s f article.
	*
	* @param xxxlQty the xxxl qty of this e s f article
	*/
	@Override
	public void setXxxlQty(long xxxlQty) {
		_esfArticle.setXxxlQty(xxxlQty);
	}

	/**
	* Returns the xxl qty of this e s f article.
	*
	* @return the xxl qty of this e s f article
	*/
	@Override
	public long getXxlQty() {
		return _esfArticle.getXxlQty();
	}

	/**
	* Sets the xxl qty of this e s f article.
	*
	* @param xxlQty the xxl qty of this e s f article
	*/
	@Override
	public void setXxlQty(long xxlQty) {
		_esfArticle.setXxlQty(xxlQty);
	}

	/**
	* Returns the xl qty of this e s f article.
	*
	* @return the xl qty of this e s f article
	*/
	@Override
	public long getXlQty() {
		return _esfArticle.getXlQty();
	}

	/**
	* Sets the xl qty of this e s f article.
	*
	* @param xlQty the xl qty of this e s f article
	*/
	@Override
	public void setXlQty(long xlQty) {
		_esfArticle.setXlQty(xlQty);
	}

	/**
	* Returns the l qty of this e s f article.
	*
	* @return the l qty of this e s f article
	*/
	@Override
	public long getLQty() {
		return _esfArticle.getLQty();
	}

	/**
	* Sets the l qty of this e s f article.
	*
	* @param lQty the l qty of this e s f article
	*/
	@Override
	public void setLQty(long lQty) {
		_esfArticle.setLQty(lQty);
	}

	/**
	* Returns the m qty of this e s f article.
	*
	* @return the m qty of this e s f article
	*/
	@Override
	public long getMQty() {
		return _esfArticle.getMQty();
	}

	/**
	* Sets the m qty of this e s f article.
	*
	* @param mQty the m qty of this e s f article
	*/
	@Override
	public void setMQty(long mQty) {
		_esfArticle.setMQty(mQty);
	}

	/**
	* Returns the s qty of this e s f article.
	*
	* @return the s qty of this e s f article
	*/
	@Override
	public long getSQty() {
		return _esfArticle.getSQty();
	}

	/**
	* Sets the s qty of this e s f article.
	*
	* @param sQty the s qty of this e s f article
	*/
	@Override
	public void setSQty(long sQty) {
		_esfArticle.setSQty(sQty);
	}

	/**
	* Returns the xs qty of this e s f article.
	*
	* @return the xs qty of this e s f article
	*/
	@Override
	public long getXsQty() {
		return _esfArticle.getXsQty();
	}

	/**
	* Sets the xs qty of this e s f article.
	*
	* @param xsQty the xs qty of this e s f article
	*/
	@Override
	public void setXsQty(long xsQty) {
		_esfArticle.setXsQty(xsQty);
	}

	/**
	* Returns the xxs qty of this e s f article.
	*
	* @return the xxs qty of this e s f article
	*/
	@Override
	public long getXxsQty() {
		return _esfArticle.getXxsQty();
	}

	/**
	* Sets the xxs qty of this e s f article.
	*
	* @param xxsQty the xxs qty of this e s f article
	*/
	@Override
	public void setXxsQty(long xxsQty) {
		_esfArticle.setXxsQty(xxsQty);
	}

	/**
	* Returns the other qty of this e s f article.
	*
	* @return the other qty of this e s f article
	*/
	@Override
	public long getOtherQty() {
		return _esfArticle.getOtherQty();
	}

	/**
	* Sets the other qty of this e s f article.
	*
	* @param otherQty the other qty of this e s f article
	*/
	@Override
	public void setOtherQty(long otherQty) {
		_esfArticle.setOtherQty(otherQty);
	}

	/**
	* Returns the price of this e s f article.
	*
	* @return the price of this e s f article
	*/
	@Override
	public double getPrice() {
		return _esfArticle.getPrice();
	}

	/**
	* Sets the price of this e s f article.
	*
	* @param price the price of this e s f article
	*/
	@Override
	public void setPrice(double price) {
		_esfArticle.setPrice(price);
	}

	/**
	* Returns the tax of this e s f article.
	*
	* @return the tax of this e s f article
	*/
	@Override
	public double getTax() {
		return _esfArticle.getTax();
	}

	/**
	* Sets the tax of this e s f article.
	*
	* @param tax the tax of this e s f article
	*/
	@Override
	public void setTax(double tax) {
		_esfArticle.setTax(tax);
	}

	/**
	* Returns the sale of this e s f article.
	*
	* @return the sale of this e s f article
	*/
	@Override
	public double getSale() {
		return _esfArticle.getSale();
	}

	/**
	* Sets the sale of this e s f article.
	*
	* @param sale the sale of this e s f article
	*/
	@Override
	public void setSale(double sale) {
		_esfArticle.setSale(sale);
	}

	@Override
	public boolean isNew() {
		return _esfArticle.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfArticle.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfArticle.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfArticle.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfArticle.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfArticle.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfArticle.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfArticle.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfArticle.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfArticle.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfArticle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFArticleWrapper((ESFArticle)_esfArticle.clone());
	}

	@Override
	public int compareTo(com.ethica.esf.model.ESFArticle esfArticle) {
		return _esfArticle.compareTo(esfArticle);
	}

	@Override
	public int hashCode() {
		return _esfArticle.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFArticle> toCacheModel() {
		return _esfArticle.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFArticle toEscapedModel() {
		return new ESFArticleWrapper(_esfArticle.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFArticle toUnescapedModel() {
		return new ESFArticleWrapper(_esfArticle.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfArticle.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfArticle.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfArticle.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticleWrapper)) {
			return false;
		}

		ESFArticleWrapper esfArticleWrapper = (ESFArticleWrapper)obj;

		if (Validator.equals(_esfArticle, esfArticleWrapper._esfArticle)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFArticle getWrappedESFArticle() {
		return _esfArticle;
	}

	@Override
	public ESFArticle getWrappedModel() {
		return _esfArticle;
	}

	@Override
	public void resetOriginalValues() {
		_esfArticle.resetOriginalValues();
	}

	private ESFArticle _esfArticle;
}