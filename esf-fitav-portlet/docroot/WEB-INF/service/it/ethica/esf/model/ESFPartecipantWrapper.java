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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFPartecipant}.
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipant
 * @generated
 */
public class ESFPartecipantWrapper implements ESFPartecipant,
	ModelWrapper<ESFPartecipant> {
	public ESFPartecipantWrapper(ESFPartecipant esfPartecipant) {
		_esfPartecipant = esfPartecipant;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPartecipant.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPartecipant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfPartecipantId", getEsfPartecipantId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfTeamId", getEsfTeamId());
		attributes.put("ct", getCt());
		attributes.put("esfPartecipantTypeId", getEsfPartecipantTypeId());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfPartecipantId = (Long)attributes.get("esfPartecipantId");

		if (esfPartecipantId != null) {
			setEsfPartecipantId(esfPartecipantId);
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

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfTeamId = (Long)attributes.get("esfTeamId");

		if (esfTeamId != null) {
			setEsfTeamId(esfTeamId);
		}

		Long ct = (Long)attributes.get("ct");

		if (ct != null) {
			setCt(ct);
		}

		Long esfPartecipantTypeId = (Long)attributes.get("esfPartecipantTypeId");

		if (esfPartecipantTypeId != null) {
			setEsfPartecipantTypeId(esfPartecipantTypeId);
		}

		Long result = (Long)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	/**
	* Returns the primary key of this e s f partecipant.
	*
	* @return the primary key of this e s f partecipant
	*/
	@Override
	public long getPrimaryKey() {
		return _esfPartecipant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f partecipant.
	*
	* @param primaryKey the primary key of this e s f partecipant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfPartecipant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f partecipant.
	*
	* @return the uuid of this e s f partecipant
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfPartecipant.getUuid();
	}

	/**
	* Sets the uuid of this e s f partecipant.
	*
	* @param uuid the uuid of this e s f partecipant
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfPartecipant.setUuid(uuid);
	}

	/**
	* Returns the esf partecipant ID of this e s f partecipant.
	*
	* @return the esf partecipant ID of this e s f partecipant
	*/
	@Override
	public long getEsfPartecipantId() {
		return _esfPartecipant.getEsfPartecipantId();
	}

	/**
	* Sets the esf partecipant ID of this e s f partecipant.
	*
	* @param esfPartecipantId the esf partecipant ID of this e s f partecipant
	*/
	@Override
	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfPartecipant.setEsfPartecipantId(esfPartecipantId);
	}

	/**
	* Returns the group ID of this e s f partecipant.
	*
	* @return the group ID of this e s f partecipant
	*/
	@Override
	public long getGroupId() {
		return _esfPartecipant.getGroupId();
	}

	/**
	* Sets the group ID of this e s f partecipant.
	*
	* @param groupId the group ID of this e s f partecipant
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfPartecipant.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f partecipant.
	*
	* @return the company ID of this e s f partecipant
	*/
	@Override
	public long getCompanyId() {
		return _esfPartecipant.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f partecipant.
	*
	* @param companyId the company ID of this e s f partecipant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfPartecipant.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f partecipant.
	*
	* @return the user ID of this e s f partecipant
	*/
	@Override
	public long getUserId() {
		return _esfPartecipant.getUserId();
	}

	/**
	* Sets the user ID of this e s f partecipant.
	*
	* @param userId the user ID of this e s f partecipant
	*/
	@Override
	public void setUserId(long userId) {
		_esfPartecipant.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f partecipant.
	*
	* @return the user uuid of this e s f partecipant
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipant.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f partecipant.
	*
	* @param userUuid the user uuid of this e s f partecipant
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfPartecipant.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f partecipant.
	*
	* @return the user name of this e s f partecipant
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfPartecipant.getUserName();
	}

	/**
	* Sets the user name of this e s f partecipant.
	*
	* @param userName the user name of this e s f partecipant
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfPartecipant.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f partecipant.
	*
	* @return the create date of this e s f partecipant
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfPartecipant.getCreateDate();
	}

	/**
	* Sets the create date of this e s f partecipant.
	*
	* @param createDate the create date of this e s f partecipant
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfPartecipant.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f partecipant.
	*
	* @return the modified date of this e s f partecipant
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfPartecipant.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f partecipant.
	*
	* @param modifiedDate the modified date of this e s f partecipant
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfPartecipant.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf user ID of this e s f partecipant.
	*
	* @return the esf user ID of this e s f partecipant
	*/
	@Override
	public long getEsfUserId() {
		return _esfPartecipant.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f partecipant.
	*
	* @param esfUserId the esf user ID of this e s f partecipant
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfPartecipant.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f partecipant.
	*
	* @return the esf user uuid of this e s f partecipant
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipant.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f partecipant.
	*
	* @param esfUserUuid the esf user uuid of this e s f partecipant
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfPartecipant.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf match ID of this e s f partecipant.
	*
	* @return the esf match ID of this e s f partecipant
	*/
	@Override
	public long getEsfMatchId() {
		return _esfPartecipant.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f partecipant.
	*
	* @param esfMatchId the esf match ID of this e s f partecipant
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfPartecipant.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf team ID of this e s f partecipant.
	*
	* @return the esf team ID of this e s f partecipant
	*/
	@Override
	public long getEsfTeamId() {
		return _esfPartecipant.getEsfTeamId();
	}

	/**
	* Sets the esf team ID of this e s f partecipant.
	*
	* @param esfTeamId the esf team ID of this e s f partecipant
	*/
	@Override
	public void setEsfTeamId(long esfTeamId) {
		_esfPartecipant.setEsfTeamId(esfTeamId);
	}

	/**
	* Returns the ct of this e s f partecipant.
	*
	* @return the ct of this e s f partecipant
	*/
	@Override
	public long getCt() {
		return _esfPartecipant.getCt();
	}

	/**
	* Sets the ct of this e s f partecipant.
	*
	* @param ct the ct of this e s f partecipant
	*/
	@Override
	public void setCt(long ct) {
		_esfPartecipant.setCt(ct);
	}

	/**
	* Returns the esf partecipant type ID of this e s f partecipant.
	*
	* @return the esf partecipant type ID of this e s f partecipant
	*/
	@Override
	public long getEsfPartecipantTypeId() {
		return _esfPartecipant.getEsfPartecipantTypeId();
	}

	/**
	* Sets the esf partecipant type ID of this e s f partecipant.
	*
	* @param esfPartecipantTypeId the esf partecipant type ID of this e s f partecipant
	*/
	@Override
	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipant.setEsfPartecipantTypeId(esfPartecipantTypeId);
	}

	/**
	* Returns the result of this e s f partecipant.
	*
	* @return the result of this e s f partecipant
	*/
	@Override
	public long getResult() {
		return _esfPartecipant.getResult();
	}

	/**
	* Sets the result of this e s f partecipant.
	*
	* @param result the result of this e s f partecipant
	*/
	@Override
	public void setResult(long result) {
		_esfPartecipant.setResult(result);
	}

	@Override
	public boolean isNew() {
		return _esfPartecipant.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfPartecipant.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfPartecipant.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfPartecipant.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfPartecipant.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfPartecipant.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfPartecipant.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfPartecipant.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfPartecipant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfPartecipant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfPartecipant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFPartecipantWrapper((ESFPartecipant)_esfPartecipant.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFPartecipant esfPartecipant) {
		return _esfPartecipant.compareTo(esfPartecipant);
	}

	@Override
	public int hashCode() {
		return _esfPartecipant.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFPartecipant> toCacheModel() {
		return _esfPartecipant.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant toEscapedModel() {
		return new ESFPartecipantWrapper(_esfPartecipant.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFPartecipant toUnescapedModel() {
		return new ESFPartecipantWrapper(_esfPartecipant.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfPartecipant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfPartecipant.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPartecipant.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPartecipantWrapper)) {
			return false;
		}

		ESFPartecipantWrapper esfPartecipantWrapper = (ESFPartecipantWrapper)obj;

		if (Validator.equals(_esfPartecipant,
					esfPartecipantWrapper._esfPartecipant)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfPartecipant.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFPartecipant getWrappedESFPartecipant() {
		return _esfPartecipant;
	}

	@Override
	public ESFPartecipant getWrappedModel() {
		return _esfPartecipant;
	}

	@Override
	public void resetOriginalValues() {
		_esfPartecipant.resetOriginalValues();
	}

	private ESFPartecipant _esfPartecipant;
}