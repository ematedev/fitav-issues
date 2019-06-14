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
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFederalRoleClp extends BaseModelImpl<ESFFederalRole>
	implements ESFFederalRole {
	public ESFFederalRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFederalRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFederalRole.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfFederalRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfFederalRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfFederalRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("regional", getRegional());
		attributes.put("provincial", getProvincial());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean regional = (Boolean)attributes.get("regional");

		if (regional != null) {
			setRegional(regional);
		}

		Boolean provincial = (Boolean)attributes.get("provincial");

		if (provincial != null) {
			setProvincial(provincial);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfFederalRoleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleId = esfFederalRoleId;

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFederalRoleId",
						long.class);

				method.invoke(_esfFederalRoleRemoteModel, esfFederalRoleId);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfFederalRoleRemoteModel, groupId);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfFederalRoleRemoteModel, companyId);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfFederalRoleRemoteModel, userId);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfFederalRoleRemoteModel, userName);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfFederalRoleRemoteModel, createDate);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfFederalRoleRemoteModel, modifiedDate);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfFederalRoleRemoteModel, code);
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

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfFederalRoleRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRegional() {
		return _regional;
	}

	@Override
	public boolean isRegional() {
		return _regional;
	}

	@Override
	public void setRegional(boolean regional) {
		_regional = regional;

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRegional", boolean.class);

				method.invoke(_esfFederalRoleRemoteModel, regional);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getProvincial() {
		return _provincial;
	}

	@Override
	public boolean isProvincial() {
		return _provincial;
	}

	@Override
	public void setProvincial(boolean provincial) {
		_provincial = provincial;

		if (_esfFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setProvincial", boolean.class);

				method.invoke(_esfFederalRoleRemoteModel, provincial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFFederalRole.class.getName()));
	}

	public BaseModel<?> getESFFederalRoleRemoteModel() {
		return _esfFederalRoleRemoteModel;
	}

	public void setESFFederalRoleRemoteModel(
		BaseModel<?> esfFederalRoleRemoteModel) {
		_esfFederalRoleRemoteModel = esfFederalRoleRemoteModel;
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

		Class<?> remoteModelClass = _esfFederalRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFederalRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFederalRoleLocalServiceUtil.addESFFederalRole(this);
		}
		else {
			ESFFederalRoleLocalServiceUtil.updateESFFederalRole(this);
		}
	}

	@Override
	public ESFFederalRole toEscapedModel() {
		return (ESFFederalRole)ProxyUtil.newProxyInstance(ESFFederalRole.class.getClassLoader(),
			new Class[] { ESFFederalRole.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFederalRoleClp clone = new ESFFederalRoleClp();

		clone.setUuid(getUuid());
		clone.setEsfFederalRoleId(getEsfFederalRoleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCode(getCode());
		clone.setDescription(getDescription());
		clone.setRegional(getRegional());
		clone.setProvincial(getProvincial());

		return clone;
	}

	@Override
	public int compareTo(ESFFederalRole esfFederalRole) {
		long primaryKey = esfFederalRole.getPrimaryKey();

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

		if (!(obj instanceof ESFFederalRoleClp)) {
			return false;
		}

		ESFFederalRoleClp esfFederalRole = (ESFFederalRoleClp)obj;

		long primaryKey = esfFederalRole.getPrimaryKey();

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
		sb.append(", esfFederalRoleId=");
		sb.append(getEsfFederalRoleId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", regional=");
		sb.append(getRegional());
		sb.append(", provincial=");
		sb.append(getProvincial());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFederalRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFederalRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfFederalRoleId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regional</column-name><column-value><![CDATA[");
		sb.append(getRegional());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provincial</column-name><column-value><![CDATA[");
		sb.append(getProvincial());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfFederalRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _description;
	private boolean _regional;
	private boolean _provincial;
	private BaseModel<?> _esfFederalRoleRemoteModel;
}