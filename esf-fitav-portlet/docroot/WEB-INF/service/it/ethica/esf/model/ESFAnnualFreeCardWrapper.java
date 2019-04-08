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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFAnnualFreeCard}.
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualFreeCard
 * @generated
 */
public class ESFAnnualFreeCardWrapper implements ESFAnnualFreeCard,
	ModelWrapper<ESFAnnualFreeCard> {
	public ESFAnnualFreeCardWrapper(ESFAnnualFreeCard esfAnnualFreeCard) {
		_esfAnnualFreeCard = esfAnnualFreeCard;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAnnualFreeCard.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAnnualFreeCard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("annualFreeCardId", getAnnualFreeCardId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assId", getAssId());
		attributes.put("code", getCode());
		attributes.put("cardCode", getCardCode());
		attributes.put("assCode", getAssCode());
		attributes.put("assName", getAssName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long annualFreeCardId = (Long)attributes.get("annualFreeCardId");

		if (annualFreeCardId != null) {
			setAnnualFreeCardId(annualFreeCardId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assId = (Long)attributes.get("assId");

		if (assId != null) {
			setAssId(assId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		String assCode = (String)attributes.get("assCode");

		if (assCode != null) {
			setAssCode(assCode);
		}

		String assName = (String)attributes.get("assName");

		if (assName != null) {
			setAssName(assName);
		}
	}

	/**
	* Returns the primary key of this e s f annual free card.
	*
	* @return the primary key of this e s f annual free card
	*/
	@Override
	public long getPrimaryKey() {
		return _esfAnnualFreeCard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f annual free card.
	*
	* @param primaryKey the primary key of this e s f annual free card
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfAnnualFreeCard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the annual free card ID of this e s f annual free card.
	*
	* @return the annual free card ID of this e s f annual free card
	*/
	@Override
	public long getAnnualFreeCardId() {
		return _esfAnnualFreeCard.getAnnualFreeCardId();
	}

	/**
	* Sets the annual free card ID of this e s f annual free card.
	*
	* @param annualFreeCardId the annual free card ID of this e s f annual free card
	*/
	@Override
	public void setAnnualFreeCardId(long annualFreeCardId) {
		_esfAnnualFreeCard.setAnnualFreeCardId(annualFreeCardId);
	}

	/**
	* Returns the company ID of this e s f annual free card.
	*
	* @return the company ID of this e s f annual free card
	*/
	@Override
	public long getCompanyId() {
		return _esfAnnualFreeCard.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f annual free card.
	*
	* @param companyId the company ID of this e s f annual free card
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfAnnualFreeCard.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f annual free card.
	*
	* @return the user ID of this e s f annual free card
	*/
	@Override
	public long getUserId() {
		return _esfAnnualFreeCard.getUserId();
	}

	/**
	* Sets the user ID of this e s f annual free card.
	*
	* @param userId the user ID of this e s f annual free card
	*/
	@Override
	public void setUserId(long userId) {
		_esfAnnualFreeCard.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f annual free card.
	*
	* @return the user uuid of this e s f annual free card
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCard.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f annual free card.
	*
	* @param userUuid the user uuid of this e s f annual free card
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfAnnualFreeCard.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f annual free card.
	*
	* @return the user name of this e s f annual free card
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfAnnualFreeCard.getUserName();
	}

	/**
	* Sets the user name of this e s f annual free card.
	*
	* @param userName the user name of this e s f annual free card
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfAnnualFreeCard.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f annual free card.
	*
	* @return the create date of this e s f annual free card
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfAnnualFreeCard.getCreateDate();
	}

	/**
	* Sets the create date of this e s f annual free card.
	*
	* @param createDate the create date of this e s f annual free card
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfAnnualFreeCard.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f annual free card.
	*
	* @return the modified date of this e s f annual free card
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfAnnualFreeCard.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f annual free card.
	*
	* @param modifiedDate the modified date of this e s f annual free card
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfAnnualFreeCard.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the ass ID of this e s f annual free card.
	*
	* @return the ass ID of this e s f annual free card
	*/
	@Override
	public long getAssId() {
		return _esfAnnualFreeCard.getAssId();
	}

	/**
	* Sets the ass ID of this e s f annual free card.
	*
	* @param assId the ass ID of this e s f annual free card
	*/
	@Override
	public void setAssId(long assId) {
		_esfAnnualFreeCard.setAssId(assId);
	}

	/**
	* Returns the code of this e s f annual free card.
	*
	* @return the code of this e s f annual free card
	*/
	@Override
	public java.lang.String getCode() {
		return _esfAnnualFreeCard.getCode();
	}

	/**
	* Sets the code of this e s f annual free card.
	*
	* @param code the code of this e s f annual free card
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfAnnualFreeCard.setCode(code);
	}

	/**
	* Returns the card code of this e s f annual free card.
	*
	* @return the card code of this e s f annual free card
	*/
	@Override
	public java.lang.String getCardCode() {
		return _esfAnnualFreeCard.getCardCode();
	}

	/**
	* Sets the card code of this e s f annual free card.
	*
	* @param cardCode the card code of this e s f annual free card
	*/
	@Override
	public void setCardCode(java.lang.String cardCode) {
		_esfAnnualFreeCard.setCardCode(cardCode);
	}

	/**
	* Returns the ass code of this e s f annual free card.
	*
	* @return the ass code of this e s f annual free card
	*/
	@Override
	public java.lang.String getAssCode() {
		return _esfAnnualFreeCard.getAssCode();
	}

	/**
	* Sets the ass code of this e s f annual free card.
	*
	* @param assCode the ass code of this e s f annual free card
	*/
	@Override
	public void setAssCode(java.lang.String assCode) {
		_esfAnnualFreeCard.setAssCode(assCode);
	}

	/**
	* Returns the ass name of this e s f annual free card.
	*
	* @return the ass name of this e s f annual free card
	*/
	@Override
	public java.lang.String getAssName() {
		return _esfAnnualFreeCard.getAssName();
	}

	/**
	* Sets the ass name of this e s f annual free card.
	*
	* @param assName the ass name of this e s f annual free card
	*/
	@Override
	public void setAssName(java.lang.String assName) {
		_esfAnnualFreeCard.setAssName(assName);
	}

	@Override
	public boolean isNew() {
		return _esfAnnualFreeCard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfAnnualFreeCard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfAnnualFreeCard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfAnnualFreeCard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfAnnualFreeCard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfAnnualFreeCard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfAnnualFreeCard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfAnnualFreeCard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfAnnualFreeCard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfAnnualFreeCard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfAnnualFreeCard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFAnnualFreeCardWrapper((ESFAnnualFreeCard)_esfAnnualFreeCard.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard) {
		return _esfAnnualFreeCard.compareTo(esfAnnualFreeCard);
	}

	@Override
	public int hashCode() {
		return _esfAnnualFreeCard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFAnnualFreeCard> toCacheModel() {
		return _esfAnnualFreeCard.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard toEscapedModel() {
		return new ESFAnnualFreeCardWrapper(_esfAnnualFreeCard.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard toUnescapedModel() {
		return new ESFAnnualFreeCardWrapper(_esfAnnualFreeCard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfAnnualFreeCard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfAnnualFreeCard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfAnnualFreeCard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFAnnualFreeCardWrapper)) {
			return false;
		}

		ESFAnnualFreeCardWrapper esfAnnualFreeCardWrapper = (ESFAnnualFreeCardWrapper)obj;

		if (Validator.equals(_esfAnnualFreeCard,
					esfAnnualFreeCardWrapper._esfAnnualFreeCard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFAnnualFreeCard getWrappedESFAnnualFreeCard() {
		return _esfAnnualFreeCard;
	}

	@Override
	public ESFAnnualFreeCard getWrappedModel() {
		return _esfAnnualFreeCard;
	}

	@Override
	public void resetOriginalValues() {
		_esfAnnualFreeCard.resetOriginalValues();
	}

	private ESFAnnualFreeCard _esfAnnualFreeCard;
}