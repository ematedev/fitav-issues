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
 * This class is a wrapper for {@link ESFArticle_ESFUser}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFUser
 * @generated
 */
public class ESFArticle_ESFUserWrapper implements ESFArticle_ESFUser,
	ModelWrapper<ESFArticle_ESFUser> {
	public ESFArticle_ESFUserWrapper(ESFArticle_ESFUser esfArticle_ESFUser) {
		_esfArticle_ESFUser = esfArticle_ESFUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle_ESFUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle_ESFUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfUserId", getEsfUserId());
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
		attributes.put("description", getDescription());
		attributes.put("deliveryDate", getDeliveryDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date deliveryDate = (Date)attributes.get("deliveryDate");

		if (deliveryDate != null) {
			setDeliveryDate(deliveryDate);
		}
	}

	/**
	* Returns the primary key of this e s f article_ e s f user.
	*
	* @return the primary key of this e s f article_ e s f user
	*/
	@Override
	public com.ethica.esf.service.persistence.ESFArticle_ESFUserPK getPrimaryKey() {
		return _esfArticle_ESFUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f article_ e s f user.
	*
	* @param primaryKey the primary key of this e s f article_ e s f user
	*/
	@Override
	public void setPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK primaryKey) {
		_esfArticle_ESFUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf article ID of this e s f article_ e s f user.
	*
	* @return the esf article ID of this e s f article_ e s f user
	*/
	@Override
	public long getEsfArticleId() {
		return _esfArticle_ESFUser.getEsfArticleId();
	}

	/**
	* Sets the esf article ID of this e s f article_ e s f user.
	*
	* @param esfArticleId the esf article ID of this e s f article_ e s f user
	*/
	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticle_ESFUser.setEsfArticleId(esfArticleId);
	}

	/**
	* Returns the esf user ID of this e s f article_ e s f user.
	*
	* @return the esf user ID of this e s f article_ e s f user
	*/
	@Override
	public long getEsfUserId() {
		return _esfArticle_ESFUser.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f article_ e s f user.
	*
	* @param esfUserId the esf user ID of this e s f article_ e s f user
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfArticle_ESFUser.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f article_ e s f user.
	*
	* @return the esf user uuid of this e s f article_ e s f user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticle_ESFUser.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f article_ e s f user.
	*
	* @param esfUserUuid the esf user uuid of this e s f article_ e s f user
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfArticle_ESFUser.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the xxxl qty of this e s f article_ e s f user.
	*
	* @return the xxxl qty of this e s f article_ e s f user
	*/
	@Override
	public long getXxxlQty() {
		return _esfArticle_ESFUser.getXxxlQty();
	}

	/**
	* Sets the xxxl qty of this e s f article_ e s f user.
	*
	* @param xxxlQty the xxxl qty of this e s f article_ e s f user
	*/
	@Override
	public void setXxxlQty(long xxxlQty) {
		_esfArticle_ESFUser.setXxxlQty(xxxlQty);
	}

	/**
	* Returns the xxl qty of this e s f article_ e s f user.
	*
	* @return the xxl qty of this e s f article_ e s f user
	*/
	@Override
	public long getXxlQty() {
		return _esfArticle_ESFUser.getXxlQty();
	}

	/**
	* Sets the xxl qty of this e s f article_ e s f user.
	*
	* @param xxlQty the xxl qty of this e s f article_ e s f user
	*/
	@Override
	public void setXxlQty(long xxlQty) {
		_esfArticle_ESFUser.setXxlQty(xxlQty);
	}

	/**
	* Returns the xl qty of this e s f article_ e s f user.
	*
	* @return the xl qty of this e s f article_ e s f user
	*/
	@Override
	public long getXlQty() {
		return _esfArticle_ESFUser.getXlQty();
	}

	/**
	* Sets the xl qty of this e s f article_ e s f user.
	*
	* @param xlQty the xl qty of this e s f article_ e s f user
	*/
	@Override
	public void setXlQty(long xlQty) {
		_esfArticle_ESFUser.setXlQty(xlQty);
	}

	/**
	* Returns the l qty of this e s f article_ e s f user.
	*
	* @return the l qty of this e s f article_ e s f user
	*/
	@Override
	public long getLQty() {
		return _esfArticle_ESFUser.getLQty();
	}

	/**
	* Sets the l qty of this e s f article_ e s f user.
	*
	* @param lQty the l qty of this e s f article_ e s f user
	*/
	@Override
	public void setLQty(long lQty) {
		_esfArticle_ESFUser.setLQty(lQty);
	}

	/**
	* Returns the m qty of this e s f article_ e s f user.
	*
	* @return the m qty of this e s f article_ e s f user
	*/
	@Override
	public long getMQty() {
		return _esfArticle_ESFUser.getMQty();
	}

	/**
	* Sets the m qty of this e s f article_ e s f user.
	*
	* @param mQty the m qty of this e s f article_ e s f user
	*/
	@Override
	public void setMQty(long mQty) {
		_esfArticle_ESFUser.setMQty(mQty);
	}

	/**
	* Returns the s qty of this e s f article_ e s f user.
	*
	* @return the s qty of this e s f article_ e s f user
	*/
	@Override
	public long getSQty() {
		return _esfArticle_ESFUser.getSQty();
	}

	/**
	* Sets the s qty of this e s f article_ e s f user.
	*
	* @param sQty the s qty of this e s f article_ e s f user
	*/
	@Override
	public void setSQty(long sQty) {
		_esfArticle_ESFUser.setSQty(sQty);
	}

	/**
	* Returns the xs qty of this e s f article_ e s f user.
	*
	* @return the xs qty of this e s f article_ e s f user
	*/
	@Override
	public long getXsQty() {
		return _esfArticle_ESFUser.getXsQty();
	}

	/**
	* Sets the xs qty of this e s f article_ e s f user.
	*
	* @param xsQty the xs qty of this e s f article_ e s f user
	*/
	@Override
	public void setXsQty(long xsQty) {
		_esfArticle_ESFUser.setXsQty(xsQty);
	}

	/**
	* Returns the xxs qty of this e s f article_ e s f user.
	*
	* @return the xxs qty of this e s f article_ e s f user
	*/
	@Override
	public long getXxsQty() {
		return _esfArticle_ESFUser.getXxsQty();
	}

	/**
	* Sets the xxs qty of this e s f article_ e s f user.
	*
	* @param xxsQty the xxs qty of this e s f article_ e s f user
	*/
	@Override
	public void setXxsQty(long xxsQty) {
		_esfArticle_ESFUser.setXxsQty(xxsQty);
	}

	/**
	* Returns the other qty of this e s f article_ e s f user.
	*
	* @return the other qty of this e s f article_ e s f user
	*/
	@Override
	public long getOtherQty() {
		return _esfArticle_ESFUser.getOtherQty();
	}

	/**
	* Sets the other qty of this e s f article_ e s f user.
	*
	* @param otherQty the other qty of this e s f article_ e s f user
	*/
	@Override
	public void setOtherQty(long otherQty) {
		_esfArticle_ESFUser.setOtherQty(otherQty);
	}

	/**
	* Returns the total qty of this e s f article_ e s f user.
	*
	* @return the total qty of this e s f article_ e s f user
	*/
	@Override
	public long getTotalQty() {
		return _esfArticle_ESFUser.getTotalQty();
	}

	/**
	* Sets the total qty of this e s f article_ e s f user.
	*
	* @param totalQty the total qty of this e s f article_ e s f user
	*/
	@Override
	public void setTotalQty(long totalQty) {
		_esfArticle_ESFUser.setTotalQty(totalQty);
	}

	/**
	* Returns the description of this e s f article_ e s f user.
	*
	* @return the description of this e s f article_ e s f user
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfArticle_ESFUser.getDescription();
	}

	/**
	* Sets the description of this e s f article_ e s f user.
	*
	* @param description the description of this e s f article_ e s f user
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfArticle_ESFUser.setDescription(description);
	}

	/**
	* Returns the delivery date of this e s f article_ e s f user.
	*
	* @return the delivery date of this e s f article_ e s f user
	*/
	@Override
	public java.util.Date getDeliveryDate() {
		return _esfArticle_ESFUser.getDeliveryDate();
	}

	/**
	* Sets the delivery date of this e s f article_ e s f user.
	*
	* @param deliveryDate the delivery date of this e s f article_ e s f user
	*/
	@Override
	public void setDeliveryDate(java.util.Date deliveryDate) {
		_esfArticle_ESFUser.setDeliveryDate(deliveryDate);
	}

	@Override
	public boolean isNew() {
		return _esfArticle_ESFUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfArticle_ESFUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfArticle_ESFUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfArticle_ESFUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfArticle_ESFUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfArticle_ESFUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfArticle_ESFUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfArticle_ESFUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfArticle_ESFUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfArticle_ESFUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfArticle_ESFUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFArticle_ESFUserWrapper((ESFArticle_ESFUser)_esfArticle_ESFUser.clone());
	}

	@Override
	public int compareTo(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser) {
		return _esfArticle_ESFUser.compareTo(esfArticle_ESFUser);
	}

	@Override
	public int hashCode() {
		return _esfArticle_ESFUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFArticle_ESFUser> toCacheModel() {
		return _esfArticle_ESFUser.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser toEscapedModel() {
		return new ESFArticle_ESFUserWrapper(_esfArticle_ESFUser.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFArticle_ESFUser toUnescapedModel() {
		return new ESFArticle_ESFUserWrapper(_esfArticle_ESFUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfArticle_ESFUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfArticle_ESFUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfArticle_ESFUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticle_ESFUserWrapper)) {
			return false;
		}

		ESFArticle_ESFUserWrapper esfArticle_ESFUserWrapper = (ESFArticle_ESFUserWrapper)obj;

		if (Validator.equals(_esfArticle_ESFUser,
					esfArticle_ESFUserWrapper._esfArticle_ESFUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFArticle_ESFUser getWrappedESFArticle_ESFUser() {
		return _esfArticle_ESFUser;
	}

	@Override
	public ESFArticle_ESFUser getWrappedModel() {
		return _esfArticle_ESFUser;
	}

	@Override
	public void resetOriginalValues() {
		_esfArticle_ESFUser.resetOriginalValues();
	}

	private ESFArticle_ESFUser _esfArticle_ESFUser;
}