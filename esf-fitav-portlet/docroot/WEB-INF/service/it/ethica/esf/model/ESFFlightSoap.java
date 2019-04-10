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
public class ESFFlightSoap implements Serializable {
	public static ESFFlightSoap toSoapModel(ESFFlight model) {
		ESFFlightSoap soapModel = new ESFFlightSoap();

		soapModel.setEsfFlightId(model.getEsfFlightId());
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
		soapModel.setFlightCode(model.getFlightCode());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setDepartureAirport(model.getDepartureAirport());
		soapModel.setArrivalAirport(model.getArrivalAirport());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfUserId(model.getEsfUserId());

		return soapModel;
	}

	public static ESFFlightSoap[] toSoapModels(ESFFlight[] models) {
		ESFFlightSoap[] soapModels = new ESFFlightSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFlightSoap[][] toSoapModels(ESFFlight[][] models) {
		ESFFlightSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFlightSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFlightSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFlightSoap[] toSoapModels(List<ESFFlight> models) {
		List<ESFFlightSoap> soapModels = new ArrayList<ESFFlightSoap>(models.size());

		for (ESFFlight model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFlightSoap[soapModels.size()]);
	}

	public ESFFlightSoap() {
	}

	public long getPrimaryKey() {
		return _esfFlightId;
	}

	public void setPrimaryKey(long pk) {
		setEsfFlightId(pk);
	}

	public long getEsfFlightId() {
		return _esfFlightId;
	}

	public void setEsfFlightId(long esfFlightId) {
		_esfFlightId = esfFlightId;
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

	public String getFlightCode() {
		return _flightCode;
	}

	public void setFlightCode(String flightCode) {
		_flightCode = flightCode;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getDepartureAirport() {
		return _departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		_departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return _arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		_arrivalAirport = arrivalAirport;
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

	private long _esfFlightId;
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
	private String _flightCode;
	private String _companyName;
	private String _departureAirport;
	private String _arrivalAirport;
	private long _esfMatchId;
	private long _esfUserId;
}