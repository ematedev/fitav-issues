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
 * This class is a wrapper for {@link ESFNationalMatchResult}.
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResult
 * @generated
 */
public class ESFNationalMatchResultWrapper implements ESFNationalMatchResult,
	ModelWrapper<ESFNationalMatchResult> {
	public ESFNationalMatchResultWrapper(
		ESFNationalMatchResult esfNationalMatchResult) {
		_esfNationalMatchResult = esfNationalMatchResult;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFNationalMatchResult.class;
	}

	@Override
	public String getModelClassName() {
		return ESFNationalMatchResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfNationalMatchResultId", getEsfNationalMatchResultId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("position", getPosition());
		attributes.put("qualification", getQualification());
		attributes.put("shootOff", getShootOff());
		attributes.put("clayPigeonTotal", getClayPigeonTotal());
		attributes.put("finalResult", getFinalResult());
		attributes.put("shootOffFinal", getShootOffFinal());
		attributes.put("externalShooter", getExternalShooter());
		attributes.put("externalName", getExternalName());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("userNationality", getUserNationality());
		attributes.put("esfUserQualification", getEsfUserQualification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfNationalMatchResultId = (Long)attributes.get(
				"esfNationalMatchResultId");

		if (esfNationalMatchResultId != null) {
			setEsfNationalMatchResultId(esfNationalMatchResultId);
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

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Integer qualification = (Integer)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Integer shootOff = (Integer)attributes.get("shootOff");

		if (shootOff != null) {
			setShootOff(shootOff);
		}

		Integer clayPigeonTotal = (Integer)attributes.get("clayPigeonTotal");

		if (clayPigeonTotal != null) {
			setClayPigeonTotal(clayPigeonTotal);
		}

		Integer finalResult = (Integer)attributes.get("finalResult");

		if (finalResult != null) {
			setFinalResult(finalResult);
		}

		Integer shootOffFinal = (Integer)attributes.get("shootOffFinal");

		if (shootOffFinal != null) {
			setShootOffFinal(shootOffFinal);
		}

		Boolean externalShooter = (Boolean)attributes.get("externalShooter");

		if (externalShooter != null) {
			setExternalShooter(externalShooter);
		}

		String externalName = (String)attributes.get("externalName");

		if (externalName != null) {
			setExternalName(externalName);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		String userNationality = (String)attributes.get("userNationality");

		if (userNationality != null) {
			setUserNationality(userNationality);
		}

		Long esfUserQualification = (Long)attributes.get("esfUserQualification");

		if (esfUserQualification != null) {
			setEsfUserQualification(esfUserQualification);
		}
	}

	/**
	* Returns the primary key of this e s f national match result.
	*
	* @return the primary key of this e s f national match result
	*/
	@Override
	public long getPrimaryKey() {
		return _esfNationalMatchResult.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f national match result.
	*
	* @param primaryKey the primary key of this e s f national match result
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfNationalMatchResult.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf national match result ID of this e s f national match result.
	*
	* @return the esf national match result ID of this e s f national match result
	*/
	@Override
	public long getEsfNationalMatchResultId() {
		return _esfNationalMatchResult.getEsfNationalMatchResultId();
	}

	/**
	* Sets the esf national match result ID of this e s f national match result.
	*
	* @param esfNationalMatchResultId the esf national match result ID of this e s f national match result
	*/
	@Override
	public void setEsfNationalMatchResultId(long esfNationalMatchResultId) {
		_esfNationalMatchResult.setEsfNationalMatchResultId(esfNationalMatchResultId);
	}

	/**
	* Returns the group ID of this e s f national match result.
	*
	* @return the group ID of this e s f national match result
	*/
	@Override
	public long getGroupId() {
		return _esfNationalMatchResult.getGroupId();
	}

	/**
	* Sets the group ID of this e s f national match result.
	*
	* @param groupId the group ID of this e s f national match result
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfNationalMatchResult.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f national match result.
	*
	* @return the company ID of this e s f national match result
	*/
	@Override
	public long getCompanyId() {
		return _esfNationalMatchResult.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f national match result.
	*
	* @param companyId the company ID of this e s f national match result
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfNationalMatchResult.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f national match result.
	*
	* @return the user ID of this e s f national match result
	*/
	@Override
	public long getUserId() {
		return _esfNationalMatchResult.getUserId();
	}

	/**
	* Sets the user ID of this e s f national match result.
	*
	* @param userId the user ID of this e s f national match result
	*/
	@Override
	public void setUserId(long userId) {
		_esfNationalMatchResult.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f national match result.
	*
	* @return the user uuid of this e s f national match result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResult.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f national match result.
	*
	* @param userUuid the user uuid of this e s f national match result
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfNationalMatchResult.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f national match result.
	*
	* @return the user name of this e s f national match result
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfNationalMatchResult.getUserName();
	}

	/**
	* Sets the user name of this e s f national match result.
	*
	* @param userName the user name of this e s f national match result
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfNationalMatchResult.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f national match result.
	*
	* @return the create date of this e s f national match result
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfNationalMatchResult.getCreateDate();
	}

	/**
	* Sets the create date of this e s f national match result.
	*
	* @param createDate the create date of this e s f national match result
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfNationalMatchResult.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f national match result.
	*
	* @return the modified date of this e s f national match result
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfNationalMatchResult.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f national match result.
	*
	* @param modifiedDate the modified date of this e s f national match result
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfNationalMatchResult.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf match ID of this e s f national match result.
	*
	* @return the esf match ID of this e s f national match result
	*/
	@Override
	public long getEsfMatchId() {
		return _esfNationalMatchResult.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f national match result.
	*
	* @param esfMatchId the esf match ID of this e s f national match result
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfNationalMatchResult.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf user ID of this e s f national match result.
	*
	* @return the esf user ID of this e s f national match result
	*/
	@Override
	public long getEsfUserId() {
		return _esfNationalMatchResult.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f national match result.
	*
	* @param esfUserId the esf user ID of this e s f national match result
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfNationalMatchResult.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f national match result.
	*
	* @return the esf user uuid of this e s f national match result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResult.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f national match result.
	*
	* @param esfUserUuid the esf user uuid of this e s f national match result
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfNationalMatchResult.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the position of this e s f national match result.
	*
	* @return the position of this e s f national match result
	*/
	@Override
	public int getPosition() {
		return _esfNationalMatchResult.getPosition();
	}

	/**
	* Sets the position of this e s f national match result.
	*
	* @param position the position of this e s f national match result
	*/
	@Override
	public void setPosition(int position) {
		_esfNationalMatchResult.setPosition(position);
	}

	/**
	* Returns the qualification of this e s f national match result.
	*
	* @return the qualification of this e s f national match result
	*/
	@Override
	public int getQualification() {
		return _esfNationalMatchResult.getQualification();
	}

	/**
	* Sets the qualification of this e s f national match result.
	*
	* @param qualification the qualification of this e s f national match result
	*/
	@Override
	public void setQualification(int qualification) {
		_esfNationalMatchResult.setQualification(qualification);
	}

	/**
	* Returns the shoot off of this e s f national match result.
	*
	* @return the shoot off of this e s f national match result
	*/
	@Override
	public int getShootOff() {
		return _esfNationalMatchResult.getShootOff();
	}

	/**
	* Sets the shoot off of this e s f national match result.
	*
	* @param shootOff the shoot off of this e s f national match result
	*/
	@Override
	public void setShootOff(int shootOff) {
		_esfNationalMatchResult.setShootOff(shootOff);
	}

	/**
	* Returns the clay pigeon total of this e s f national match result.
	*
	* @return the clay pigeon total of this e s f national match result
	*/
	@Override
	public int getClayPigeonTotal() {
		return _esfNationalMatchResult.getClayPigeonTotal();
	}

	/**
	* Sets the clay pigeon total of this e s f national match result.
	*
	* @param clayPigeonTotal the clay pigeon total of this e s f national match result
	*/
	@Override
	public void setClayPigeonTotal(int clayPigeonTotal) {
		_esfNationalMatchResult.setClayPigeonTotal(clayPigeonTotal);
	}

	/**
	* Returns the final result of this e s f national match result.
	*
	* @return the final result of this e s f national match result
	*/
	@Override
	public int getFinalResult() {
		return _esfNationalMatchResult.getFinalResult();
	}

	/**
	* Sets the final result of this e s f national match result.
	*
	* @param finalResult the final result of this e s f national match result
	*/
	@Override
	public void setFinalResult(int finalResult) {
		_esfNationalMatchResult.setFinalResult(finalResult);
	}

	/**
	* Returns the shoot off final of this e s f national match result.
	*
	* @return the shoot off final of this e s f national match result
	*/
	@Override
	public int getShootOffFinal() {
		return _esfNationalMatchResult.getShootOffFinal();
	}

	/**
	* Sets the shoot off final of this e s f national match result.
	*
	* @param shootOffFinal the shoot off final of this e s f national match result
	*/
	@Override
	public void setShootOffFinal(int shootOffFinal) {
		_esfNationalMatchResult.setShootOffFinal(shootOffFinal);
	}

	/**
	* Returns the external shooter of this e s f national match result.
	*
	* @return the external shooter of this e s f national match result
	*/
	@Override
	public boolean getExternalShooter() {
		return _esfNationalMatchResult.getExternalShooter();
	}

	/**
	* Returns <code>true</code> if this e s f national match result is external shooter.
	*
	* @return <code>true</code> if this e s f national match result is external shooter; <code>false</code> otherwise
	*/
	@Override
	public boolean isExternalShooter() {
		return _esfNationalMatchResult.isExternalShooter();
	}

	/**
	* Sets whether this e s f national match result is external shooter.
	*
	* @param externalShooter the external shooter of this e s f national match result
	*/
	@Override
	public void setExternalShooter(boolean externalShooter) {
		_esfNationalMatchResult.setExternalShooter(externalShooter);
	}

	/**
	* Returns the external name of this e s f national match result.
	*
	* @return the external name of this e s f national match result
	*/
	@Override
	public java.lang.String getExternalName() {
		return _esfNationalMatchResult.getExternalName();
	}

	/**
	* Sets the external name of this e s f national match result.
	*
	* @param externalName the external name of this e s f national match result
	*/
	@Override
	public void setExternalName(java.lang.String externalName) {
		_esfNationalMatchResult.setExternalName(externalName);
	}

	/**
	* Returns the esf sport type ID of this e s f national match result.
	*
	* @return the esf sport type ID of this e s f national match result
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfNationalMatchResult.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f national match result.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f national match result
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfNationalMatchResult.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the user nationality of this e s f national match result.
	*
	* @return the user nationality of this e s f national match result
	*/
	@Override
	public java.lang.String getUserNationality() {
		return _esfNationalMatchResult.getUserNationality();
	}

	/**
	* Sets the user nationality of this e s f national match result.
	*
	* @param userNationality the user nationality of this e s f national match result
	*/
	@Override
	public void setUserNationality(java.lang.String userNationality) {
		_esfNationalMatchResult.setUserNationality(userNationality);
	}

	/**
	* Returns the esf user qualification of this e s f national match result.
	*
	* @return the esf user qualification of this e s f national match result
	*/
	@Override
	public long getEsfUserQualification() {
		return _esfNationalMatchResult.getEsfUserQualification();
	}

	/**
	* Sets the esf user qualification of this e s f national match result.
	*
	* @param esfUserQualification the esf user qualification of this e s f national match result
	*/
	@Override
	public void setEsfUserQualification(long esfUserQualification) {
		_esfNationalMatchResult.setEsfUserQualification(esfUserQualification);
	}

	@Override
	public boolean isNew() {
		return _esfNationalMatchResult.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfNationalMatchResult.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfNationalMatchResult.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfNationalMatchResult.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfNationalMatchResult.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfNationalMatchResult.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfNationalMatchResult.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfNationalMatchResult.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfNationalMatchResult.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfNationalMatchResult.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfNationalMatchResult.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFNationalMatchResultWrapper((ESFNationalMatchResult)_esfNationalMatchResult.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult) {
		return _esfNationalMatchResult.compareTo(esfNationalMatchResult);
	}

	@Override
	public int hashCode() {
		return _esfNationalMatchResult.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFNationalMatchResult> toCacheModel() {
		return _esfNationalMatchResult.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult toEscapedModel() {
		return new ESFNationalMatchResultWrapper(_esfNationalMatchResult.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult toUnescapedModel() {
		return new ESFNationalMatchResultWrapper(_esfNationalMatchResult.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfNationalMatchResult.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfNationalMatchResult.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfNationalMatchResult.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFNationalMatchResultWrapper)) {
			return false;
		}

		ESFNationalMatchResultWrapper esfNationalMatchResultWrapper = (ESFNationalMatchResultWrapper)obj;

		if (Validator.equals(_esfNationalMatchResult,
					esfNationalMatchResultWrapper._esfNationalMatchResult)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFNationalMatchResult getWrappedESFNationalMatchResult() {
		return _esfNationalMatchResult;
	}

	@Override
	public ESFNationalMatchResult getWrappedModel() {
		return _esfNationalMatchResult;
	}

	@Override
	public void resetOriginalValues() {
		_esfNationalMatchResult.resetOriginalValues();
	}

	private ESFNationalMatchResult _esfNationalMatchResult;
}