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
import it.ethica.esf.service.ESFFlightLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFlightClp extends BaseModelImpl<ESFFlight> implements ESFFlight {
	public ESFFlightClp() {
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
	public long getPrimaryKey() {
		return _esfFlightId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfFlightId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfFlightId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEsfFlightId() {
		return _esfFlightId;
	}

	@Override
	public void setEsfFlightId(long esfFlightId) {
		_esfFlightId = esfFlightId;

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFlightId", long.class);

				method.invoke(_esfFlightRemoteModel, esfFlightId);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfFlightRemoteModel, groupId);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfFlightRemoteModel, companyId);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfFlightRemoteModel, userId);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfFlightRemoteModel, userName);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfFlightRemoteModel, createDate);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfFlightRemoteModel, modifiedDate);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveDate", Date.class);

				method.invoke(_esfFlightRemoteModel, leaveDate);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveHour", String.class);

				method.invoke(_esfFlightRemoteModel, leaveHour);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setArriveDate", Date.class);

				method.invoke(_esfFlightRemoteModel, arriveDate);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setArriveHour", String.class);

				method.invoke(_esfFlightRemoteModel, arriveHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlightCode() {
		return _flightCode;
	}

	@Override
	public void setFlightCode(String flightCode) {
		_flightCode = flightCode;

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setFlightCode", String.class);

				method.invoke(_esfFlightRemoteModel, flightCode);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_esfFlightRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartureAirport() {
		return _departureAirport;
	}

	@Override
	public void setDepartureAirport(String departureAirport) {
		_departureAirport = departureAirport;

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartureAirport",
						String.class);

				method.invoke(_esfFlightRemoteModel, departureAirport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArrivalAirport() {
		return _arrivalAirport;
	}

	@Override
	public void setArrivalAirport(String arrivalAirport) {
		_arrivalAirport = arrivalAirport;

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setArrivalAirport",
						String.class);

				method.invoke(_esfFlightRemoteModel, arrivalAirport);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfFlightRemoteModel, esfMatchId);
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

		if (_esfFlightRemoteModel != null) {
			try {
				Class<?> clazz = _esfFlightRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfFlightRemoteModel, esfUserId);
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

	public BaseModel<?> getESFFlightRemoteModel() {
		return _esfFlightRemoteModel;
	}

	public void setESFFlightRemoteModel(BaseModel<?> esfFlightRemoteModel) {
		_esfFlightRemoteModel = esfFlightRemoteModel;
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

		Class<?> remoteModelClass = _esfFlightRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFlightRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFlightLocalServiceUtil.addESFFlight(this);
		}
		else {
			ESFFlightLocalServiceUtil.updateESFFlight(this);
		}
	}

	@Override
	public ESFFlight toEscapedModel() {
		return (ESFFlight)ProxyUtil.newProxyInstance(ESFFlight.class.getClassLoader(),
			new Class[] { ESFFlight.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFlightClp clone = new ESFFlightClp();

		clone.setEsfFlightId(getEsfFlightId());
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
		clone.setFlightCode(getFlightCode());
		clone.setCompanyName(getCompanyName());
		clone.setDepartureAirport(getDepartureAirport());
		clone.setArrivalAirport(getArrivalAirport());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfUserId(getEsfUserId());

		return clone;
	}

	@Override
	public int compareTo(ESFFlight esfFlight) {
		long primaryKey = esfFlight.getPrimaryKey();

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

		if (!(obj instanceof ESFFlightClp)) {
			return false;
		}

		ESFFlightClp esfFlight = (ESFFlightClp)obj;

		long primaryKey = esfFlight.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{esfFlightId=");
		sb.append(getEsfFlightId());
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
		sb.append(", flightCode=");
		sb.append(getFlightCode());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", departureAirport=");
		sb.append(getDepartureAirport());
		sb.append(", arrivalAirport=");
		sb.append(getArrivalAirport());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFlight");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfFlightId</column-name><column-value><![CDATA[");
		sb.append(getEsfFlightId());
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
			"<column><column-name>flightCode</column-name><column-value><![CDATA[");
		sb.append(getFlightCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departureAirport</column-name><column-value><![CDATA[");
		sb.append(getDepartureAirport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>arrivalAirport</column-name><column-value><![CDATA[");
		sb.append(getArrivalAirport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfFlightId;
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
	private String _flightCode;
	private String _companyName;
	private String _departureAirport;
	private String _arrivalAirport;
	private long _esfMatchId;
	private long _esfUserId;
	private String _esfUserUuid;
	private BaseModel<?> _esfFlightRemoteModel;
}