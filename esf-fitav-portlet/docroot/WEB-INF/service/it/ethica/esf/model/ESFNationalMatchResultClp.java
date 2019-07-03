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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFNationalMatchResultClp extends BaseModelImpl<ESFNationalMatchResult>
	implements ESFNationalMatchResult {
	public ESFNationalMatchResultClp() {
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
	public long getPrimaryKey() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfNationalMatchResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEsfNationalMatchResultId() {
		return _esfNationalMatchResultId;
	}

	@Override
	public void setEsfNationalMatchResultId(long esfNationalMatchResultId) {
		_esfNationalMatchResultId = esfNationalMatchResultId;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfNationalMatchResultId",
						long.class);

				method.invoke(_esfNationalMatchResultRemoteModel,
					esfNationalMatchResultId);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, groupId);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, companyId);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, userId);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfNationalMatchResultRemoteModel, userName);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfNationalMatchResultRemoteModel, createDate);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfNationalMatchResultRemoteModel, modifiedDate);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, esfMatchId);
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

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, esfUserId);
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
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_position = position;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setPosition", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel, position);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQualification() {
		return _qualification;
	}

	@Override
	public void setQualification(int qualification) {
		_qualification = qualification;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setQualification", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel, qualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOff() {
		return _shootOff;
	}

	@Override
	public void setShootOff(int shootOff) {
		_shootOff = shootOff;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOff", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel, shootOff);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getClayPigeonTotal() {
		return _clayPigeonTotal;
	}

	@Override
	public void setClayPigeonTotal(int clayPigeonTotal) {
		_clayPigeonTotal = clayPigeonTotal;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setClayPigeonTotal", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel,
					clayPigeonTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFinalResult() {
		return _finalResult;
	}

	@Override
	public void setFinalResult(int finalResult) {
		_finalResult = finalResult;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalResult", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel, finalResult);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getShootOffFinal() {
		return _shootOffFinal;
	}

	@Override
	public void setShootOffFinal(int shootOffFinal) {
		_shootOffFinal = shootOffFinal;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setShootOffFinal", int.class);

				method.invoke(_esfNationalMatchResultRemoteModel, shootOffFinal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getExternalShooter() {
		return _externalShooter;
	}

	@Override
	public boolean isExternalShooter() {
		return _externalShooter;
	}

	@Override
	public void setExternalShooter(boolean externalShooter) {
		_externalShooter = externalShooter;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalShooter",
						boolean.class);

				method.invoke(_esfNationalMatchResultRemoteModel,
					externalShooter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExternalName() {
		return _externalName;
	}

	@Override
	public void setExternalName(String externalName) {
		_externalName = externalName;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalName", String.class);

				method.invoke(_esfNationalMatchResultRemoteModel, externalName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_esfNationalMatchResultRemoteModel, esfSportTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserNationality() {
		return _userNationality;
	}

	@Override
	public void setUserNationality(String userNationality) {
		_userNationality = userNationality;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserNationality",
						String.class);

				method.invoke(_esfNationalMatchResultRemoteModel,
					userNationality);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserQualification() {
		return _esfUserQualification;
	}

	@Override
	public void setEsfUserQualification(long esfUserQualification) {
		_esfUserQualification = esfUserQualification;

		if (_esfNationalMatchResultRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalMatchResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserQualification",
						long.class);

				method.invoke(_esfNationalMatchResultRemoteModel,
					esfUserQualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFNationalMatchResultRemoteModel() {
		return _esfNationalMatchResultRemoteModel;
	}

	public void setESFNationalMatchResultRemoteModel(
		BaseModel<?> esfNationalMatchResultRemoteModel) {
		_esfNationalMatchResultRemoteModel = esfNationalMatchResultRemoteModel;
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

		Class<?> remoteModelClass = _esfNationalMatchResultRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfNationalMatchResultRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFNationalMatchResultLocalServiceUtil.addESFNationalMatchResult(this);
		}
		else {
			ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(this);
		}
	}

	@Override
	public ESFNationalMatchResult toEscapedModel() {
		return (ESFNationalMatchResult)ProxyUtil.newProxyInstance(ESFNationalMatchResult.class.getClassLoader(),
			new Class[] { ESFNationalMatchResult.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFNationalMatchResultClp clone = new ESFNationalMatchResultClp();

		clone.setEsfNationalMatchResultId(getEsfNationalMatchResultId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfUserId(getEsfUserId());
		clone.setPosition(getPosition());
		clone.setQualification(getQualification());
		clone.setShootOff(getShootOff());
		clone.setClayPigeonTotal(getClayPigeonTotal());
		clone.setFinalResult(getFinalResult());
		clone.setShootOffFinal(getShootOffFinal());
		clone.setExternalShooter(getExternalShooter());
		clone.setExternalName(getExternalName());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setUserNationality(getUserNationality());
		clone.setEsfUserQualification(getEsfUserQualification());

		return clone;
	}

	@Override
	public int compareTo(ESFNationalMatchResult esfNationalMatchResult) {
		int value = 0;

		if (getPosition() < esfNationalMatchResult.getPosition()) {
			value = -1;
		}
		else if (getPosition() > esfNationalMatchResult.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFNationalMatchResultClp)) {
			return false;
		}

		ESFNationalMatchResultClp esfNationalMatchResult = (ESFNationalMatchResultClp)obj;

		long primaryKey = esfNationalMatchResult.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{esfNationalMatchResultId=");
		sb.append(getEsfNationalMatchResultId());
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
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", qualification=");
		sb.append(getQualification());
		sb.append(", shootOff=");
		sb.append(getShootOff());
		sb.append(", clayPigeonTotal=");
		sb.append(getClayPigeonTotal());
		sb.append(", finalResult=");
		sb.append(getFinalResult());
		sb.append(", shootOffFinal=");
		sb.append(getShootOffFinal());
		sb.append(", externalShooter=");
		sb.append(getExternalShooter());
		sb.append(", externalName=");
		sb.append(getExternalName());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", userNationality=");
		sb.append(getUserNationality());
		sb.append(", esfUserQualification=");
		sb.append(getEsfUserQualification());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFNationalMatchResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfNationalMatchResultId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalMatchResultId());
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
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualification</column-name><column-value><![CDATA[");
		sb.append(getQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOff</column-name><column-value><![CDATA[");
		sb.append(getShootOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clayPigeonTotal</column-name><column-value><![CDATA[");
		sb.append(getClayPigeonTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalResult</column-name><column-value><![CDATA[");
		sb.append(getFinalResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootOffFinal</column-name><column-value><![CDATA[");
		sb.append(getShootOffFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalShooter</column-name><column-value><![CDATA[");
		sb.append(getExternalShooter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalName</column-name><column-value><![CDATA[");
		sb.append(getExternalName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userNationality</column-name><column-value><![CDATA[");
		sb.append(getUserNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserQualification</column-name><column-value><![CDATA[");
		sb.append(getEsfUserQualification());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfNationalMatchResultId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfMatchId;
	private long _esfUserId;
	private String _esfUserUuid;
	private int _position;
	private int _qualification;
	private int _shootOff;
	private int _clayPigeonTotal;
	private int _finalResult;
	private int _shootOffFinal;
	private boolean _externalShooter;
	private String _externalName;
	private long _esfSportTypeId;
	private String _userNationality;
	private long _esfUserQualification;
	private BaseModel<?> _esfNationalMatchResultRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}