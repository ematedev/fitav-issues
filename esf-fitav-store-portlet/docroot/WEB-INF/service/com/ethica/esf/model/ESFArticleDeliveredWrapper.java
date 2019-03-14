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
 * This class is a wrapper for {@link ESFArticleDelivered}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticleDelivered
 * @generated
 */
public class ESFArticleDeliveredWrapper implements ESFArticleDelivered,
	ModelWrapper<ESFArticleDelivered> {
	public ESFArticleDeliveredWrapper(ESFArticleDelivered esfArticleDelivered) {
		_esfArticleDelivered = esfArticleDelivered;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticleDelivered.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticleDelivered.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleDeliveredId", getEsfArticleDeliveredId());
		attributes.put("data", getData());
		attributes.put("description", getDescription());
		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfShooterId", getEsfShooterId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleDeliveredId = (Long)attributes.get(
				"esfArticleDeliveredId");

		if (esfArticleDeliveredId != null) {
			setEsfArticleDeliveredId(esfArticleDeliveredId);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfShooterId = (Long)attributes.get("esfShooterId");

		if (esfShooterId != null) {
			setEsfShooterId(esfShooterId);
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
	}

	/**
	* Returns the primary key of this e s f article delivered.
	*
	* @return the primary key of this e s f article delivered
	*/
	@Override
	public long getPrimaryKey() {
		return _esfArticleDelivered.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f article delivered.
	*
	* @param primaryKey the primary key of this e s f article delivered
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfArticleDelivered.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf article delivered ID of this e s f article delivered.
	*
	* @return the esf article delivered ID of this e s f article delivered
	*/
	@Override
	public long getEsfArticleDeliveredId() {
		return _esfArticleDelivered.getEsfArticleDeliveredId();
	}

	/**
	* Sets the esf article delivered ID of this e s f article delivered.
	*
	* @param esfArticleDeliveredId the esf article delivered ID of this e s f article delivered
	*/
	@Override
	public void setEsfArticleDeliveredId(long esfArticleDeliveredId) {
		_esfArticleDelivered.setEsfArticleDeliveredId(esfArticleDeliveredId);
	}

	/**
	* Returns the data of this e s f article delivered.
	*
	* @return the data of this e s f article delivered
	*/
	@Override
	public java.util.Date getData() {
		return _esfArticleDelivered.getData();
	}

	/**
	* Sets the data of this e s f article delivered.
	*
	* @param data the data of this e s f article delivered
	*/
	@Override
	public void setData(java.util.Date data) {
		_esfArticleDelivered.setData(data);
	}

	/**
	* Returns the description of this e s f article delivered.
	*
	* @return the description of this e s f article delivered
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfArticleDelivered.getDescription();
	}

	/**
	* Sets the description of this e s f article delivered.
	*
	* @param description the description of this e s f article delivered
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfArticleDelivered.setDescription(description);
	}

	/**
	* Returns the esf article ID of this e s f article delivered.
	*
	* @return the esf article ID of this e s f article delivered
	*/
	@Override
	public long getEsfArticleId() {
		return _esfArticleDelivered.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f article delivered.
	*
	* @param esfArticleId the esf article ID of this e s f article delivered
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticleDelivered.setEsfArticleId(esfArticleId);
	}

	/**
	* Returns the esf shooter ID of this e s f article delivered.
	*
	* @return the esf shooter ID of this e s f article delivered
	*/
	@Override
	public long getEsfShooterId() {
		return _esfArticleDelivered.getEsfShooterId();
	}

	/**
	* Sets the esf shooter ID of this e s f article delivered.
	*
	* @param esfShooterId the esf shooter ID of this e s f article delivered
	*/
	@Override
	public void setEsfShooterId(long esfShooterId) {
		_esfArticleDelivered.setEsfShooterId(esfShooterId);
	}

	/**
	* Returns the xxxl qty of this e s f article delivered.
	*
	* @return the xxxl qty of this e s f article delivered
	*/
	@Override
	public long getXxxlQty() {
		return _esfArticleDelivered.getXxxlQty();
	}

	/**
	* Sets the xxxl qty of this e s f article delivered.
	*
	* @param xxxlQty the xxxl qty of this e s f article delivered
	*/
	@Override
	public void setXxxlQty(long xxxlQty) {
		_esfArticleDelivered.setXxxlQty(xxxlQty);
	}

	/**
	* Returns the xxl qty of this e s f article delivered.
	*
	* @return the xxl qty of this e s f article delivered
	*/
	@Override
	public long getXxlQty() {
		return _esfArticleDelivered.getXxlQty();
	}

	/**
	* Sets the xxl qty of this e s f article delivered.
	*
	* @param xxlQty the xxl qty of this e s f article delivered
	*/
	@Override
	public void setXxlQty(long xxlQty) {
		_esfArticleDelivered.setXxlQty(xxlQty);
	}

	/**
	* Returns the xl qty of this e s f article delivered.
	*
	* @return the xl qty of this e s f article delivered
	*/
	@Override
	public long getXlQty() {
		return _esfArticleDelivered.getXlQty();
	}

	/**
	* Sets the xl qty of this e s f article delivered.
	*
	* @param xlQty the xl qty of this e s f article delivered
	*/
	@Override
	public void setXlQty(long xlQty) {
		_esfArticleDelivered.setXlQty(xlQty);
	}

	/**
	* Returns the l qty of this e s f article delivered.
	*
	* @return the l qty of this e s f article delivered
	*/
	@Override
	public long getLQty() {
		return _esfArticleDelivered.getLQty();
	}

	/**
	* Sets the l qty of this e s f article delivered.
	*
	* @param lQty the l qty of this e s f article delivered
	*/
	@Override
	public void setLQty(long lQty) {
		_esfArticleDelivered.setLQty(lQty);
	}

	/**
	* Returns the m qty of this e s f article delivered.
	*
	* @return the m qty of this e s f article delivered
	*/
	@Override
	public long getMQty() {
		return _esfArticleDelivered.getMQty();
	}

	/**
	* Sets the m qty of this e s f article delivered.
	*
	* @param mQty the m qty of this e s f article delivered
	*/
	@Override
	public void setMQty(long mQty) {
		_esfArticleDelivered.setMQty(mQty);
	}

	/**
	* Returns the s qty of this e s f article delivered.
	*
	* @return the s qty of this e s f article delivered
	*/
	@Override
	public long getSQty() {
		return _esfArticleDelivered.getSQty();
	}

	/**
	* Sets the s qty of this e s f article delivered.
	*
	* @param sQty the s qty of this e s f article delivered
	*/
	@Override
	public void setSQty(long sQty) {
		_esfArticleDelivered.setSQty(sQty);
	}

	/**
	* Returns the xs qty of this e s f article delivered.
	*
	* @return the xs qty of this e s f article delivered
	*/
	@Override
	public long getXsQty() {
		return _esfArticleDelivered.getXsQty();
	}

	/**
	* Sets the xs qty of this e s f article delivered.
	*
	* @param xsQty the xs qty of this e s f article delivered
	*/
	@Override
	public void setXsQty(long xsQty) {
		_esfArticleDelivered.setXsQty(xsQty);
	}

	/**
	* Returns the xxs qty of this e s f article delivered.
	*
	* @return the xxs qty of this e s f article delivered
	*/
	@Override
	public long getXxsQty() {
		return _esfArticleDelivered.getXxsQty();
	}

	/**
	* Sets the xxs qty of this e s f article delivered.
	*
	* @param xxsQty the xxs qty of this e s f article delivered
	*/
	@Override
	public void setXxsQty(long xxsQty) {
		_esfArticleDelivered.setXxsQty(xxsQty);
	}

	/**
	* Returns the other qty of this e s f article delivered.
	*
	* @return the other qty of this e s f article delivered
	*/
	@Override
	public long getOtherQty() {
		return _esfArticleDelivered.getOtherQty();
	}

	/**
	* Sets the other qty of this e s f article delivered.
	*
	* @param otherQty the other qty of this e s f article delivered
	*/
	@Override
	public void setOtherQty(long otherQty) {
		_esfArticleDelivered.setOtherQty(otherQty);
	}

	@Override
	public boolean isNew() {
		return _esfArticleDelivered.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfArticleDelivered.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfArticleDelivered.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfArticleDelivered.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfArticleDelivered.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfArticleDelivered.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfArticleDelivered.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfArticleDelivered.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfArticleDelivered.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfArticleDelivered.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfArticleDelivered.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFArticleDeliveredWrapper((ESFArticleDelivered)_esfArticleDelivered.clone());
	}

	@Override
	public int compareTo(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered) {
		return _esfArticleDelivered.compareTo(esfArticleDelivered);
	}

	@Override
	public int hashCode() {
		return _esfArticleDelivered.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFArticleDelivered> toCacheModel() {
		return _esfArticleDelivered.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFArticleDelivered toEscapedModel() {
		return new ESFArticleDeliveredWrapper(_esfArticleDelivered.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFArticleDelivered toUnescapedModel() {
		return new ESFArticleDeliveredWrapper(_esfArticleDelivered.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfArticleDelivered.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfArticleDelivered.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfArticleDelivered.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticleDeliveredWrapper)) {
			return false;
		}

		ESFArticleDeliveredWrapper esfArticleDeliveredWrapper = (ESFArticleDeliveredWrapper)obj;

		if (Validator.equals(_esfArticleDelivered,
					esfArticleDeliveredWrapper._esfArticleDelivered)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFArticleDelivered getWrappedESFArticleDelivered() {
		return _esfArticleDelivered;
	}

	@Override
	public ESFArticleDelivered getWrappedModel() {
		return _esfArticleDelivered;
	}

	@Override
	public void resetOriginalValues() {
		_esfArticleDelivered.resetOriginalValues();
	}

	private ESFArticleDelivered _esfArticleDelivered;
}