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
import it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFOrganizationTypeClp extends BaseModelImpl<ESFOrganizationType>
	implements ESFOrganizationType {
	public ESFOrganizationTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganizationType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganizationType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfOrganizationTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfOrganizationTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfOrganizationTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrganizationTypeId", getEsfOrganizationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("esfTypeId", getEsfTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrganizationTypeId = (Long)attributes.get(
				"esfOrganizationTypeId");

		if (esfOrganizationTypeId != null) {
			setEsfOrganizationTypeId(esfOrganizationTypeId);
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

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long esfTypeId = (Long)attributes.get("esfTypeId");

		if (esfTypeId != null) {
			setEsfTypeId(esfTypeId);
		}
	}

	@Override
	public long getEsfOrganizationTypeId() {
		return _esfOrganizationTypeId;
	}

	@Override
	public void setEsfOrganizationTypeId(long esfOrganizationTypeId) {
		_esfOrganizationTypeId = esfOrganizationTypeId;

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationTypeId",
						long.class);

				method.invoke(_esfOrganizationTypeRemoteModel,
					esfOrganizationTypeId);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfOrganizationTypeRemoteModel, groupId);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfOrganizationTypeRemoteModel, companyId);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfOrganizationTypeRemoteModel, userId);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfOrganizationTypeRemoteModel, userName);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfOrganizationTypeRemoteModel, createDate);
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

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfOrganizationTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfOrganizationTypeRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfTypeId() {
		return _esfTypeId;
	}

	@Override
	public void setEsfTypeId(long esfTypeId) {
		_esfTypeId = esfTypeId;

		if (_esfOrganizationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTypeId", long.class);

				method.invoke(_esfOrganizationTypeRemoteModel, esfTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFOrganizationTypeRemoteModel() {
		return _esfOrganizationTypeRemoteModel;
	}

	public void setESFOrganizationTypeRemoteModel(
		BaseModel<?> esfOrganizationTypeRemoteModel) {
		_esfOrganizationTypeRemoteModel = esfOrganizationTypeRemoteModel;
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

		Class<?> remoteModelClass = _esfOrganizationTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfOrganizationTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFOrganizationTypeLocalServiceUtil.addESFOrganizationType(this);
		}
		else {
			ESFOrganizationTypeLocalServiceUtil.updateESFOrganizationType(this);
		}
	}

	@Override
	public ESFOrganizationType toEscapedModel() {
		return (ESFOrganizationType)ProxyUtil.newProxyInstance(ESFOrganizationType.class.getClassLoader(),
			new Class[] { ESFOrganizationType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFOrganizationTypeClp clone = new ESFOrganizationTypeClp();

		clone.setEsfOrganizationTypeId(getEsfOrganizationTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setEsfTypeId(getEsfTypeId());

		return clone;
	}

	@Override
	public int compareTo(ESFOrganizationType esfOrganizationType) {
		long primaryKey = esfOrganizationType.getPrimaryKey();

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

		if (!(obj instanceof ESFOrganizationTypeClp)) {
			return false;
		}

		ESFOrganizationTypeClp esfOrganizationType = (ESFOrganizationTypeClp)obj;

		long primaryKey = esfOrganizationType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{esfOrganizationTypeId=");
		sb.append(getEsfOrganizationTypeId());
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
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", esfTypeId=");
		sb.append(getEsfTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFOrganizationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfOrganizationTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationTypeId());
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
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfOrganizationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfOrganizationId;
	private long _esfTypeId;
	private BaseModel<?> _esfOrganizationTypeRemoteModel;
}