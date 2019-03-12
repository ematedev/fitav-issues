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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFCard}.
 * </p>
 *
 * @author Ethica
 * @see ESFCard
 * @generated
 */
public class ESFCardWrapper implements ESFCard, ModelWrapper<ESFCard> {
	public ESFCardWrapper(ESFCard esfCard) {
		_esfCard = esfCard;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCard.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCardId", getEsfCardId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codeAlfa", getCodeAlfa());
		attributes.put("codeNum", getCodeNum());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("temporary", getTemporary());
		attributes.put("code", getCode());
		attributes.put("oldCode", getOldCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCardId = (Long)attributes.get("esfCardId");

		if (esfCardId != null) {
			setEsfCardId(esfCardId);
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

		String codeAlfa = (String)attributes.get("codeAlfa");

		if (codeAlfa != null) {
			setCodeAlfa(codeAlfa);
		}

		Long codeNum = (Long)attributes.get("codeNum");

		if (codeNum != null) {
			setCodeNum(codeNum);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String temporary = (String)attributes.get("temporary");

		if (temporary != null) {
			setTemporary(temporary);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String oldCode = (String)attributes.get("oldCode");

		if (oldCode != null) {
			setOldCode(oldCode);
		}
	}

	/**
	* Returns the primary key of this e s f card.
	*
	* @return the primary key of this e s f card
	*/
	@Override
	public long getPrimaryKey() {
		return _esfCard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f card.
	*
	* @param primaryKey the primary key of this e s f card
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfCard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f card.
	*
	* @return the uuid of this e s f card
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfCard.getUuid();
	}

	/**
	* Sets the uuid of this e s f card.
	*
	* @param uuid the uuid of this e s f card
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfCard.setUuid(uuid);
	}

	/**
	* Returns the esf card ID of this e s f card.
	*
	* @return the esf card ID of this e s f card
	*/
	@Override
	public long getEsfCardId() {
		return _esfCard.getEsfCardId();
	}

	/**
	* Sets the esf card ID of this e s f card.
	*
	* @param esfCardId the esf card ID of this e s f card
	*/
	@Override
	public void setEsfCardId(long esfCardId) {
		_esfCard.setEsfCardId(esfCardId);
	}

	/**
	* Returns the group ID of this e s f card.
	*
	* @return the group ID of this e s f card
	*/
	@Override
	public long getGroupId() {
		return _esfCard.getGroupId();
	}

	/**
	* Sets the group ID of this e s f card.
	*
	* @param groupId the group ID of this e s f card
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfCard.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f card.
	*
	* @return the company ID of this e s f card
	*/
	@Override
	public long getCompanyId() {
		return _esfCard.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f card.
	*
	* @param companyId the company ID of this e s f card
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfCard.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f card.
	*
	* @return the user ID of this e s f card
	*/
	@Override
	public long getUserId() {
		return _esfCard.getUserId();
	}

	/**
	* Sets the user ID of this e s f card.
	*
	* @param userId the user ID of this e s f card
	*/
	@Override
	public void setUserId(long userId) {
		_esfCard.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f card.
	*
	* @return the user uuid of this e s f card
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCard.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f card.
	*
	* @param userUuid the user uuid of this e s f card
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfCard.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f card.
	*
	* @return the user name of this e s f card
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfCard.getUserName();
	}

	/**
	* Sets the user name of this e s f card.
	*
	* @param userName the user name of this e s f card
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfCard.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f card.
	*
	* @return the create date of this e s f card
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfCard.getCreateDate();
	}

	/**
	* Sets the create date of this e s f card.
	*
	* @param createDate the create date of this e s f card
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfCard.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f card.
	*
	* @return the modified date of this e s f card
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfCard.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f card.
	*
	* @param modifiedDate the modified date of this e s f card
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfCard.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code alfa of this e s f card.
	*
	* @return the code alfa of this e s f card
	*/
	@Override
	public java.lang.String getCodeAlfa() {
		return _esfCard.getCodeAlfa();
	}

	/**
	* Sets the code alfa of this e s f card.
	*
	* @param codeAlfa the code alfa of this e s f card
	*/
	@Override
	public void setCodeAlfa(java.lang.String codeAlfa) {
		_esfCard.setCodeAlfa(codeAlfa);
	}

	/**
	* Returns the code num of this e s f card.
	*
	* @return the code num of this e s f card
	*/
	@Override
	public long getCodeNum() {
		return _esfCard.getCodeNum();
	}

	/**
	* Sets the code num of this e s f card.
	*
	* @param codeNum the code num of this e s f card
	*/
	@Override
	public void setCodeNum(long codeNum) {
		_esfCard.setCodeNum(codeNum);
	}

	/**
	* Returns the esf user ID of this e s f card.
	*
	* @return the esf user ID of this e s f card
	*/
	@Override
	public long getEsfUserId() {
		return _esfCard.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f card.
	*
	* @param esfUserId the esf user ID of this e s f card
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfCard.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f card.
	*
	* @return the esf user uuid of this e s f card
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCard.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f card.
	*
	* @param esfUserUuid the esf user uuid of this e s f card
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfCard.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf organization ID of this e s f card.
	*
	* @return the esf organization ID of this e s f card
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfCard.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f card.
	*
	* @param esfOrganizationId the esf organization ID of this e s f card
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfCard.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the temporary of this e s f card.
	*
	* @return the temporary of this e s f card
	*/
	@Override
	public java.lang.String getTemporary() {
		return _esfCard.getTemporary();
	}

	/**
	* Sets the temporary of this e s f card.
	*
	* @param temporary the temporary of this e s f card
	*/
	@Override
	public void setTemporary(java.lang.String temporary) {
		_esfCard.setTemporary(temporary);
	}

	/**
	* Returns the code of this e s f card.
	*
	* @return the code of this e s f card
	*/
	@Override
	public java.lang.String getCode() {
		return _esfCard.getCode();
	}

	/**
	* Sets the code of this e s f card.
	*
	* @param code the code of this e s f card
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfCard.setCode(code);
	}

	/**
	* Returns the old code of this e s f card.
	*
	* @return the old code of this e s f card
	*/
	@Override
	public java.lang.String getOldCode() {
		return _esfCard.getOldCode();
	}

	/**
	* Sets the old code of this e s f card.
	*
	* @param oldCode the old code of this e s f card
	*/
	@Override
	public void setOldCode(java.lang.String oldCode) {
		_esfCard.setOldCode(oldCode);
	}

	@Override
	public boolean isNew() {
		return _esfCard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCardWrapper((ESFCard)_esfCard.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCard esfCard) {
		return _esfCard.compareTo(esfCard);
	}

	@Override
	public int hashCode() {
		return _esfCard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCard> toCacheModel() {
		return _esfCard.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCard toEscapedModel() {
		return new ESFCardWrapper(_esfCard.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCard toUnescapedModel() {
		return new ESFCardWrapper(_esfCard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCardWrapper)) {
			return false;
		}

		ESFCardWrapper esfCardWrapper = (ESFCardWrapper)obj;

		if (Validator.equals(_esfCard, esfCardWrapper._esfCard)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfCard.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCard getWrappedESFCard() {
		return _esfCard;
	}

	@Override
	public ESFCard getWrappedModel() {
		return _esfCard;
	}

	@Override
	public void resetOriginalValues() {
		_esfCard.resetOriginalValues();
	}

	private ESFCard _esfCard;
}