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
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShooterCategoryClp extends BaseModelImpl<ESFShooterCategory>
	implements ESFShooterCategory {
	public ESFShooterCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfShooterCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShooterCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShooterCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfShooterCategoryRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryId;
	}

	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryId = esfShooterCategoryId;

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterCategoryId",
						long.class);

				method.invoke(_esfShooterCategoryRemoteModel,
					esfShooterCategoryId);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfShooterCategoryRemoteModel, name);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfShooterCategoryRemoteModel, groupId);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfShooterCategoryRemoteModel, companyId);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfShooterCategoryRemoteModel, userId);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfShooterCategoryRemoteModel, userName);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfShooterCategoryRemoteModel, createDate);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfShooterCategoryRemoteModel, modifiedDate);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfShooterCategoryRemoteModel, description);
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

		if (_esfShooterCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfShooterCategoryRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFShooterCategory.class.getName()));
	}

	public BaseModel<?> getESFShooterCategoryRemoteModel() {
		return _esfShooterCategoryRemoteModel;
	}

	public void setESFShooterCategoryRemoteModel(
		BaseModel<?> esfShooterCategoryRemoteModel) {
		_esfShooterCategoryRemoteModel = esfShooterCategoryRemoteModel;
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

		Class<?> remoteModelClass = _esfShooterCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShooterCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShooterCategoryLocalServiceUtil.addESFShooterCategory(this);
		}
		else {
			ESFShooterCategoryLocalServiceUtil.updateESFShooterCategory(this);
		}
	}

	@Override
	public ESFShooterCategory toEscapedModel() {
		return (ESFShooterCategory)ProxyUtil.newProxyInstance(ESFShooterCategory.class.getClassLoader(),
			new Class[] { ESFShooterCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShooterCategoryClp clone = new ESFShooterCategoryClp();

		clone.setUuid(getUuid());
		clone.setEsfShooterCategoryId(getEsfShooterCategoryId());
		clone.setName(getName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDescription(getDescription());
		clone.setCode(getCode());

		return clone;
	}

	@Override
	public int compareTo(ESFShooterCategory esfShooterCategory) {
		int value = 0;

		value = getName().compareTo(esfShooterCategory.getName());

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

		if (!(obj instanceof ESFShooterCategoryClp)) {
			return false;
		}

		ESFShooterCategoryClp esfShooterCategory = (ESFShooterCategoryClp)obj;

		long primaryKey = esfShooterCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfShooterCategoryId=");
		sb.append(getEsfShooterCategoryId());
		sb.append(", name=");
		sb.append(getName());
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", code=");
		sb.append(getCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfShooterCategoryId;
	private String _name;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private String _code;
	private BaseModel<?> _esfShooterCategoryRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}