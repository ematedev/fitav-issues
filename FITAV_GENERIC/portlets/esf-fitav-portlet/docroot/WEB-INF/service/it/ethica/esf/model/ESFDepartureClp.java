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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFDepartureLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFDepartureClp extends BaseModelImpl<ESFDeparture>
	implements ESFDeparture {
	public ESFDepartureClp() {
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
	public long getPrimaryKey() {
		return _esfDepartureId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDepartureId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDepartureId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEsfDepartureId() {
		return _esfDepartureId;
	}

	@Override
	public void setEsfDepartureId(long esfDepartureId) {
		_esfDepartureId = esfDepartureId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDepartureId", long.class);

				method.invoke(_esfDepartureRemoteModel, esfDepartureId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfDepartureRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfDepartureRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfDepartureRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfDepartureRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfDepartureRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfDepartureRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLeaveDate() {
		return _leaveDate;
	}

	@Override
	public void setLeaveDate(Date leaveDate) {
		_leaveDate = leaveDate;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveDate", Date.class);

				method.invoke(_esfDepartureRemoteModel, leaveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveHour() {
		return _leaveHour;
	}

	@Override
	public void setLeaveHour(String leaveHour) {
		_leaveHour = leaveHour;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveHour", String.class);

				method.invoke(_esfDepartureRemoteModel, leaveHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getArriveDate() {
		return _arriveDate;
	}

	@Override
	public void setArriveDate(Date arriveDate) {
		_arriveDate = arriveDate;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setArriveDate", Date.class);

				method.invoke(_esfDepartureRemoteModel, arriveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArriveHour() {
		return _arriveHour;
	}

	@Override
	public void setArriveHour(String arriveHour) {
		_arriveHour = arriveHour;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setArriveHour", String.class);

				method.invoke(_esfDepartureRemoteModel, arriveHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfDepartureRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_esfDepartureRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartureFrom() {
		return _departureFrom;
	}

	@Override
	public void setDepartureFrom(String departureFrom) {
		_departureFrom = departureFrom;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureFrom", String.class);

				method.invoke(_esfDepartureRemoteModel, departureFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArrivalTo() {
		return _arrivalTo;
	}

	@Override
	public void setArrivalTo(String arrivalTo) {
		_arrivalTo = arrivalTo;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setArrivalTo", String.class);

				method.invoke(_esfDepartureRemoteModel, arrivalTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfDepartureRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfDepartureRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public boolean getIsReturn() {
		return _isReturn;
	}

	@Override
	public boolean isIsReturn() {
		return _isReturn;
	}

	@Override
	public void setIsReturn(boolean isReturn) {
		_isReturn = isReturn;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setIsReturn", boolean.class);

				method.invoke(_esfDepartureRemoteModel, isReturn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeetingPlace() {
		return _meetingPlace;
	}

	@Override
	public void setMeetingPlace(String meetingPlace) {
		_meetingPlace = meetingPlace;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setMeetingPlace", String.class);

				method.invoke(_esfDepartureRemoteModel, meetingPlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeTravel() {
		return _typeTravel;
	}

	@Override
	public void setTypeTravel(String typeTravel) {
		_typeTravel = typeTravel;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeTravel", String.class);

				method.invoke(_esfDepartureRemoteModel, typeTravel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStopoverId() {
		return _stopoverId;
	}

	@Override
	public void setStopoverId(String stopoverId) {
		_stopoverId = stopoverId;

		if (_esfDepartureRemoteModel != null) {
			try {
				Class<?> clazz = _esfDepartureRemoteModel.getClass();

				Method method = clazz.getMethod("setStopoverId", String.class);

				method.invoke(_esfDepartureRemoteModel, stopoverId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFDepartureRemoteModel() {
		return _esfDepartureRemoteModel;
	}

	public void setESFDepartureRemoteModel(BaseModel<?> esfDepartureRemoteModel) {
		_esfDepartureRemoteModel = esfDepartureRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfDepartureRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfDepartureRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFDepartureLocalServiceUtil.addESFDeparture(this);
		}
		else {
			ESFDepartureLocalServiceUtil.updateESFDeparture(this);
		}
	}

	@Override
	public ESFDeparture toEscapedModel() {
		return (ESFDeparture)ProxyUtil.newProxyInstance(ESFDeparture.class.getClassLoader(),
			new Class[] { ESFDeparture.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFDepartureClp clone = new ESFDepartureClp();

		clone.setEsfDepartureId(getEsfDepartureId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLeaveDate(getLeaveDate());
		clone.setLeaveHour(getLeaveHour());
		clone.setArriveDate(getArriveDate());
		clone.setArriveHour(getArriveHour());
		clone.setCode(getCode());
		clone.setCompanyName(getCompanyName());
		clone.setDepartureFrom(getDepartureFrom());
		clone.setArrivalTo(getArrivalTo());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfUserId(getEsfUserId());
		clone.setIsReturn(getIsReturn());
		clone.setMeetingPlace(getMeetingPlace());
		clone.setTypeTravel(getTypeTravel());
		clone.setStopoverId(getStopoverId());

		return clone;
	}

	@Override
	public int compareTo(ESFDeparture esfDeparture) {
		long primaryKey = esfDeparture.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFDepartureClp)) {
			return false;
		}

		ESFDepartureClp esfDeparture = (ESFDepartureClp)obj;

		long primaryKey = esfDeparture.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{esfDepartureId=");
		sb.append(getEsfDepartureId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", leaveDate=");
		sb.append(getLeaveDate());
		sb.append(", leaveHour=");
		sb.append(getLeaveHour());
		sb.append(", arriveDate=");
		sb.append(getArriveDate());
		sb.append(", arriveHour=");
		sb.append(getArriveHour());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", departureFrom=");
		sb.append(getDepartureFrom());
		sb.append(", arrivalTo=");
		sb.append(getArrivalTo());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", isReturn=");
		sb.append(getIsReturn());
		sb.append(", meetingPlace=");
		sb.append(getMeetingPlace());
		sb.append(", typeTravel=");
		sb.append(getTypeTravel());
		sb.append(", stopoverId=");
		sb.append(getStopoverId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDeparture");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDepartureId</column-name><column-value><![CDATA[");
		sb.append(getEsfDepartureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveDate</column-name><column-value><![CDATA[");
		sb.append(getLeaveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveHour</column-name><column-value><![CDATA[");
		sb.append(getLeaveHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arriveDate</column-name><column-value><![CDATA[");
		sb.append(getArriveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arriveHour</column-name><column-value><![CDATA[");
		sb.append(getArriveHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureFrom</column-name><column-value><![CDATA[");
		sb.append(getDepartureFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arrivalTo</column-name><column-value><![CDATA[");
		sb.append(getArrivalTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isReturn</column-name><column-value><![CDATA[");
		sb.append(getIsReturn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetingPlace</column-name><column-value><![CDATA[");
		sb.append(getMeetingPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeTravel</column-name><column-value><![CDATA[");
		sb.append(getTypeTravel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stopoverId</column-name><column-value><![CDATA[");
		sb.append(getStopoverId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfDepartureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private String _esfUserUuid;
	private boolean _isReturn;
	private String _meetingPlace;
	private String _typeTravel;
	private String _stopoverId;
	private BaseModel<?> _esfDepartureRemoteModel;
}