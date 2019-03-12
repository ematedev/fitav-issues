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
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFUserRoleClp extends BaseModelImpl<ESFUserRole>
	implements ESFUserRole {
	public ESFUserRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserRole.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfUserRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfUserRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfUserRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserRoleId", getEsfUserRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("isBDO", getIsBDO());
		attributes.put("isLEA", getIsLEA());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserRoleId = (Long)attributes.get("esfUserRoleId");

		if (esfUserRoleId != null) {
			setEsfUserRoleId(esfUserRoleId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isBDO = (Boolean)attributes.get("isBDO");

		if (isBDO != null) {
			setIsBDO(isBDO);
		}

		Boolean isLEA = (Boolean)attributes.get("isLEA");

		if (isLEA != null) {
			setIsLEA(isLEA);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfUserRoleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserRoleId() {
		return _esfUserRoleId;
	}

	@Override
	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRoleId = esfUserRoleId;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserRoleId", long.class);

				method.invoke(_esfUserRoleRemoteModel, esfUserRoleId);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfUserRoleRemoteModel, groupId);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfUserRoleRemoteModel, companyId);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfUserRoleRemoteModel, userId);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfUserRoleRemoteModel, userName);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfUserRoleRemoteModel, createDate);
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

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfUserRoleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfUserRoleRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfUserRoleRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsBDO() {
		return _isBDO;
	}

	@Override
	public boolean isIsBDO() {
		return _isBDO;
	}

	@Override
	public void setIsBDO(boolean isBDO) {
		_isBDO = isBDO;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setIsBDO", boolean.class);

				method.invoke(_esfUserRoleRemoteModel, isBDO);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsLEA() {
		return _isLEA;
	}

	@Override
	public boolean isIsLEA() {
		return _isLEA;
	}

	@Override
	public void setIsLEA(boolean isLEA) {
		_isLEA = isLEA;

		if (_esfUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLEA", boolean.class);

				method.invoke(_esfUserRoleRemoteModel, isLEA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFUserRole.class.getName()));
	}

	public BaseModel<?> getESFUserRoleRemoteModel() {
		return _esfUserRoleRemoteModel;
	}

	public void setESFUserRoleRemoteModel(BaseModel<?> esfUserRoleRemoteModel) {
		_esfUserRoleRemoteModel = esfUserRoleRemoteModel;
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

		Class<?> remoteModelClass = _esfUserRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfUserRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFUserRoleLocalServiceUtil.addESFUserRole(this);
		}
		else {
			ESFUserRoleLocalServiceUtil.updateESFUserRole(this);
		}
	}

	@Override
	public ESFUserRole toEscapedModel() {
		return (ESFUserRole)ProxyUtil.newProxyInstance(ESFUserRole.class.getClassLoader(),
			new Class[] { ESFUserRole.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFUserRoleClp clone = new ESFUserRoleClp();

		clone.setUuid(getUuid());
		clone.setEsfUserRoleId(getEsfUserRoleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setIsBDO(getIsBDO());
		clone.setIsLEA(getIsLEA());

		return clone;
	}

	@Override
	public int compareTo(ESFUserRole esfUserRole) {
		int value = 0;

		value = getName().compareTo(esfUserRole.getName());

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

		if (!(obj instanceof ESFUserRoleClp)) {
			return false;
		}

		ESFUserRoleClp esfUserRole = (ESFUserRoleClp)obj;

		long primaryKey = esfUserRole.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfUserRoleId=");
		sb.append(getEsfUserRoleId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isBDO=");
		sb.append(getIsBDO());
		sb.append(", isLEA=");
		sb.append(getIsLEA());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUserRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserRoleId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isBDO</column-name><column-value><![CDATA[");
		sb.append(getIsBDO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLEA</column-name><column-value><![CDATA[");
		sb.append(getIsLEA());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfUserRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private boolean _isBDO;
	private boolean _isLEA;
	private BaseModel<?> _esfUserRoleRemoteModel;
}