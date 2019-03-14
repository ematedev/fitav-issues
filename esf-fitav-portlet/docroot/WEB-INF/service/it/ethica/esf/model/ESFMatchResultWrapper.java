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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFMatchResult}.
 * </p>
 *
 * @author Ethica
 * @see ESFMatchResult
 * @generated
 */
public class ESFMatchResultWrapper implements ESFMatchResult,
	ModelWrapper<ESFMatchResult> {
	public ESFMatchResultWrapper(ESFMatchResult esfMatchResult) {
		_esfMatchResult = esfMatchResult;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFMatchResult.class;
	}

	@Override
	public String getModelClassName() {
		return ESFMatchResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfMatchResultId", getEsfMatchResultId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfPartecipantId", getEsfPartecipantId());
		attributes.put("cardCode", getCardCode());
		attributes.put("generalClassPosition", getGeneralClassPosition());
		attributes.put("categoryClassPosition", getCategoryClassPosition());
		attributes.put("categoryName", getCategoryName());
		attributes.put("qualification", getQualification());
		attributes.put("first", getFirst());
		attributes.put("second", getSecond());
		attributes.put("third", getThird());
		attributes.put("fourth", getFourth());
		attributes.put("fifth", getFifth());
		attributes.put("total", getTotal());
		attributes.put("firstPlayOff", getFirstPlayOff());
		attributes.put("secondPlayOff", getSecondPlayOff());
		attributes.put("thirdPlayOff", getThirdPlayOff());
		attributes.put("totalAfterPlayOff", getTotalAfterPlayOff());
		attributes.put("nextFirstPlayOff", getNextFirstPlayOff());
		attributes.put("nextSecondPlayOff", getNextSecondPlayOff());
		attributes.put("nextTotalPlayOff", getNextTotalPlayOff());
		attributes.put("fiscalCode", getFiscalCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfMatchResultId = (Long)attributes.get("esfMatchResultId");

		if (esfMatchResultId != null) {
			setEsfMatchResultId(esfMatchResultId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfPartecipantId = (Long)attributes.get("esfPartecipantId");

		if (esfPartecipantId != null) {
			setEsfPartecipantId(esfPartecipantId);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		Integer generalClassPosition = (Integer)attributes.get(
				"generalClassPosition");

		if (generalClassPosition != null) {
			setGeneralClassPosition(generalClassPosition);
		}

		Integer categoryClassPosition = (Integer)attributes.get(
				"categoryClassPosition");

		if (categoryClassPosition != null) {
			setCategoryClassPosition(categoryClassPosition);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Integer first = (Integer)attributes.get("first");

		if (first != null) {
			setFirst(first);
		}

		Integer second = (Integer)attributes.get("second");

		if (second != null) {
			setSecond(second);
		}

		Integer third = (Integer)attributes.get("third");

		if (third != null) {
			setThird(third);
		}

		Integer fourth = (Integer)attributes.get("fourth");

		if (fourth != null) {
			setFourth(fourth);
		}

		Integer fifth = (Integer)attributes.get("fifth");

		if (fifth != null) {
			setFifth(fifth);
		}

		Integer total = (Integer)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Integer firstPlayOff = (Integer)attributes.get("firstPlayOff");

		if (firstPlayOff != null) {
			setFirstPlayOff(firstPlayOff);
		}

		Integer secondPlayOff = (Integer)attributes.get("secondPlayOff");

		if (secondPlayOff != null) {
			setSecondPlayOff(secondPlayOff);
		}

		Integer thirdPlayOff = (Integer)attributes.get("thirdPlayOff");

		if (thirdPlayOff != null) {
			setThirdPlayOff(thirdPlayOff);
		}

		Integer totalAfterPlayOff = (Integer)attributes.get("totalAfterPlayOff");

		if (totalAfterPlayOff != null) {
			setTotalAfterPlayOff(totalAfterPlayOff);
		}

		Integer nextFirstPlayOff = (Integer)attributes.get("nextFirstPlayOff");

		if (nextFirstPlayOff != null) {
			setNextFirstPlayOff(nextFirstPlayOff);
		}

		Integer nextSecondPlayOff = (Integer)attributes.get("nextSecondPlayOff");

		if (nextSecondPlayOff != null) {
			setNextSecondPlayOff(nextSecondPlayOff);
		}

		Integer nextTotalPlayOff = (Integer)attributes.get("nextTotalPlayOff");

		if (nextTotalPlayOff != null) {
			setNextTotalPlayOff(nextTotalPlayOff);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}
	}

	/**
	* Returns the primary key of this e s f match result.
	*
	* @return the primary key of this e s f match result
	*/
	@Override
	public long getPrimaryKey() {
		return _esfMatchResult.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f match result.
	*
	* @param primaryKey the primary key of this e s f match result
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfMatchResult.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf match result ID of this e s f match result.
	*
	* @return the esf match result ID of this e s f match result
	*/
	@Override
	public long getEsfMatchResultId() {
		return _esfMatchResult.getEsfMatchResultId();
	}

	/**
	* Sets the esf match result ID of this e s f match result.
	*
	* @param esfMatchResultId the esf match result ID of this e s f match result
	*/
	@Override
	public void setEsfMatchResultId(long esfMatchResultId) {
		_esfMatchResult.setEsfMatchResultId(esfMatchResultId);
	}

	/**
	* Returns the group ID of this e s f match result.
	*
	* @return the group ID of this e s f match result
	*/
	@Override
	public long getGroupId() {
		return _esfMatchResult.getGroupId();
	}

	/**
	* Sets the group ID of this e s f match result.
	*
	* @param groupId the group ID of this e s f match result
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfMatchResult.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f match result.
	*
	* @return the company ID of this e s f match result
	*/
	@Override
	public long getCompanyId() {
		return _esfMatchResult.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f match result.
	*
	* @param companyId the company ID of this e s f match result
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfMatchResult.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f match result.
	*
	* @return the user ID of this e s f match result
	*/
	@Override
	public long getUserId() {
		return _esfMatchResult.getUserId();
	}

	/**
	* Sets the user ID of this e s f match result.
	*
	* @param userId the user ID of this e s f match result
	*/
	@Override
	public void setUserId(long userId) {
		_esfMatchResult.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f match result.
	*
	* @return the user uuid of this e s f match result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResult.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f match result.
	*
	* @param userUuid the user uuid of this e s f match result
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfMatchResult.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f match result.
	*
	* @return the user name of this e s f match result
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfMatchResult.getUserName();
	}

	/**
	* Sets the user name of this e s f match result.
	*
	* @param userName the user name of this e s f match result
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfMatchResult.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f match result.
	*
	* @return the create date of this e s f match result
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfMatchResult.getCreateDate();
	}

	/**
	* Sets the create date of this e s f match result.
	*
	* @param createDate the create date of this e s f match result
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfMatchResult.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f match result.
	*
	* @return the modified date of this e s f match result
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfMatchResult.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f match result.
	*
	* @param modifiedDate the modified date of this e s f match result
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfMatchResult.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf match ID of this e s f match result.
	*
	* @return the esf match ID of this e s f match result
	*/
	@Override
	public long getEsfMatchId() {
		return _esfMatchResult.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f match result.
	*
	* @param esfMatchId the esf match ID of this e s f match result
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchResult.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf partecipant ID of this e s f match result.
	*
	* @return the esf partecipant ID of this e s f match result
	*/
	@Override
	public long getEsfPartecipantId() {
		return _esfMatchResult.getEsfPartecipantId();
	}

	/**
	* Sets the esf partecipant ID of this e s f match result.
	*
	* @param esfPartecipantId the esf partecipant ID of this e s f match result
	*/
	@Override
	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfMatchResult.setEsfPartecipantId(esfPartecipantId);
	}

	/**
	* Returns the card code of this e s f match result.
	*
	* @return the card code of this e s f match result
	*/
	@Override
	public java.lang.String getCardCode() {
		return _esfMatchResult.getCardCode();
	}

	/**
	* Sets the card code of this e s f match result.
	*
	* @param cardCode the card code of this e s f match result
	*/
	@Override
	public void setCardCode(java.lang.String cardCode) {
		_esfMatchResult.setCardCode(cardCode);
	}

	/**
	* Returns the general class position of this e s f match result.
	*
	* @return the general class position of this e s f match result
	*/
	@Override
	public int getGeneralClassPosition() {
		return _esfMatchResult.getGeneralClassPosition();
	}

	/**
	* Sets the general class position of this e s f match result.
	*
	* @param generalClassPosition the general class position of this e s f match result
	*/
	@Override
	public void setGeneralClassPosition(int generalClassPosition) {
		_esfMatchResult.setGeneralClassPosition(generalClassPosition);
	}

	/**
	* Returns the category class position of this e s f match result.
	*
	* @return the category class position of this e s f match result
	*/
	@Override
	public int getCategoryClassPosition() {
		return _esfMatchResult.getCategoryClassPosition();
	}

	/**
	* Sets the category class position of this e s f match result.
	*
	* @param categoryClassPosition the category class position of this e s f match result
	*/
	@Override
	public void setCategoryClassPosition(int categoryClassPosition) {
		_esfMatchResult.setCategoryClassPosition(categoryClassPosition);
	}

	/**
	* Returns the category name of this e s f match result.
	*
	* @return the category name of this e s f match result
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _esfMatchResult.getCategoryName();
	}

	/**
	* Sets the category name of this e s f match result.
	*
	* @param categoryName the category name of this e s f match result
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_esfMatchResult.setCategoryName(categoryName);
	}

	/**
	* Returns the qualification of this e s f match result.
	*
	* @return the qualification of this e s f match result
	*/
	@Override
	public java.lang.String getQualification() {
		return _esfMatchResult.getQualification();
	}

	/**
	* Sets the qualification of this e s f match result.
	*
	* @param qualification the qualification of this e s f match result
	*/
	@Override
	public void setQualification(java.lang.String qualification) {
		_esfMatchResult.setQualification(qualification);
	}

	/**
	* Returns the first of this e s f match result.
	*
	* @return the first of this e s f match result
	*/
	@Override
	public int getFirst() {
		return _esfMatchResult.getFirst();
	}

	/**
	* Sets the first of this e s f match result.
	*
	* @param first the first of this e s f match result
	*/
	@Override
	public void setFirst(int first) {
		_esfMatchResult.setFirst(first);
	}

	/**
	* Returns the second of this e s f match result.
	*
	* @return the second of this e s f match result
	*/
	@Override
	public int getSecond() {
		return _esfMatchResult.getSecond();
	}

	/**
	* Sets the second of this e s f match result.
	*
	* @param second the second of this e s f match result
	*/
	@Override
	public void setSecond(int second) {
		_esfMatchResult.setSecond(second);
	}

	/**
	* Returns the third of this e s f match result.
	*
	* @return the third of this e s f match result
	*/
	@Override
	public int getThird() {
		return _esfMatchResult.getThird();
	}

	/**
	* Sets the third of this e s f match result.
	*
	* @param third the third of this e s f match result
	*/
	@Override
	public void setThird(int third) {
		_esfMatchResult.setThird(third);
	}

	/**
	* Returns the fourth of this e s f match result.
	*
	* @return the fourth of this e s f match result
	*/
	@Override
	public int getFourth() {
		return _esfMatchResult.getFourth();
	}

	/**
	* Sets the fourth of this e s f match result.
	*
	* @param fourth the fourth of this e s f match result
	*/
	@Override
	public void setFourth(int fourth) {
		_esfMatchResult.setFourth(fourth);
	}

	/**
	* Returns the fifth of this e s f match result.
	*
	* @return the fifth of this e s f match result
	*/
	@Override
	public int getFifth() {
		return _esfMatchResult.getFifth();
	}

	/**
	* Sets the fifth of this e s f match result.
	*
	* @param fifth the fifth of this e s f match result
	*/
	@Override
	public void setFifth(int fifth) {
		_esfMatchResult.setFifth(fifth);
	}

	/**
	* Returns the total of this e s f match result.
	*
	* @return the total of this e s f match result
	*/
	@Override
	public int getTotal() {
		return _esfMatchResult.getTotal();
	}

	/**
	* Sets the total of this e s f match result.
	*
	* @param total the total of this e s f match result
	*/
	@Override
	public void setTotal(int total) {
		_esfMatchResult.setTotal(total);
	}

	/**
	* Returns the first play off of this e s f match result.
	*
	* @return the first play off of this e s f match result
	*/
	@Override
	public int getFirstPlayOff() {
		return _esfMatchResult.getFirstPlayOff();
	}

	/**
	* Sets the first play off of this e s f match result.
	*
	* @param firstPlayOff the first play off of this e s f match result
	*/
	@Override
	public void setFirstPlayOff(int firstPlayOff) {
		_esfMatchResult.setFirstPlayOff(firstPlayOff);
	}

	/**
	* Returns the second play off of this e s f match result.
	*
	* @return the second play off of this e s f match result
	*/
	@Override
	public int getSecondPlayOff() {
		return _esfMatchResult.getSecondPlayOff();
	}

	/**
	* Sets the second play off of this e s f match result.
	*
	* @param secondPlayOff the second play off of this e s f match result
	*/
	@Override
	public void setSecondPlayOff(int secondPlayOff) {
		_esfMatchResult.setSecondPlayOff(secondPlayOff);
	}

	/**
	* Returns the third play off of this e s f match result.
	*
	* @return the third play off of this e s f match result
	*/
	@Override
	public int getThirdPlayOff() {
		return _esfMatchResult.getThirdPlayOff();
	}

	/**
	* Sets the third play off of this e s f match result.
	*
	* @param thirdPlayOff the third play off of this e s f match result
	*/
	@Override
	public void setThirdPlayOff(int thirdPlayOff) {
		_esfMatchResult.setThirdPlayOff(thirdPlayOff);
	}

	/**
	* Returns the total after play off of this e s f match result.
	*
	* @return the total after play off of this e s f match result
	*/
	@Override
	public int getTotalAfterPlayOff() {
		return _esfMatchResult.getTotalAfterPlayOff();
	}

	/**
	* Sets the total after play off of this e s f match result.
	*
	* @param totalAfterPlayOff the total after play off of this e s f match result
	*/
	@Override
	public void setTotalAfterPlayOff(int totalAfterPlayOff) {
		_esfMatchResult.setTotalAfterPlayOff(totalAfterPlayOff);
	}

	/**
	* Returns the next first play off of this e s f match result.
	*
	* @return the next first play off of this e s f match result
	*/
	@Override
	public int getNextFirstPlayOff() {
		return _esfMatchResult.getNextFirstPlayOff();
	}

	/**
	* Sets the next first play off of this e s f match result.
	*
	* @param nextFirstPlayOff the next first play off of this e s f match result
	*/
	@Override
	public void setNextFirstPlayOff(int nextFirstPlayOff) {
		_esfMatchResult.setNextFirstPlayOff(nextFirstPlayOff);
	}

	/**
	* Returns the next second play off of this e s f match result.
	*
	* @return the next second play off of this e s f match result
	*/
	@Override
	public int getNextSecondPlayOff() {
		return _esfMatchResult.getNextSecondPlayOff();
	}

	/**
	* Sets the next second play off of this e s f match result.
	*
	* @param nextSecondPlayOff the next second play off of this e s f match result
	*/
	@Override
	public void setNextSecondPlayOff(int nextSecondPlayOff) {
		_esfMatchResult.setNextSecondPlayOff(nextSecondPlayOff);
	}

	/**
	* Returns the next total play off of this e s f match result.
	*
	* @return the next total play off of this e s f match result
	*/
	@Override
	public int getNextTotalPlayOff() {
		return _esfMatchResult.getNextTotalPlayOff();
	}

	/**
	* Sets the next total play off of this e s f match result.
	*
	* @param nextTotalPlayOff the next total play off of this e s f match result
	*/
	@Override
	public void setNextTotalPlayOff(int nextTotalPlayOff) {
		_esfMatchResult.setNextTotalPlayOff(nextTotalPlayOff);
	}

	/**
	* Returns the fiscal code of this e s f match result.
	*
	* @return the fiscal code of this e s f match result
	*/
	@Override
	public java.lang.String getFiscalCode() {
		return _esfMatchResult.getFiscalCode();
	}

	/**
	* Sets the fiscal code of this e s f match result.
	*
	* @param fiscalCode the fiscal code of this e s f match result
	*/
	@Override
	public void setFiscalCode(java.lang.String fiscalCode) {
		_esfMatchResult.setFiscalCode(fiscalCode);
	}

	@Override
	public boolean isNew() {
		return _esfMatchResult.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfMatchResult.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfMatchResult.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfMatchResult.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfMatchResult.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfMatchResult.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfMatchResult.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfMatchResult.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfMatchResult.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfMatchResult.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfMatchResult.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFMatchResultWrapper((ESFMatchResult)_esfMatchResult.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFMatchResult esfMatchResult) {
		return _esfMatchResult.compareTo(esfMatchResult);
	}

	@Override
	public int hashCode() {
		return _esfMatchResult.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFMatchResult> toCacheModel() {
		return _esfMatchResult.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFMatchResult toEscapedModel() {
		return new ESFMatchResultWrapper(_esfMatchResult.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFMatchResult toUnescapedModel() {
		return new ESFMatchResultWrapper(_esfMatchResult.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfMatchResult.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfMatchResult.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfMatchResult.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFMatchResultWrapper)) {
			return false;
		}

		ESFMatchResultWrapper esfMatchResultWrapper = (ESFMatchResultWrapper)obj;

		if (Validator.equals(_esfMatchResult,
					esfMatchResultWrapper._esfMatchResult)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFMatchResult getWrappedESFMatchResult() {
		return _esfMatchResult;
	}

	@Override
	public ESFMatchResult getWrappedModel() {
		return _esfMatchResult;
	}

	@Override
	public void resetOriginalValues() {
		_esfMatchResult.resetOriginalValues();
	}

	private ESFMatchResult _esfMatchResult;
}