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
 * This class is a wrapper for {@link ESFNationalDelegation}.
 * </p>
 *
 * @author Ethica
 * @see ESFNationalDelegation
 * @generated
 */
public class ESFNationalDelegationWrapper implements ESFNationalDelegation,
	ModelWrapper<ESFNationalDelegation> {
	public ESFNationalDelegationWrapper(
		ESFNationalDelegation esfNationalDelegation) {
		_esfNationalDelegation = esfNationalDelegation;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFNationalDelegation.class;
	}

	@Override
	public String getModelClassName() {
		return ESFNationalDelegation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveDate", getLeaveDate());
		attributes.put("returnDate", getReturnDate());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
		attributes.put("esfGunId1", getEsfGunId1());
		attributes.put("esfGunId2", getEsfGunId2());
		attributes.put("esfNationalDelgationId", getEsfNationalDelgationId());
		attributes.put("esfPartecipantTypeId", getEsfPartecipantTypeId());
		attributes.put("nominationDate", getNominationDate());
		attributes.put("refusalDate", getRefusalDate());
		attributes.put("taskId", getTaskId());
		attributes.put("refusal", getRefusal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
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

		Date leaveDate = (Date)attributes.get("leaveDate");

		if (leaveDate != null) {
			setLeaveDate(leaveDate);
		}

		Date returnDate = (Date)attributes.get("returnDate");

		if (returnDate != null) {
			setReturnDate(returnDate);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
		}

		Long esfGunId1 = (Long)attributes.get("esfGunId1");

		if (esfGunId1 != null) {
			setEsfGunId1(esfGunId1);
		}

		Long esfGunId2 = (Long)attributes.get("esfGunId2");

		if (esfGunId2 != null) {
			setEsfGunId2(esfGunId2);
		}

		Long esfNationalDelgationId = (Long)attributes.get(
				"esfNationalDelgationId");

		if (esfNationalDelgationId != null) {
			setEsfNationalDelgationId(esfNationalDelgationId);
		}

		Long esfPartecipantTypeId = (Long)attributes.get("esfPartecipantTypeId");

		if (esfPartecipantTypeId != null) {
			setEsfPartecipantTypeId(esfPartecipantTypeId);
		}

		Date nominationDate = (Date)attributes.get("nominationDate");

		if (nominationDate != null) {
			setNominationDate(nominationDate);
		}

		Date refusalDate = (Date)attributes.get("refusalDate");

		if (refusalDate != null) {
			setRefusalDate(refusalDate);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String refusal = (String)attributes.get("refusal");

		if (refusal != null) {
			setRefusal(refusal);
		}
	}

	/**
	* Returns the primary key of this e s f national delegation.
	*
	* @return the primary key of this e s f national delegation
	*/
	@Override
	public long getPrimaryKey() {
		return _esfNationalDelegation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f national delegation.
	*
	* @param primaryKey the primary key of this e s f national delegation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfNationalDelegation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f national delegation.
	*
	* @return the uuid of this e s f national delegation
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfNationalDelegation.getUuid();
	}

	/**
	* Sets the uuid of this e s f national delegation.
	*
	* @param uuid the uuid of this e s f national delegation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfNationalDelegation.setUuid(uuid);
	}

	/**
	* Returns the esf user ID of this e s f national delegation.
	*
	* @return the esf user ID of this e s f national delegation
	*/
	@Override
	public long getEsfUserId() {
		return _esfNationalDelegation.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f national delegation.
	*
	* @param esfUserId the esf user ID of this e s f national delegation
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfNationalDelegation.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f national delegation.
	*
	* @return the esf user uuid of this e s f national delegation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalDelegation.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f national delegation.
	*
	* @param esfUserUuid the esf user uuid of this e s f national delegation
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfNationalDelegation.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the group ID of this e s f national delegation.
	*
	* @return the group ID of this e s f national delegation
	*/
	@Override
	public long getGroupId() {
		return _esfNationalDelegation.getGroupId();
	}

	/**
	* Sets the group ID of this e s f national delegation.
	*
	* @param groupId the group ID of this e s f national delegation
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfNationalDelegation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f national delegation.
	*
	* @return the company ID of this e s f national delegation
	*/
	@Override
	public long getCompanyId() {
		return _esfNationalDelegation.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f national delegation.
	*
	* @param companyId the company ID of this e s f national delegation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfNationalDelegation.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f national delegation.
	*
	* @return the user ID of this e s f national delegation
	*/
	@Override
	public long getUserId() {
		return _esfNationalDelegation.getUserId();
	}

	/**
	* Sets the user ID of this e s f national delegation.
	*
	* @param userId the user ID of this e s f national delegation
	*/
	@Override
	public void setUserId(long userId) {
		_esfNationalDelegation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f national delegation.
	*
	* @return the user uuid of this e s f national delegation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalDelegation.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f national delegation.
	*
	* @param userUuid the user uuid of this e s f national delegation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfNationalDelegation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f national delegation.
	*
	* @return the user name of this e s f national delegation
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfNationalDelegation.getUserName();
	}

	/**
	* Sets the user name of this e s f national delegation.
	*
	* @param userName the user name of this e s f national delegation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfNationalDelegation.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f national delegation.
	*
	* @return the create date of this e s f national delegation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfNationalDelegation.getCreateDate();
	}

	/**
	* Sets the create date of this e s f national delegation.
	*
	* @param createDate the create date of this e s f national delegation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfNationalDelegation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f national delegation.
	*
	* @return the modified date of this e s f national delegation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfNationalDelegation.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f national delegation.
	*
	* @param modifiedDate the modified date of this e s f national delegation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfNationalDelegation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the leave date of this e s f national delegation.
	*
	* @return the leave date of this e s f national delegation
	*/
	@Override
	public java.util.Date getLeaveDate() {
		return _esfNationalDelegation.getLeaveDate();
	}

	/**
	* Sets the leave date of this e s f national delegation.
	*
	* @param leaveDate the leave date of this e s f national delegation
	*/
	@Override
	public void setLeaveDate(java.util.Date leaveDate) {
		_esfNationalDelegation.setLeaveDate(leaveDate);
	}

	/**
	* Returns the return date of this e s f national delegation.
	*
	* @return the return date of this e s f national delegation
	*/
	@Override
	public java.util.Date getReturnDate() {
		return _esfNationalDelegation.getReturnDate();
	}

	/**
	* Sets the return date of this e s f national delegation.
	*
	* @param returnDate the return date of this e s f national delegation
	*/
	@Override
	public void setReturnDate(java.util.Date returnDate) {
		_esfNationalDelegation.setReturnDate(returnDate);
	}

	/**
	* Returns the esf match ID of this e s f national delegation.
	*
	* @return the esf match ID of this e s f national delegation
	*/
	@Override
	public long getEsfMatchId() {
		return _esfNationalDelegation.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f national delegation.
	*
	* @param esfMatchId the esf match ID of this e s f national delegation
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfNationalDelegation.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf sport type ID of this e s f national delegation.
	*
	* @return the esf sport type ID of this e s f national delegation
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfNationalDelegation.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f national delegation.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f national delegation
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfNationalDelegation.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the esf shooter qualification ID of this e s f national delegation.
	*
	* @return the esf shooter qualification ID of this e s f national delegation
	*/
	@Override
	public long getEsfShooterQualificationId() {
		return _esfNationalDelegation.getEsfShooterQualificationId();
	}

	/**
	* Sets the esf shooter qualification ID of this e s f national delegation.
	*
	* @param esfShooterQualificationId the esf shooter qualification ID of this e s f national delegation
	*/
	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfNationalDelegation.setEsfShooterQualificationId(esfShooterQualificationId);
	}

	/**
	* Returns the esf gun id1 of this e s f national delegation.
	*
	* @return the esf gun id1 of this e s f national delegation
	*/
	@Override
	public long getEsfGunId1() {
		return _esfNationalDelegation.getEsfGunId1();
	}

	/**
	* Sets the esf gun id1 of this e s f national delegation.
	*
	* @param esfGunId1 the esf gun id1 of this e s f national delegation
	*/
	@Override
	public void setEsfGunId1(long esfGunId1) {
		_esfNationalDelegation.setEsfGunId1(esfGunId1);
	}

	/**
	* Returns the esf gun id2 of this e s f national delegation.
	*
	* @return the esf gun id2 of this e s f national delegation
	*/
	@Override
	public long getEsfGunId2() {
		return _esfNationalDelegation.getEsfGunId2();
	}

	/**
	* Sets the esf gun id2 of this e s f national delegation.
	*
	* @param esfGunId2 the esf gun id2 of this e s f national delegation
	*/
	@Override
	public void setEsfGunId2(long esfGunId2) {
		_esfNationalDelegation.setEsfGunId2(esfGunId2);
	}

	/**
	* Returns the esf national delgation ID of this e s f national delegation.
	*
	* @return the esf national delgation ID of this e s f national delegation
	*/
	@Override
	public long getEsfNationalDelgationId() {
		return _esfNationalDelegation.getEsfNationalDelgationId();
	}

	/**
	* Sets the esf national delgation ID of this e s f national delegation.
	*
	* @param esfNationalDelgationId the esf national delgation ID of this e s f national delegation
	*/
	@Override
	public void setEsfNationalDelgationId(long esfNationalDelgationId) {
		_esfNationalDelegation.setEsfNationalDelgationId(esfNationalDelgationId);
	}

	/**
	* Returns the esf partecipant type ID of this e s f national delegation.
	*
	* @return the esf partecipant type ID of this e s f national delegation
	*/
	@Override
	public long getEsfPartecipantTypeId() {
		return _esfNationalDelegation.getEsfPartecipantTypeId();
	}

	/**
	* Sets the esf partecipant type ID of this e s f national delegation.
	*
	* @param esfPartecipantTypeId the esf partecipant type ID of this e s f national delegation
	*/
	@Override
	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfNationalDelegation.setEsfPartecipantTypeId(esfPartecipantTypeId);
	}

	/**
	* Returns the nomination date of this e s f national delegation.
	*
	* @return the nomination date of this e s f national delegation
	*/
	@Override
	public java.util.Date getNominationDate() {
		return _esfNationalDelegation.getNominationDate();
	}

	/**
	* Sets the nomination date of this e s f national delegation.
	*
	* @param nominationDate the nomination date of this e s f national delegation
	*/
	@Override
	public void setNominationDate(java.util.Date nominationDate) {
		_esfNationalDelegation.setNominationDate(nominationDate);
	}

	/**
	* Returns the refusal date of this e s f national delegation.
	*
	* @return the refusal date of this e s f national delegation
	*/
	@Override
	public java.util.Date getRefusalDate() {
		return _esfNationalDelegation.getRefusalDate();
	}

	/**
	* Sets the refusal date of this e s f national delegation.
	*
	* @param refusalDate the refusal date of this e s f national delegation
	*/
	@Override
	public void setRefusalDate(java.util.Date refusalDate) {
		_esfNationalDelegation.setRefusalDate(refusalDate);
	}

	/**
	* Returns the task ID of this e s f national delegation.
	*
	* @return the task ID of this e s f national delegation
	*/
	@Override
	public long getTaskId() {
		return _esfNationalDelegation.getTaskId();
	}

	/**
	* Sets the task ID of this e s f national delegation.
	*
	* @param taskId the task ID of this e s f national delegation
	*/
	@Override
	public void setTaskId(long taskId) {
		_esfNationalDelegation.setTaskId(taskId);
	}

	/**
	* Returns the refusal of this e s f national delegation.
	*
	* @return the refusal of this e s f national delegation
	*/
	@Override
	public java.lang.String getRefusal() {
		return _esfNationalDelegation.getRefusal();
	}

	/**
	* Sets the refusal of this e s f national delegation.
	*
	* @param refusal the refusal of this e s f national delegation
	*/
	@Override
	public void setRefusal(java.lang.String refusal) {
		_esfNationalDelegation.setRefusal(refusal);
	}

	@Override
	public boolean isNew() {
		return _esfNationalDelegation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfNationalDelegation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfNationalDelegation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfNationalDelegation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfNationalDelegation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfNationalDelegation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfNationalDelegation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfNationalDelegation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfNationalDelegation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfNationalDelegation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfNationalDelegation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFNationalDelegationWrapper((ESFNationalDelegation)_esfNationalDelegation.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation) {
		return _esfNationalDelegation.compareTo(esfNationalDelegation);
	}

	@Override
	public int hashCode() {
		return _esfNationalDelegation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFNationalDelegation> toCacheModel() {
		return _esfNationalDelegation.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFNationalDelegation toEscapedModel() {
		return new ESFNationalDelegationWrapper(_esfNationalDelegation.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFNationalDelegation toUnescapedModel() {
		return new ESFNationalDelegationWrapper(_esfNationalDelegation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfNationalDelegation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfNationalDelegation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfNationalDelegation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFNationalDelegationWrapper)) {
			return false;
		}

		ESFNationalDelegationWrapper esfNationalDelegationWrapper = (ESFNationalDelegationWrapper)obj;

		if (Validator.equals(_esfNationalDelegation,
					esfNationalDelegationWrapper._esfNationalDelegation)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfNationalDelegation.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFNationalDelegation getWrappedESFNationalDelegation() {
		return _esfNationalDelegation;
	}

	@Override
	public ESFNationalDelegation getWrappedModel() {
		return _esfNationalDelegation;
	}

	@Override
	public void resetOriginalValues() {
		_esfNationalDelegation.resetOriginalValues();
	}

	private ESFNationalDelegation _esfNationalDelegation;
}