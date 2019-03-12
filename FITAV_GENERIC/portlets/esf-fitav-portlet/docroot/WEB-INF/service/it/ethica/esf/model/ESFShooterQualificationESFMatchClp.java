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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShooterQualificationESFMatchClp extends BaseModelImpl<ESFShooterQualificationESFMatch>
	implements ESFShooterQualificationESFMatch {
	public ESFShooterQualificationESFMatchClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualificationESFMatch.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualificationESFMatch.class.getName();
	}

	@Override
	public ESFShooterQualificationESFMatchPK getPrimaryKey() {
		return new ESFShooterQualificationESFMatchPK(_esfShooterQualificationId,
			_esfMatchId);
	}

	@Override
	public void setPrimaryKey(ESFShooterQualificationESFMatchPK primaryKey) {
		setEsfShooterQualificationId(primaryKey.esfShooterQualificationId);
		setEsfMatchId(primaryKey.esfMatchId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFShooterQualificationESFMatchPK(_esfShooterQualificationId,
			_esfMatchId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFShooterQualificationESFMatchPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
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
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel, uuid);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterQualificationId",
						long.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					esfShooterQualificationId);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					esfMatchId);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					groupId);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					companyId);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					userId);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					userName);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					createDate);
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

		if (_esfShooterQualificationESFMatchRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFMatchRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfShooterQualificationESFMatchRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFShooterQualificationESFMatch.class.getName()));
	}

	public BaseModel<?> getESFShooterQualificationESFMatchRemoteModel() {
		return _esfShooterQualificationESFMatchRemoteModel;
	}

	public void setESFShooterQualificationESFMatchRemoteModel(
		BaseModel<?> esfShooterQualificationESFMatchRemoteModel) {
		_esfShooterQualificationESFMatchRemoteModel = esfShooterQualificationESFMatchRemoteModel;
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

		Class<?> remoteModelClass = _esfShooterQualificationESFMatchRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShooterQualificationESFMatchRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShooterQualificationESFMatchLocalServiceUtil.addESFShooterQualificationESFMatch(this);
		}
		else {
			ESFShooterQualificationESFMatchLocalServiceUtil.updateESFShooterQualificationESFMatch(this);
		}
	}

	@Override
	public ESFShooterQualificationESFMatch toEscapedModel() {
		return (ESFShooterQualificationESFMatch)ProxyUtil.newProxyInstance(ESFShooterQualificationESFMatch.class.getClassLoader(),
			new Class[] { ESFShooterQualificationESFMatch.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShooterQualificationESFMatchClp clone = new ESFShooterQualificationESFMatchClp();

		clone.setUuid(getUuid());
		clone.setEsfShooterQualificationId(getEsfShooterQualificationId());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		ESFShooterQualificationESFMatchPK primaryKey = esfShooterQualificationESFMatch.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationESFMatchClp)) {
			return false;
		}

		ESFShooterQualificationESFMatchClp esfShooterQualificationESFMatch = (ESFShooterQualificationESFMatchClp)obj;

		ESFShooterQualificationESFMatchPK primaryKey = esfShooterQualificationESFMatch.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfShooterQualificationId=");
		sb.append(getEsfShooterQualificationId());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterQualificationESFMatch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfShooterQualificationId;
	private long _esfMatchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _esfShooterQualificationESFMatchRemoteModel;
}