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
 * This class is a wrapper for {@link ESFFlight}.
 * </p>
 *
 * @author Ethica
 * @see ESFFlight
 * @generated
 */
public class ESFFlightWrapper implements ESFFlight, ModelWrapper<ESFFlight> {
	public ESFFlightWrapper(ESFFlight esfFlight) {
		_esfFlight = esfFlight;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFlight.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFlight.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfFlightId", getEsfFlightId());
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
		attributes.put("flightCode", getFlightCode());
		attributes.put("companyName", getCompanyName());
		attributes.put("departureAirport", getDepartureAirport());
		attributes.put("arrivalAirport", getArrivalAirport());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfUserId", getEsfUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfFlightId = (Long)attributes.get("esfFlightId");

		if (esfFlightId != null) {
			setEsfFlightId(esfFlightId);
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

		String flightCode = (String)attributes.get("flightCode");

		if (flightCode != null) {
			setFlightCode(flightCode);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String departureAirport = (String)attributes.get("departureAirport");

		if (departureAirport != null) {
			setDepartureAirport(departureAirport);
		}

		String arrivalAirport = (String)attributes.get("arrivalAirport");

		if (arrivalAirport != null) {
			setArrivalAirport(arrivalAirport);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}
	}

	/**
	* Returns the primary key of this e s f flight.
	*
	* @return the primary key of this e s f flight
	*/
	@Override
	public long getPrimaryKey() {
		return _esfFlight.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f flight.
	*
	* @param primaryKey the primary key of this e s f flight
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfFlight.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf flight ID of this e s f flight.
	*
	* @return the esf flight ID of this e s f flight
	*/
	@Override
	public long getEsfFlightId() {
		return _esfFlight.getEsfFlightId();
	}

	/**
	* Sets the esf flight ID of this e s f flight.
	*
	* @param esfFlightId the esf flight ID of this e s f flight
	*/
	@Override
	public void setEsfFlightId(long esfFlightId) {
		_esfFlight.setEsfFlightId(esfFlightId);
	}

	/**
	* Returns the group ID of this e s f flight.
	*
	* @return the group ID of this e s f flight
	*/
	@Override
	public long getGroupId() {
		return _esfFlight.getGroupId();
	}

	/**
	* Sets the group ID of this e s f flight.
	*
	* @param groupId the group ID of this e s f flight
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfFlight.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f flight.
	*
	* @return the company ID of this e s f flight
	*/
	@Override
	public long getCompanyId() {
		return _esfFlight.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f flight.
	*
	* @param companyId the company ID of this e s f flight
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfFlight.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f flight.
	*
	* @return the user ID of this e s f flight
	*/
	@Override
	public long getUserId() {
		return _esfFlight.getUserId();
	}

	/**
	* Sets the user ID of this e s f flight.
	*
	* @param userId the user ID of this e s f flight
	*/
	@Override
	public void setUserId(long userId) {
		_esfFlight.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f flight.
	*
	* @return the user uuid of this e s f flight
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlight.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f flight.
	*
	* @param userUuid the user uuid of this e s f flight
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfFlight.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f flight.
	*
	* @return the user name of this e s f flight
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfFlight.getUserName();
	}

	/**
	* Sets the user name of this e s f flight.
	*
	* @param userName the user name of this e s f flight
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfFlight.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f flight.
	*
	* @return the create date of this e s f flight
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfFlight.getCreateDate();
	}

	/**
	* Sets the create date of this e s f flight.
	*
	* @param createDate the create date of this e s f flight
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfFlight.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f flight.
	*
	* @return the modified date of this e s f flight
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfFlight.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f flight.
	*
	* @param modifiedDate the modified date of this e s f flight
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfFlight.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the leave date of this e s f flight.
	*
	* @return the leave date of this e s f flight
	*/
	@Override
	public java.util.Date getLeaveDate() {
		return _esfFlight.getLeaveDate();
	}

	/**
	* Sets the leave date of this e s f flight.
	*
	* @param leaveDate the leave date of this e s f flight
	*/
	@Override
	public void setLeaveDate(java.util.Date leaveDate) {
		_esfFlight.setLeaveDate(leaveDate);
	}

	/**
	* Returns the leave hour of this e s f flight.
	*
	* @return the leave hour of this e s f flight
	*/
	@Override
	public java.lang.String getLeaveHour() {
		return _esfFlight.getLeaveHour();
	}

	/**
	* Sets the leave hour of this e s f flight.
	*
	* @param leaveHour the leave hour of this e s f flight
	*/
	@Override
	public void setLeaveHour(java.lang.String leaveHour) {
		_esfFlight.setLeaveHour(leaveHour);
	}

	/**
	* Returns the arrive date of this e s f flight.
	*
	* @return the arrive date of this e s f flight
	*/
	@Override
	public java.util.Date getArriveDate() {
		return _esfFlight.getArriveDate();
	}

	/**
	* Sets the arrive date of this e s f flight.
	*
	* @param arriveDate the arrive date of this e s f flight
	*/
	@Override
	public void setArriveDate(java.util.Date arriveDate) {
		_esfFlight.setArriveDate(arriveDate);
	}

	/**
	* Returns the arrive hour of this e s f flight.
	*
	* @return the arrive hour of this e s f flight
	*/
	@Override
	public java.lang.String getArriveHour() {
		return _esfFlight.getArriveHour();
	}

	/**
	* Sets the arrive hour of this e s f flight.
	*
	* @param arriveHour the arrive hour of this e s f flight
	*/
	@Override
	public void setArriveHour(java.lang.String arriveHour) {
		_esfFlight.setArriveHour(arriveHour);
	}

	/**
	* Returns the flight code of this e s f flight.
	*
	* @return the flight code of this e s f flight
	*/
	@Override
	public java.lang.String getFlightCode() {
		return _esfFlight.getFlightCode();
	}

	/**
	* Sets the flight code of this e s f flight.
	*
	* @param flightCode the flight code of this e s f flight
	*/
	@Override
	public void setFlightCode(java.lang.String flightCode) {
		_esfFlight.setFlightCode(flightCode);
	}

	/**
	* Returns the company name of this e s f flight.
	*
	* @return the company name of this e s f flight
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _esfFlight.getCompanyName();
	}

	/**
	* Sets the company name of this e s f flight.
	*
	* @param companyName the company name of this e s f flight
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_esfFlight.setCompanyName(companyName);
	}

	/**
	* Returns the departure airport of this e s f flight.
	*
	* @return the departure airport of this e s f flight
	*/
	@Override
	public java.lang.String getDepartureAirport() {
		return _esfFlight.getDepartureAirport();
	}

	/**
	* Sets the departure airport of this e s f flight.
	*
	* @param departureAirport the departure airport of this e s f flight
	*/
	@Override
	public void setDepartureAirport(java.lang.String departureAirport) {
		_esfFlight.setDepartureAirport(departureAirport);
	}

	/**
	* Returns the arrival airport of this e s f flight.
	*
	* @return the arrival airport of this e s f flight
	*/
	@Override
	public java.lang.String getArrivalAirport() {
		return _esfFlight.getArrivalAirport();
	}

	/**
	* Sets the arrival airport of this e s f flight.
	*
	* @param arrivalAirport the arrival airport of this e s f flight
	*/
	@Override
	public void setArrivalAirport(java.lang.String arrivalAirport) {
		_esfFlight.setArrivalAirport(arrivalAirport);
	}

	/**
	* Returns the esf match ID of this e s f flight.
	*
	* @return the esf match ID of this e s f flight
	*/
	@Override
	public long getEsfMatchId() {
		return _esfFlight.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f flight.
	*
	* @param esfMatchId the esf match ID of this e s f flight
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfFlight.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf user ID of this e s f flight.
	*
	* @return the esf user ID of this e s f flight
	*/
	@Override
	public long getEsfUserId() {
		return _esfFlight.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f flight.
	*
	* @param esfUserId the esf user ID of this e s f flight
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfFlight.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f flight.
	*
	* @return the esf user uuid of this e s f flight
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlight.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f flight.
	*
	* @param esfUserUuid the esf user uuid of this e s f flight
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfFlight.setEsfUserUuid(esfUserUuid);
	}

	@Override
	public boolean isNew() {
		return _esfFlight.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFlight.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFlight.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFlight.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFlight.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFlight.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFlight.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFlight.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFlight.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFlight.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFlight.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFlightWrapper((ESFFlight)_esfFlight.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFFlight esfFlight) {
		return _esfFlight.compareTo(esfFlight);
	}

	@Override
	public int hashCode() {
		return _esfFlight.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFlight> toCacheModel() {
		return _esfFlight.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFlight toEscapedModel() {
		return new ESFFlightWrapper(_esfFlight.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFlight toUnescapedModel() {
		return new ESFFlightWrapper(_esfFlight.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFlight.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFlight.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFlight.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFlightWrapper)) {
			return false;
		}

		ESFFlightWrapper esfFlightWrapper = (ESFFlightWrapper)obj;

		if (Validator.equals(_esfFlight, esfFlightWrapper._esfFlight)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFlight getWrappedESFFlight() {
		return _esfFlight;
	}

	@Override
	public ESFFlight getWrappedModel() {
		return _esfFlight;
	}

	@Override
	public void resetOriginalValues() {
		_esfFlight.resetOriginalValues();
	}

	private ESFFlight _esfFlight;
}