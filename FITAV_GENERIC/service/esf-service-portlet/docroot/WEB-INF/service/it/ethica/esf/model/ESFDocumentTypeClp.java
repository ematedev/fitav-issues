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
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFDocumentTypeClp extends BaseModelImpl<ESFDocumentType>
	implements ESFDocumentType {
	public ESFDocumentTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocumentType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocumentType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDocumentTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentTypeId", getEsfDocumentTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("esfTypeId", getEsfTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentTypeId = (Long)attributes.get("esfDocumentTypeId");

		if (esfDocumentTypeId != null) {
			setEsfDocumentTypeId(esfDocumentTypeId);
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

		Long esfDocumentId = (Long)attributes.get("esfDocumentId");

		if (esfDocumentId != null) {
			setEsfDocumentId(esfDocumentId);
		}

		Long esfTypeId = (Long)attributes.get("esfTypeId");

		if (esfTypeId != null) {
			setEsfTypeId(esfTypeId);
		}
	}

	@Override
	public long getEsfDocumentTypeId() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentTypeId = esfDocumentTypeId;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDocumentTypeId",
						long.class);

				method.invoke(_esfDocumentTypeRemoteModel, esfDocumentTypeId);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfDocumentTypeRemoteModel, groupId);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfDocumentTypeRemoteModel, companyId);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfDocumentTypeRemoteModel, userId);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfDocumentTypeRemoteModel, userName);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfDocumentTypeRemoteModel, createDate);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfDocumentTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfDocumentId() {
		return _esfDocumentId;
	}

	@Override
	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocumentId = esfDocumentId;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDocumentId", long.class);

				method.invoke(_esfDocumentTypeRemoteModel, esfDocumentId);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTypeId", long.class);

				method.invoke(_esfDocumentTypeRemoteModel, esfTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFDocumentTypeRemoteModel() {
		return _esfDocumentTypeRemoteModel;
	}

	public void setESFDocumentTypeRemoteModel(
		BaseModel<?> esfDocumentTypeRemoteModel) {
		_esfDocumentTypeRemoteModel = esfDocumentTypeRemoteModel;
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

		Class<?> remoteModelClass = _esfDocumentTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfDocumentTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFDocumentTypeLocalServiceUtil.addESFDocumentType(this);
		}
		else {
			ESFDocumentTypeLocalServiceUtil.updateESFDocumentType(this);
		}
	}

	@Override
	public ESFDocumentType toEscapedModel() {
		return (ESFDocumentType)ProxyUtil.newProxyInstance(ESFDocumentType.class.getClassLoader(),
			new Class[] { ESFDocumentType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFDocumentTypeClp clone = new ESFDocumentTypeClp();

		clone.setEsfDocumentTypeId(getEsfDocumentTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfDocumentId(getEsfDocumentId());
		clone.setEsfTypeId(getEsfTypeId());

		return clone;
	}

	@Override
	public int compareTo(ESFDocumentType esfDocumentType) {
		long primaryKey = esfDocumentType.getPrimaryKey();

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

		if (!(obj instanceof ESFDocumentTypeClp)) {
			return false;
		}

		ESFDocumentTypeClp esfDocumentType = (ESFDocumentTypeClp)obj;

		long primaryKey = esfDocumentType.getPrimaryKey();

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

		sb.append("{esfDocumentTypeId=");
		sb.append(getEsfDocumentTypeId());
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
		sb.append(", esfDocumentId=");
		sb.append(getEsfDocumentId());
		sb.append(", esfTypeId=");
		sb.append(getEsfTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDocumentType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDocumentTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentTypeId());
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
			"<column><column-name>esfDocumentId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfDocumentTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfDocumentId;
	private long _esfTypeId;
	private BaseModel<?> _esfDocumentTypeRemoteModel;
}