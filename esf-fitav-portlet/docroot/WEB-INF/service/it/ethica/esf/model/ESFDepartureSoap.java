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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFDepartureSoap implements Serializable {
	public static ESFDepartureSoap toSoapModel(ESFDeparture model) {
		ESFDepartureSoap soapModel = new ESFDepartureSoap();

		soapModel.setEsfDepartureId(model.getEsfDepartureId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeaveDate(model.getLeaveDate());
		soapModel.setLeaveHour(model.getLeaveHour());
		soapModel.setArriveDate(model.getArriveDate());
		soapModel.setArriveHour(model.getArriveHour());
		soapModel.setCode(model.getCode());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setDepartureFrom(model.getDepartureFrom());
		soapModel.setArrivalTo(model.getArrivalTo());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setIsReturn(model.getIsReturn());
		soapModel.setMeetingPlace(model.getMeetingPlace());
		soapModel.setTypeTravel(model.getTypeTravel());
		soapModel.setStopoverId(model.getStopoverId());

		return soapModel;
	}

	public static ESFDepartureSoap[] toSoapModels(ESFDeparture[] models) {
		ESFDepartureSoap[] soapModels = new ESFDepartureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFDepartureSoap[][] toSoapModels(ESFDeparture[][] models) {
		ESFDepartureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFDepartureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFDepartureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFDepartureSoap[] toSoapModels(List<ESFDeparture> models) {
		List<ESFDepartureSoap> soapModels = new ArrayList<ESFDepartureSoap>(models.size());

		for (ESFDeparture model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFDepartureSoap[soapModels.size()]);
	}

	public ESFDepartureSoap() {
	}

	public long getPrimaryKey() {
		return _esfDepartureId;
	}

	public void setPrimaryKey(long pk) {
		setEsfDepartureId(pk);
	}

	public long getEsfDepartureId() {
		return _esfDepartureId;
	}

	public void setEsfDepartureId(long esfDepartureId) {
		_esfDepartureId = esfDepartureId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getLeaveDate() {
		return _leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		_leaveDate = leaveDate;
	}

	public String getLeaveHour() {
		return _leaveHour;
	}

	public void setLeaveHour(String leaveHour) {
		_leaveHour = leaveHour;
	}

	public Date getArriveDate() {
		return _arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		_arriveDate = arriveDate;
	}

	public String getArriveHour() {
		return _arriveHour;
	}

	public void setArriveHour(String arriveHour) {
		_arriveHour = arriveHour;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getDepartureFrom() {
		return _departureFrom;
	}

	public void setDepartureFrom(String departureFrom) {
		_departureFrom = departureFrom;
	}

	public String getArrivalTo() {
		return _arrivalTo;
	}

	public void setArrivalTo(String arrivalTo) {
		_arrivalTo = arrivalTo;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public boolean getIsReturn() {
		return _isReturn;
	}

	public boolean isIsReturn() {
		return _isReturn;
	}

	public void setIsReturn(boolean isReturn) {
		_isReturn = isReturn;
	}

	public String getMeetingPlace() {
		return _meetingPlace;
	}

	public void setMeetingPlace(String meetingPlace) {
		_meetingPlace = meetingPlace;
	}

	public String getTypeTravel() {
		return _typeTravel;
	}

	public void setTypeTravel(String typeTravel) {
		_typeTravel = typeTravel;
	}

	public String getStopoverId() {
		return _stopoverId;
	}

	public void setStopoverId(String stopoverId) {
		_stopoverId = stopoverId;
	}

	private long _esfDepartureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _leaveDate;
	private String _leaveHour;
	private Date _arriveDate;
	private String _arriveHour;
	private String _code;
	private String _companyName;
	private String _departureFrom;
	private String _arrivalTo;
	private long _esfMatchId;
	private long _esfUserId;
	private boolean _isReturn;
	private String _meetingPlace;
	private String _typeTravel;
	private String _stopoverId;
}