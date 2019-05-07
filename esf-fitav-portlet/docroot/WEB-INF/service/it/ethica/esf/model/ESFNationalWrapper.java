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
 * This class is a wrapper for {@link ESFNational}.
 * </p>
 *
 * @author Ethica
 * @see ESFNational
 * @generated
 */
public class ESFNationalWrapper implements ESFNational,
	ModelWrapper<ESFNational> {
	public ESFNationalWrapper(ESFNational esfNational) {
		_esfNational = esfNational;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFNational.class;
	}

	@Override
	public String getModelClassName() {
		return ESFNational.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfNationalId", getEsfNationalId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("BDODate", getBDODate());
		attributes.put("idInternational", getIdInternational());
		attributes.put("isUniversity", getIsUniversity());
		attributes.put("isNational", getIsNational());
		attributes.put("deliberate", getDeliberate());
		attributes.put("deliberateDate", getDeliberateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfNationalId = (Long)attributes.get("esfNationalId");

		if (esfNationalId != null) {
			setEsfNationalId(esfNationalId);
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

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date BDODate = (Date)attributes.get("BDODate");

		if (BDODate != null) {
			setBDODate(BDODate);
		}

		String idInternational = (String)attributes.get("idInternational");

		if (idInternational != null) {
			setIdInternational(idInternational);
		}

		Boolean isUniversity = (Boolean)attributes.get("isUniversity");

		if (isUniversity != null) {
			setIsUniversity(isUniversity);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String deliberate = (String)attributes.get("deliberate");

		if (deliberate != null) {
			setDeliberate(deliberate);
		}

		Date deliberateDate = (Date)attributes.get("deliberateDate");

		if (deliberateDate != null) {
			setDeliberateDate(deliberateDate);
		}
	}

	/**
	* Returns the primary key of this e s f national.
	*
	* @return the primary key of this e s f national
	*/
	@Override
	public long getPrimaryKey() {
		return _esfNational.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f national.
	*
	* @param primaryKey the primary key of this e s f national
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfNational.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f national.
	*
	* @return the uuid of this e s f national
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfNational.getUuid();
	}

	/**
	* Sets the uuid of this e s f national.
	*
	* @param uuid the uuid of this e s f national
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfNational.setUuid(uuid);
	}

	/**
	* Returns the esf national ID of this e s f national.
	*
	* @return the esf national ID of this e s f national
	*/
	@Override
	public long getEsfNationalId() {
		return _esfNational.getEsfNationalId();
	}

	/**
	* Sets the esf national ID of this e s f national.
	*
	* @param esfNationalId the esf national ID of this e s f national
	*/
	@Override
	public void setEsfNationalId(long esfNationalId) {
		_esfNational.setEsfNationalId(esfNationalId);
	}

	/**
	* Returns the group ID of this e s f national.
	*
	* @return the group ID of this e s f national
	*/
	@Override
	public long getGroupId() {
		return _esfNational.getGroupId();
	}

	/**
	* Sets the group ID of this e s f national.
	*
	* @param groupId the group ID of this e s f national
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfNational.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f national.
	*
	* @return the company ID of this e s f national
	*/
	@Override
	public long getCompanyId() {
		return _esfNational.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f national.
	*
	* @param companyId the company ID of this e s f national
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfNational.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f national.
	*
	* @return the user ID of this e s f national
	*/
	@Override
	public long getUserId() {
		return _esfNational.getUserId();
	}

	/**
	* Sets the user ID of this e s f national.
	*
	* @param userId the user ID of this e s f national
	*/
	@Override
	public void setUserId(long userId) {
		_esfNational.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f national.
	*
	* @return the user uuid of this e s f national
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNational.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f national.
	*
	* @param userUuid the user uuid of this e s f national
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfNational.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f national.
	*
	* @return the user name of this e s f national
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfNational.getUserName();
	}

	/**
	* Sets the user name of this e s f national.
	*
	* @param userName the user name of this e s f national
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfNational.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f national.
	*
	* @return the create date of this e s f national
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfNational.getCreateDate();
	}

	/**
	* Sets the create date of this e s f national.
	*
	* @param createDate the create date of this e s f national
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfNational.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f national.
	*
	* @return the modified date of this e s f national
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfNational.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f national.
	*
	* @param modifiedDate the modified date of this e s f national
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfNational.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf user ID of this e s f national.
	*
	* @return the esf user ID of this e s f national
	*/
	@Override
	public long getEsfUserId() {
		return _esfNational.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f national.
	*
	* @param esfUserId the esf user ID of this e s f national
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfNational.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f national.
	*
	* @return the esf user uuid of this e s f national
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNational.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f national.
	*
	* @param esfUserUuid the esf user uuid of this e s f national
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfNational.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf sport type ID of this e s f national.
	*
	* @return the esf sport type ID of this e s f national
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfNational.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f national.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f national
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfNational.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the start date of this e s f national.
	*
	* @return the start date of this e s f national
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfNational.getStartDate();
	}

	/**
	* Sets the start date of this e s f national.
	*
	* @param startDate the start date of this e s f national
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfNational.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f national.
	*
	* @return the end date of this e s f national
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfNational.getEndDate();
	}

	/**
	* Sets the end date of this e s f national.
	*
	* @param endDate the end date of this e s f national
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfNational.setEndDate(endDate);
	}

	/**
	* Returns the b d o date of this e s f national.
	*
	* @return the b d o date of this e s f national
	*/
	@Override
	public java.util.Date getBDODate() {
		return _esfNational.getBDODate();
	}

	/**
	* Sets the b d o date of this e s f national.
	*
	* @param BDODate the b d o date of this e s f national
	*/
	@Override
	public void setBDODate(java.util.Date BDODate) {
		_esfNational.setBDODate(BDODate);
	}

	/**
	* Returns the id international of this e s f national.
	*
	* @return the id international of this e s f national
	*/
	@Override
	public java.lang.String getIdInternational() {
		return _esfNational.getIdInternational();
	}

	/**
	* Sets the id international of this e s f national.
	*
	* @param idInternational the id international of this e s f national
	*/
	@Override
	public void setIdInternational(java.lang.String idInternational) {
		_esfNational.setIdInternational(idInternational);
	}

	/**
	* Returns the is university of this e s f national.
	*
	* @return the is university of this e s f national
	*/
	@Override
	public boolean getIsUniversity() {
		return _esfNational.getIsUniversity();
	}

	/**
	* Returns <code>true</code> if this e s f national is is university.
	*
	* @return <code>true</code> if this e s f national is is university; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsUniversity() {
		return _esfNational.isIsUniversity();
	}

	/**
	* Sets whether this e s f national is is university.
	*
	* @param isUniversity the is university of this e s f national
	*/
	@Override
	public void setIsUniversity(boolean isUniversity) {
		_esfNational.setIsUniversity(isUniversity);
	}

	/**
	* Returns the is national of this e s f national.
	*
	* @return the is national of this e s f national
	*/
	@Override
	public boolean getIsNational() {
		return _esfNational.getIsNational();
	}

	/**
	* Returns <code>true</code> if this e s f national is is national.
	*
	* @return <code>true</code> if this e s f national is is national; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNational() {
		return _esfNational.isIsNational();
	}

	/**
	* Sets whether this e s f national is is national.
	*
	* @param isNational the is national of this e s f national
	*/
	@Override
	public void setIsNational(boolean isNational) {
		_esfNational.setIsNational(isNational);
	}

	/**
	* Returns the deliberate of this e s f national.
	*
	* @return the deliberate of this e s f national
	*/
	@Override
	public java.lang.String getDeliberate() {
		return _esfNational.getDeliberate();
	}

	/**
	* Sets the deliberate of this e s f national.
	*
	* @param deliberate the deliberate of this e s f national
	*/
	@Override
	public void setDeliberate(java.lang.String deliberate) {
		_esfNational.setDeliberate(deliberate);
	}

	/**
	* Returns the deliberate date of this e s f national.
	*
	* @return the deliberate date of this e s f national
	*/
	@Override
	public java.util.Date getDeliberateDate() {
		return _esfNational.getDeliberateDate();
	}

	/**
	* Sets the deliberate date of this e s f national.
	*
	* @param deliberateDate the deliberate date of this e s f national
	*/
	@Override
	public void setDeliberateDate(java.util.Date deliberateDate) {
		_esfNational.setDeliberateDate(deliberateDate);
	}

	@Override
	public boolean isNew() {
		return _esfNational.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfNational.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfNational.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfNational.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfNational.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfNational.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfNational.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfNational.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfNational.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfNational.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfNational.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFNationalWrapper((ESFNational)_esfNational.clone());
	}

	@Override
	public int compareTo(ESFNational esfNational) {
		return _esfNational.compareTo(esfNational);
	}

	@Override
	public int hashCode() {
		return _esfNational.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFNational> toCacheModel() {
		return _esfNational.toCacheModel();
	}

	@Override
	public ESFNational toEscapedModel() {
		return new ESFNationalWrapper(_esfNational.toEscapedModel());
	}

	@Override
	public ESFNational toUnescapedModel() {
		return new ESFNationalWrapper(_esfNational.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfNational.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfNational.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfNational.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFNationalWrapper)) {
			return false;
		}

		ESFNationalWrapper esfNationalWrapper = (ESFNationalWrapper)obj;

		if (Validator.equals(_esfNational, esfNationalWrapper._esfNational)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfNational.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFNational getWrappedESFNational() {
		return _esfNational;
	}

	@Override
	public ESFNational getWrappedModel() {
		return _esfNational;
	}

	@Override
	public void resetOriginalValues() {
		_esfNational.resetOriginalValues();
	}

	private ESFNational _esfNational;
}