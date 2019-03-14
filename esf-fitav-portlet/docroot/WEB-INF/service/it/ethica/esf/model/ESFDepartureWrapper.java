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
 * This class is a wrapper for {@link ESFDeparture}.
 * </p>
 *
 * @author Ethica
 * @see ESFDeparture
 * @generated
 */
public class ESFDepartureWrapper implements ESFDeparture,
	ModelWrapper<ESFDeparture> {
	public ESFDepartureWrapper(ESFDeparture esfDeparture) {
		_esfDeparture = esfDeparture;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDeparture.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDeparture.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDepartureId", getEsfDepartureId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveDate", getLeaveDate());
		attributes.put("leaveHour", getLeaveHour());
		attributes.put("arriveDate", getArriveDate());
		attributes.put("arriveHour", getArriveHour());
		attributes.put("code", getCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("departureFrom", getDepartureFrom());
		attributes.put("arrivalTo", getArrivalTo());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("isReturn", getIsReturn());
		attributes.put("meetingPlace", getMeetingPlace());
		attributes.put("typeTravel", getTypeTravel());
		attributes.put("stopoverId", getStopoverId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDepartureId = (Long)attributes.get("esfDepartureId");

		if (esfDepartureId != null) {
			setEsfDepartureId(esfDepartureId);
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

		String leaveHour = (String)attributes.get("leaveHour");

		if (leaveHour != null) {
			setLeaveHour(leaveHour);
		}

		Date arriveDate = (Date)attributes.get("arriveDate");

		if (arriveDate != null) {
			setArriveDate(arriveDate);
		}

		String arriveHour = (String)attributes.get("arriveHour");

		if (arriveHour != null) {
			setArriveHour(arriveHour);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String departureFrom = (String)attributes.get("departureFrom");

		if (departureFrom != null) {
			setDepartureFrom(departureFrom);
		}

		String arrivalTo = (String)attributes.get("arrivalTo");

		if (arrivalTo != null) {
			setArrivalTo(arrivalTo);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Boolean isReturn = (Boolean)attributes.get("isReturn");

		if (isReturn != null) {
			setIsReturn(isReturn);
		}

		String meetingPlace = (String)attributes.get("meetingPlace");

		if (meetingPlace != null) {
			setMeetingPlace(meetingPlace);
		}

		String typeTravel = (String)attributes.get("typeTravel");

		if (typeTravel != null) {
			setTypeTravel(typeTravel);
		}

		String stopoverId = (String)attributes.get("stopoverId");

		if (stopoverId != null) {
			setStopoverId(stopoverId);
		}
	}

	/**
	* Returns the primary key of this e s f departure.
	*
	* @return the primary key of this e s f departure
	*/
	@Override
	public long getPrimaryKey() {
		return _esfDeparture.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f departure.
	*
	* @param primaryKey the primary key of this e s f departure
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfDeparture.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf departure ID of this e s f departure.
	*
	* @return the esf departure ID of this e s f departure
	*/
	@Override
	public long getEsfDepartureId() {
		return _esfDeparture.getEsfDepartureId();
	}

	/**
	* Sets the esf departure ID of this e s f departure.
	*
	* @param esfDepartureId the esf departure ID of this e s f departure
	*/
	@Override
	public void setEsfDepartureId(long esfDepartureId) {
		_esfDeparture.setEsfDepartureId(esfDepartureId);
	}

	/**
	* Returns the group ID of this e s f departure.
	*
	* @return the group ID of this e s f departure
	*/
	@Override
	public long getGroupId() {
		return _esfDeparture.getGroupId();
	}

	/**
	* Sets the group ID of this e s f departure.
	*
	* @param groupId the group ID of this e s f departure
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfDeparture.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f departure.
	*
	* @return the company ID of this e s f departure
	*/
	@Override
	public long getCompanyId() {
		return _esfDeparture.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f departure.
	*
	* @param companyId the company ID of this e s f departure
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfDeparture.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f departure.
	*
	* @return the user ID of this e s f departure
	*/
	@Override
	public long getUserId() {
		return _esfDeparture.getUserId();
	}

	/**
	* Sets the user ID of this e s f departure.
	*
	* @param userId the user ID of this e s f departure
	*/
	@Override
	public void setUserId(long userId) {
		_esfDeparture.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f departure.
	*
	* @return the user uuid of this e s f departure
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDeparture.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f departure.
	*
	* @param userUuid the user uuid of this e s f departure
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfDeparture.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f departure.
	*
	* @return the user name of this e s f departure
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfDeparture.getUserName();
	}

	/**
	* Sets the user name of this e s f departure.
	*
	* @param userName the user name of this e s f departure
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfDeparture.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f departure.
	*
	* @return the create date of this e s f departure
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfDeparture.getCreateDate();
	}

	/**
	* Sets the create date of this e s f departure.
	*
	* @param createDate the create date of this e s f departure
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfDeparture.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f departure.
	*
	* @return the modified date of this e s f departure
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfDeparture.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f departure.
	*
	* @param modifiedDate the modified date of this e s f departure
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfDeparture.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the leave date of this e s f departure.
	*
	* @return the leave date of this e s f departure
	*/
	@Override
	public java.util.Date getLeaveDate() {
		return _esfDeparture.getLeaveDate();
	}

	/**
	* Sets the leave date of this e s f departure.
	*
	* @param leaveDate the leave date of this e s f departure
	*/
	@Override
	public void setLeaveDate(java.util.Date leaveDate) {
		_esfDeparture.setLeaveDate(leaveDate);
	}

	/**
	* Returns the leave hour of this e s f departure.
	*
	* @return the leave hour of this e s f departure
	*/
	@Override
	public java.lang.String getLeaveHour() {
		return _esfDeparture.getLeaveHour();
	}

	/**
	* Sets the leave hour of this e s f departure.
	*
	* @param leaveHour the leave hour of this e s f departure
	*/
	@Override
	public void setLeaveHour(java.lang.String leaveHour) {
		_esfDeparture.setLeaveHour(leaveHour);
	}

	/**
	* Returns the arrive date of this e s f departure.
	*
	* @return the arrive date of this e s f departure
	*/
	@Override
	public java.util.Date getArriveDate() {
		return _esfDeparture.getArriveDate();
	}

	/**
	* Sets the arrive date of this e s f departure.
	*
	* @param arriveDate the arrive date of this e s f departure
	*/
	@Override
	public void setArriveDate(java.util.Date arriveDate) {
		_esfDeparture.setArriveDate(arriveDate);
	}

	/**
	* Returns the arrive hour of this e s f departure.
	*
	* @return the arrive hour of this e s f departure
	*/
	@Override
	public java.lang.String getArriveHour() {
		return _esfDeparture.getArriveHour();
	}

	/**
	* Sets the arrive hour of this e s f departure.
	*
	* @param arriveHour the arrive hour of this e s f departure
	*/
	@Override
	public void setArriveHour(java.lang.String arriveHour) {
		_esfDeparture.setArriveHour(arriveHour);
	}

	/**
	* Returns the code of this e s f departure.
	*
	* @return the code of this e s f departure
	*/
	@Override
	public java.lang.String getCode() {
		return _esfDeparture.getCode();
	}

	/**
	* Sets the code of this e s f departure.
	*
	* @param code the code of this e s f departure
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfDeparture.setCode(code);
	}

	/**
	* Returns the company name of this e s f departure.
	*
	* @return the company name of this e s f departure
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _esfDeparture.getCompanyName();
	}

	/**
	* Sets the company name of this e s f departure.
	*
	* @param companyName the company name of this e s f departure
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_esfDeparture.setCompanyName(companyName);
	}

	/**
	* Returns the departure from of this e s f departure.
	*
	* @return the departure from of this e s f departure
	*/
	@Override
	public java.lang.String getDepartureFrom() {
		return _esfDeparture.getDepartureFrom();
	}

	/**
	* Sets the departure from of this e s f departure.
	*
	* @param departureFrom the departure from of this e s f departure
	*/
	@Override
	public void setDepartureFrom(java.lang.String departureFrom) {
		_esfDeparture.setDepartureFrom(departureFrom);
	}

	/**
	* Returns the arrival to of this e s f departure.
	*
	* @return the arrival to of this e s f departure
	*/
	@Override
	public java.lang.String getArrivalTo() {
		return _esfDeparture.getArrivalTo();
	}

	/**
	* Sets the arrival to of this e s f departure.
	*
	* @param arrivalTo the arrival to of this e s f departure
	*/
	@Override
	public void setArrivalTo(java.lang.String arrivalTo) {
		_esfDeparture.setArrivalTo(arrivalTo);
	}

	/**
	* Returns the esf match ID of this e s f departure.
	*
	* @return the esf match ID of this e s f departure
	*/
	@Override
	public long getEsfMatchId() {
		return _esfDeparture.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f departure.
	*
	* @param esfMatchId the esf match ID of this e s f departure
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfDeparture.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf user ID of this e s f departure.
	*
	* @return the esf user ID of this e s f departure
	*/
	@Override
	public long getEsfUserId() {
		return _esfDeparture.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f departure.
	*
	* @param esfUserId the esf user ID of this e s f departure
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfDeparture.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f departure.
	*
	* @return the esf user uuid of this e s f departure
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDeparture.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f departure.
	*
	* @param esfUserUuid the esf user uuid of this e s f departure
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfDeparture.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the is return of this e s f departure.
	*
	* @return the is return of this e s f departure
	*/
	@Override
	public boolean getIsReturn() {
		return _esfDeparture.getIsReturn();
	}

	/**
	* Returns <code>true</code> if this e s f departure is is return.
	*
	* @return <code>true</code> if this e s f departure is is return; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsReturn() {
		return _esfDeparture.isIsReturn();
	}

	/**
	* Sets whether this e s f departure is is return.
	*
	* @param isReturn the is return of this e s f departure
	*/
	@Override
	public void setIsReturn(boolean isReturn) {
		_esfDeparture.setIsReturn(isReturn);
	}

	/**
	* Returns the meeting place of this e s f departure.
	*
	* @return the meeting place of this e s f departure
	*/
	@Override
	public java.lang.String getMeetingPlace() {
		return _esfDeparture.getMeetingPlace();
	}

	/**
	* Sets the meeting place of this e s f departure.
	*
	* @param meetingPlace the meeting place of this e s f departure
	*/
	@Override
	public void setMeetingPlace(java.lang.String meetingPlace) {
		_esfDeparture.setMeetingPlace(meetingPlace);
	}

	/**
	* Returns the type travel of this e s f departure.
	*
	* @return the type travel of this e s f departure
	*/
	@Override
	public java.lang.String getTypeTravel() {
		return _esfDeparture.getTypeTravel();
	}

	/**
	* Sets the type travel of this e s f departure.
	*
	* @param typeTravel the type travel of this e s f departure
	*/
	@Override
	public void setTypeTravel(java.lang.String typeTravel) {
		_esfDeparture.setTypeTravel(typeTravel);
	}

	/**
	* Returns the stopover ID of this e s f departure.
	*
	* @return the stopover ID of this e s f departure
	*/
	@Override
	public java.lang.String getStopoverId() {
		return _esfDeparture.getStopoverId();
	}

	/**
	* Sets the stopover ID of this e s f departure.
	*
	* @param stopoverId the stopover ID of this e s f departure
	*/
	@Override
	public void setStopoverId(java.lang.String stopoverId) {
		_esfDeparture.setStopoverId(stopoverId);
	}

	@Override
	public boolean isNew() {
		return _esfDeparture.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfDeparture.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfDeparture.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfDeparture.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfDeparture.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfDeparture.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfDeparture.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfDeparture.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfDeparture.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfDeparture.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfDeparture.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFDepartureWrapper((ESFDeparture)_esfDeparture.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFDeparture esfDeparture) {
		return _esfDeparture.compareTo(esfDeparture);
	}

	@Override
	public int hashCode() {
		return _esfDeparture.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFDeparture> toCacheModel() {
		return _esfDeparture.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFDeparture toEscapedModel() {
		return new ESFDepartureWrapper(_esfDeparture.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFDeparture toUnescapedModel() {
		return new ESFDepartureWrapper(_esfDeparture.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfDeparture.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfDeparture.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfDeparture.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFDepartureWrapper)) {
			return false;
		}

		ESFDepartureWrapper esfDepartureWrapper = (ESFDepartureWrapper)obj;

		if (Validator.equals(_esfDeparture, esfDepartureWrapper._esfDeparture)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFDeparture getWrappedESFDeparture() {
		return _esfDeparture;
	}

	@Override
	public ESFDeparture getWrappedModel() {
		return _esfDeparture;
	}

	@Override
	public void resetOriginalValues() {
		_esfDeparture.resetOriginalValues();
	}

	private ESFDeparture _esfDeparture;
}