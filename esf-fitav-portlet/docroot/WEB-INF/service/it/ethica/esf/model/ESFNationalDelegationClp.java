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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFNationalDelegationClp extends BaseModelImpl<ESFNationalDelegation>
	implements ESFNationalDelegation {
	public ESFNationalDelegationClp() {
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
	public long getPrimaryKey() {
		return _esfNationalDelgationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfNationalDelgationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfNationalDelgationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfNationalDelegationRemoteModel, uuid);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, esfUserId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, groupId);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, companyId);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, userId);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfNationalDelegationRemoteModel, userName);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, createDate);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, modifiedDate);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, leaveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReturnDate() {
		return _returnDate;
	}

	@Override
	public void setReturnDate(Date returnDate) {
		_returnDate = returnDate;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, returnDate);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, esfMatchId);
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

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, esfSportTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationId;
	}

	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationId = esfShooterQualificationId;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterQualificationId",
						long.class);

				method.invoke(_esfNationalDelegationRemoteModel,
					esfShooterQualificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunId1() {
		return _esfGunId1;
	}

	@Override
	public void setEsfGunId1(long esfGunId1) {
		_esfGunId1 = esfGunId1;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunId1", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, esfGunId1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunId2() {
		return _esfGunId2;
	}

	@Override
	public void setEsfGunId2(long esfGunId2) {
		_esfGunId2 = esfGunId2;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunId2", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, esfGunId2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfNationalDelgationId() {
		return _esfNationalDelgationId;
	}

	@Override
	public void setEsfNationalDelgationId(long esfNationalDelgationId) {
		_esfNationalDelgationId = esfNationalDelgationId;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfNationalDelgationId",
						long.class);

				method.invoke(_esfNationalDelegationRemoteModel,
					esfNationalDelgationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfPartecipantTypeId() {
		return _esfPartecipantTypeId;
	}

	@Override
	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantTypeId = esfPartecipantTypeId;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantTypeId",
						long.class);

				method.invoke(_esfNationalDelegationRemoteModel,
					esfPartecipantTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNominationDate() {
		return _nominationDate;
	}

	@Override
	public void setNominationDate(Date nominationDate) {
		_nominationDate = nominationDate;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setNominationDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, nominationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRefusalDate() {
		return _refusalDate;
	}

	@Override
	public void setRefusalDate(Date refusalDate) {
		_refusalDate = refusalDate;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setRefusalDate", Date.class);

				method.invoke(_esfNationalDelegationRemoteModel, refusalDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(long taskId) {
		_taskId = taskId;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setTaskId", long.class);

				method.invoke(_esfNationalDelegationRemoteModel, taskId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRefusal() {
		return _refusal;
	}

	@Override
	public void setRefusal(String refusal) {
		_refusal = refusal;

		if (_esfNationalDelegationRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalDelegationRemoteModel.getClass();

				Method method = clazz.getMethod("setRefusal", String.class);

				method.invoke(_esfNationalDelegationRemoteModel, refusal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFNationalDelegation.class.getName()));
	}

	public BaseModel<?> getESFNationalDelegationRemoteModel() {
		return _esfNationalDelegationRemoteModel;
	}

	public void setESFNationalDelegationRemoteModel(
		BaseModel<?> esfNationalDelegationRemoteModel) {
		_esfNationalDelegationRemoteModel = esfNationalDelegationRemoteModel;
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

		Class<?> remoteModelClass = _esfNationalDelegationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfNationalDelegationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(this);
		}
		else {
			ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(this);
		}
	}

	@Override
	public ESFNationalDelegation toEscapedModel() {
		return (ESFNationalDelegation)ProxyUtil.newProxyInstance(ESFNationalDelegation.class.getClassLoader(),
			new Class[] { ESFNationalDelegation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFNationalDelegationClp clone = new ESFNationalDelegationClp();

		clone.setUuid(getUuid());
		clone.setEsfUserId(getEsfUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLeaveDate(getLeaveDate());
		clone.setReturnDate(getReturnDate());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setEsfShooterQualificationId(getEsfShooterQualificationId());
		clone.setEsfGunId1(getEsfGunId1());
		clone.setEsfGunId2(getEsfGunId2());
		clone.setEsfNationalDelgationId(getEsfNationalDelgationId());
		clone.setEsfPartecipantTypeId(getEsfPartecipantTypeId());
		clone.setNominationDate(getNominationDate());
		clone.setRefusalDate(getRefusalDate());
		clone.setTaskId(getTaskId());
		clone.setRefusal(getRefusal());

		return clone;
	}

	@Override
	public int compareTo(ESFNationalDelegation esfNationalDelegation) {
		long primaryKey = esfNationalDelegation.getPrimaryKey();

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

		if (!(obj instanceof ESFNationalDelegationClp)) {
			return false;
		}

		ESFNationalDelegationClp esfNationalDelegation = (ESFNationalDelegationClp)obj;

		long primaryKey = esfNationalDelegation.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
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
		sb.append(", returnDate=");
		sb.append(getReturnDate());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", esfShooterQualificationId=");
		sb.append(getEsfShooterQualificationId());
		sb.append(", esfGunId1=");
		sb.append(getEsfGunId1());
		sb.append(", esfGunId2=");
		sb.append(getEsfGunId2());
		sb.append(", esfNationalDelgationId=");
		sb.append(getEsfNationalDelgationId());
		sb.append(", esfPartecipantTypeId=");
		sb.append(getEsfPartecipantTypeId());
		sb.append(", nominationDate=");
		sb.append(getNominationDate());
		sb.append(", refusalDate=");
		sb.append(getRefusalDate());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append(", refusal=");
		sb.append(getRefusal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFNationalDelegation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
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
			"<column><column-name>returnDate</column-name><column-value><![CDATA[");
		sb.append(getReturnDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunId1</column-name><column-value><![CDATA[");
		sb.append(getEsfGunId1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunId2</column-name><column-value><![CDATA[");
		sb.append(getEsfGunId2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfNationalDelgationId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalDelgationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfPartecipantTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nominationDate</column-name><column-value><![CDATA[");
		sb.append(getNominationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refusalDate</column-name><column-value><![CDATA[");
		sb.append(getRefusalDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refusal</column-name><column-value><![CDATA[");
		sb.append(getRefusal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _leaveDate;
	private Date _returnDate;
	private long _esfMatchId;
	private long _esfSportTypeId;
	private long _esfShooterQualificationId;
	private long _esfGunId1;
	private long _esfGunId2;
	private long _esfNationalDelgationId;
	private long _esfPartecipantTypeId;
	private Date _nominationDate;
	private Date _refusalDate;
	private long _taskId;
	private String _refusal;
	private BaseModel<?> _esfNationalDelegationRemoteModel;
}