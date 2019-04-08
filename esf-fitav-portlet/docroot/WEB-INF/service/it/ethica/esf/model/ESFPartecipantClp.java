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
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFPartecipantClp extends BaseModelImpl<ESFPartecipant>
	implements ESFPartecipant {
	public ESFPartecipantClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPartecipant.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPartecipant.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfPartecipantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfPartecipantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfPartecipantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfPartecipantId", getEsfPartecipantId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfTeamId", getEsfTeamId());
		attributes.put("ct", getCt());
		attributes.put("esfPartecipantTypeId", getEsfPartecipantTypeId());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfPartecipantId = (Long)attributes.get("esfPartecipantId");

		if (esfPartecipantId != null) {
			setEsfPartecipantId(esfPartecipantId);
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

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfTeamId = (Long)attributes.get("esfTeamId");

		if (esfTeamId != null) {
			setEsfTeamId(esfTeamId);
		}

		Long ct = (Long)attributes.get("ct");

		if (ct != null) {
			setCt(ct);
		}

		Long esfPartecipantTypeId = (Long)attributes.get("esfPartecipantTypeId");

		if (esfPartecipantTypeId != null) {
			setEsfPartecipantTypeId(esfPartecipantTypeId);
		}

		Long result = (Long)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfPartecipantRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfPartecipantId() {
		return _esfPartecipantId;
	}

	@Override
	public void setEsfPartecipantId(long esfPartecipantId) {
		_esfPartecipantId = esfPartecipantId;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantId",
						long.class);

				method.invoke(_esfPartecipantRemoteModel, esfPartecipantId);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfPartecipantRemoteModel, groupId);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfPartecipantRemoteModel, companyId);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfPartecipantRemoteModel, userId);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfPartecipantRemoteModel, userName);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfPartecipantRemoteModel, createDate);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfPartecipantRemoteModel, modifiedDate);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfPartecipantRemoteModel, esfUserId);
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
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfPartecipantRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfTeamId() {
		return _esfTeamId;
	}

	@Override
	public void setEsfTeamId(long esfTeamId) {
		_esfTeamId = esfTeamId;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTeamId", long.class);

				method.invoke(_esfPartecipantRemoteModel, esfTeamId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCt() {
		return _ct;
	}

	@Override
	public void setCt(long ct) {
		_ct = ct;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setCt", long.class);

				method.invoke(_esfPartecipantRemoteModel, ct);
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

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantTypeId",
						long.class);

				method.invoke(_esfPartecipantRemoteModel, esfPartecipantTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResult() {
		return _result;
	}

	@Override
	public void setResult(long result) {
		_result = result;

		if (_esfPartecipantRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantRemoteModel.getClass();

				Method method = clazz.getMethod("setResult", long.class);

				method.invoke(_esfPartecipantRemoteModel, result);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFPartecipant.class.getName()));
	}

	public BaseModel<?> getESFPartecipantRemoteModel() {
		return _esfPartecipantRemoteModel;
	}

	public void setESFPartecipantRemoteModel(
		BaseModel<?> esfPartecipantRemoteModel) {
		_esfPartecipantRemoteModel = esfPartecipantRemoteModel;
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

		Class<?> remoteModelClass = _esfPartecipantRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfPartecipantRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFPartecipantLocalServiceUtil.addESFPartecipant(this);
		}
		else {
			ESFPartecipantLocalServiceUtil.updateESFPartecipant(this);
		}
	}

	@Override
	public ESFPartecipant toEscapedModel() {
		return (ESFPartecipant)ProxyUtil.newProxyInstance(ESFPartecipant.class.getClassLoader(),
			new Class[] { ESFPartecipant.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFPartecipantClp clone = new ESFPartecipantClp();

		clone.setUuid(getUuid());
		clone.setEsfPartecipantId(getEsfPartecipantId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfTeamId(getEsfTeamId());
		clone.setCt(getCt());
		clone.setEsfPartecipantTypeId(getEsfPartecipantTypeId());
		clone.setResult(getResult());

		return clone;
	}

	@Override
	public int compareTo(ESFPartecipant esfPartecipant) {
		long primaryKey = esfPartecipant.getPrimaryKey();

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

		if (!(obj instanceof ESFPartecipantClp)) {
			return false;
		}

		ESFPartecipantClp esfPartecipant = (ESFPartecipantClp)obj;

		long primaryKey = esfPartecipant.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfPartecipantId=");
		sb.append(getEsfPartecipantId());
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
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfTeamId=");
		sb.append(getEsfTeamId());
		sb.append(", ct=");
		sb.append(getCt());
		sb.append(", esfPartecipantTypeId=");
		sb.append(getEsfPartecipantTypeId());
		sb.append(", result=");
		sb.append(getResult());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFPartecipant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfPartecipantId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantId());
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
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTeamId</column-name><column-value><![CDATA[");
		sb.append(getEsfTeamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ct</column-name><column-value><![CDATA[");
		sb.append(getCt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfPartecipantTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfPartecipantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfMatchId;
	private long _esfTeamId;
	private long _ct;
	private long _esfPartecipantTypeId;
	private long _result;
	private BaseModel<?> _esfPartecipantRemoteModel;
}