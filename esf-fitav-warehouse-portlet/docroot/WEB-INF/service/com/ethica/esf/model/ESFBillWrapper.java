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
 * This class is a wrapper for {@link ESFBill}.
 * </p>
 *
 * @author Ethica
 * @see ESFBill
 * @generated
 */
public class ESFBillWrapper implements ESFBill, ModelWrapper<ESFBill> {
	public ESFBillWrapper(ESFBill esfBill) {
		_esfBill = esfBill;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFBill.class;
	}

	@Override
	public String getModelClassName() {
		return ESFBill.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfBillId", getEsfBillId());
		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("billNumber", getBillNumber());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfBillId = (Long)attributes.get("esfBillId");

		if (esfBillId != null) {
			setEsfBillId(esfBillId);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		String billNumber = (String)attributes.get("billNumber");

		if (billNumber != null) {
			setBillNumber(billNumber);
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
	}

	/**
	* Returns the primary key of this e s f bill.
	*
	* @return the primary key of this e s f bill
	*/
	@Override
	public long getPrimaryKey() {
		return _esfBill.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f bill.
	*
	* @param primaryKey the primary key of this e s f bill
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfBill.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf bill ID of this e s f bill.
	*
	* @return the esf bill ID of this e s f bill
	*/
	@Override
	public long getEsfBillId() {
		return _esfBill.getEsfBillId();
	}

	/**
	* Sets the esf bill ID of this e s f bill.
	*
	* @param esfBillId the esf bill ID of this e s f bill
	*/
	@Override
	public void setEsfBillId(long esfBillId) {
		_esfBill.setEsfBillId(esfBillId);
	}

	/**
	* Returns the esf article ID of this e s f bill.
	*
	* @return the esf article ID of this e s f bill
	*/
	@Override
	public long getEsfArticleId() {
		return _esfBill.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f bill.
	*
	* @param esfArticleId the esf article ID of this e s f bill
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfBill.setEsfArticleId(esfArticleId);
	}

	/**
	* Returns the esf order ID of this e s f bill.
	*
	* @return the esf order ID of this e s f bill
	*/
	@Override
	public long getEsfOrderId() {
		return _esfBill.getEsfOrderId();
	}

	/**
	* Sets the esf order ID of this e s f bill.
	*
	* @param esfOrderId the esf order ID of this e s f bill
	*/
	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfBill.setEsfOrderId(esfOrderId);
	}

	/**
	* Returns the bill number of this e s f bill.
	*
	* @return the bill number of this e s f bill
	*/
	@Override
	public java.lang.String getBillNumber() {
		return _esfBill.getBillNumber();
	}

	/**
	* Sets the bill number of this e s f bill.
	*
	* @param billNumber the bill number of this e s f bill
	*/
	@Override
	public void setBillNumber(java.lang.String billNumber) {
		_esfBill.setBillNumber(billNumber);
	}

	/**
	* Returns the xxxl qty of this e s f bill.
	*
	* @return the xxxl qty of this e s f bill
	*/
	@Override
	public long getXxxlQty() {
		return _esfBill.getXxxlQty();
	}

	/**
	* Sets the xxxl qty of this e s f bill.
	*
	* @param xxxlQty the xxxl qty of this e s f bill
	*/
	@Override
	public void setXxxlQty(long xxxlQty) {
		_esfBill.setXxxlQty(xxxlQty);
	}

	/**
	* Returns the xxl qty of this e s f bill.
	*
	* @return the xxl qty of this e s f bill
	*/
	@Override
	public long getXxlQty() {
		return _esfBill.getXxlQty();
	}

	/**
	* Sets the xxl qty of this e s f bill.
	*
	* @param xxlQty the xxl qty of this e s f bill
	*/
	@Override
	public void setXxlQty(long xxlQty) {
		_esfBill.setXxlQty(xxlQty);
	}

	/**
	* Returns the xl qty of this e s f bill.
	*
	* @return the xl qty of this e s f bill
	*/
	@Override
	public long getXlQty() {
		return _esfBill.getXlQty();
	}

	/**
	* Sets the xl qty of this e s f bill.
	*
	* @param xlQty the xl qty of this e s f bill
	*/
	@Override
	public void setXlQty(long xlQty) {
		_esfBill.setXlQty(xlQty);
	}

	/**
	* Returns the l qty of this e s f bill.
	*
	* @return the l qty of this e s f bill
	*/
	@Override
	public long getLQty() {
		return _esfBill.getLQty();
	}

	/**
	* Sets the l qty of this e s f bill.
	*
	* @param lQty the l qty of this e s f bill
	*/
	@Override
	public void setLQty(long lQty) {
		_esfBill.setLQty(lQty);
	}

	/**
	* Returns the m qty of this e s f bill.
	*
	* @return the m qty of this e s f bill
	*/
	@Override
	public long getMQty() {
		return _esfBill.getMQty();
	}

	/**
	* Sets the m qty of this e s f bill.
	*
	* @param mQty the m qty of this e s f bill
	*/
	@Override
	public void setMQty(long mQty) {
		_esfBill.setMQty(mQty);
	}

	/**
	* Returns the s qty of this e s f bill.
	*
	* @return the s qty of this e s f bill
	*/
	@Override
	public long getSQty() {
		return _esfBill.getSQty();
	}

	/**
	* Sets the s qty of this e s f bill.
	*
	* @param sQty the s qty of this e s f bill
	*/
	@Override
	public void setSQty(long sQty) {
		_esfBill.setSQty(sQty);
	}

	/**
	* Returns the xs qty of this e s f bill.
	*
	* @return the xs qty of this e s f bill
	*/
	@Override
	public long getXsQty() {
		return _esfBill.getXsQty();
	}

	/**
	* Sets the xs qty of this e s f bill.
	*
	* @param xsQty the xs qty of this e s f bill
	*/
	@Override
	public void setXsQty(long xsQty) {
		_esfBill.setXsQty(xsQty);
	}

	/**
	* Returns the xxs qty of this e s f bill.
	*
	* @return the xxs qty of this e s f bill
	*/
	@Override
	public long getXxsQty() {
		return _esfBill.getXxsQty();
	}

	/**
	* Sets the xxs qty of this e s f bill.
	*
	* @param xxsQty the xxs qty of this e s f bill
	*/
	@Override
	public void setXxsQty(long xxsQty) {
		_esfBill.setXxsQty(xxsQty);
	}

	/**
	* Returns the other qty of this e s f bill.
	*
	* @return the other qty of this e s f bill
	*/
	@Override
	public long getOtherQty() {
		return _esfBill.getOtherQty();
	}

	/**
	* Sets the other qty of this e s f bill.
	*
	* @param otherQty the other qty of this e s f bill
	*/
	@Override
	public void setOtherQty(long otherQty) {
		_esfBill.setOtherQty(otherQty);
	}

	/**
	* Returns the total qty of this e s f bill.
	*
	* @return the total qty of this e s f bill
	*/
	@Override
	public long getTotalQty() {
		return _esfBill.getTotalQty();
	}

	/**
	* Sets the total qty of this e s f bill.
	*
	* @param totalQty the total qty of this e s f bill
	*/
	@Override
	public void setTotalQty(long totalQty) {
		_esfBill.setTotalQty(totalQty);
	}

	@Override
	public boolean isNew() {
		return _esfBill.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfBill.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfBill.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfBill.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfBill.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfBill.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfBill.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfBill.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfBill.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfBill.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfBill.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFBillWrapper((ESFBill)_esfBill.clone());
	}

	@Override
	public int compareTo(com.ethica.esf.model.ESFBill esfBill) {
		return _esfBill.compareTo(esfBill);
	}

	@Override
	public int hashCode() {
		return _esfBill.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFBill> toCacheModel() {
		return _esfBill.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFBill toEscapedModel() {
		return new ESFBillWrapper(_esfBill.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFBill toUnescapedModel() {
		return new ESFBillWrapper(_esfBill.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfBill.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfBill.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfBill.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFBillWrapper)) {
			return false;
		}

		ESFBillWrapper esfBillWrapper = (ESFBillWrapper)obj;

		if (Validator.equals(_esfBill, esfBillWrapper._esfBill)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFBill getWrappedESFBill() {
		return _esfBill;
	}

	@Override
	public ESFBill getWrappedModel() {
		return _esfBill;
	}

	@Override
	public void resetOriginalValues() {
		_esfBill.resetOriginalValues();
	}

	private ESFBill _esfBill;
}