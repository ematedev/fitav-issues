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
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFOrganizationUnitserviceClp extends BaseModelImpl<ESFOrganizationUnitservice>
	implements ESFOrganizationUnitservice {
	public ESFOrganizationUnitserviceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganizationUnitservice.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganizationUnitservice.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfOrganizationUnitserviceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfOrganizationUnitserviceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfOrganizationUnitserviceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfOrganizationUnitserviceId",
			getEsfOrganizationUnitserviceId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("esfUnitserviceId", getEsfUnitserviceId());
		attributes.put("numberUnitservices", getNumberUnitservices());
		attributes.put("description", getDescription());
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

		Long esfOrganizationUnitserviceId = (Long)attributes.get(
				"esfOrganizationUnitserviceId");

		if (esfOrganizationUnitserviceId != null) {
			setEsfOrganizationUnitserviceId(esfOrganizationUnitserviceId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long esfUnitserviceId = (Long)attributes.get("esfUnitserviceId");

		if (esfUnitserviceId != null) {
			setEsfUnitserviceId(esfUnitserviceId);
		}

		Long numberUnitservices = (Long)attributes.get("numberUnitservices");

		if (numberUnitservices != null) {
			setNumberUnitservices(numberUnitservices);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrganizationUnitserviceId() {
		return _esfOrganizationUnitserviceId;
	}

	@Override
	public void setEsfOrganizationUnitserviceId(
		long esfOrganizationUnitserviceId) {
		_esfOrganizationUnitserviceId = esfOrganizationUnitserviceId;

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationUnitserviceId",
						long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
					esfOrganizationUnitserviceId);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
					esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUnitserviceId() {
		return _esfUnitserviceId;
	}

	@Override
	public void setEsfUnitserviceId(long esfUnitserviceId) {
		_esfUnitserviceId = esfUnitserviceId;

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUnitserviceId",
						long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
					esfUnitserviceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumberUnitservices() {
		return _numberUnitservices;
	}

	@Override
	public void setNumberUnitservices(long numberUnitservices) {
		_numberUnitservices = numberUnitservices;

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberUnitservices",
						long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
					numberUnitservices);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
					description);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, groupId);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, companyId);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, userId);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, userName);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel, createDate);
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

		if (_esfOrganizationUnitserviceRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrganizationUnitserviceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfOrganizationUnitserviceRemoteModel,
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
				ESFOrganizationUnitservice.class.getName()));
	}

	public BaseModel<?> getESFOrganizationUnitserviceRemoteModel() {
		return _esfOrganizationUnitserviceRemoteModel;
	}

	public void setESFOrganizationUnitserviceRemoteModel(
		BaseModel<?> esfOrganizationUnitserviceRemoteModel) {
		_esfOrganizationUnitserviceRemoteModel = esfOrganizationUnitserviceRemoteModel;
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

		Class<?> remoteModelClass = _esfOrganizationUnitserviceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfOrganizationUnitserviceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFOrganizationUnitserviceLocalServiceUtil.addESFOrganizationUnitservice(this);
		}
		else {
			ESFOrganizationUnitserviceLocalServiceUtil.updateESFOrganizationUnitservice(this);
		}
	}

	@Override
	public ESFOrganizationUnitservice toEscapedModel() {
		return (ESFOrganizationUnitservice)ProxyUtil.newProxyInstance(ESFOrganizationUnitservice.class.getClassLoader(),
			new Class[] { ESFOrganizationUnitservice.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFOrganizationUnitserviceClp clone = new ESFOrganizationUnitserviceClp();

		clone.setUuid(getUuid());
		clone.setEsfOrganizationUnitserviceId(getEsfOrganizationUnitserviceId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setEsfUnitserviceId(getEsfUnitserviceId());
		clone.setNumberUnitservices(getNumberUnitservices());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ESFOrganizationUnitservice esfOrganizationUnitservice) {
		int value = 0;

		value = getDescription()
					.compareTo(esfOrganizationUnitservice.getDescription());

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

		if (!(obj instanceof ESFOrganizationUnitserviceClp)) {
			return false;
		}

		ESFOrganizationUnitserviceClp esfOrganizationUnitservice = (ESFOrganizationUnitserviceClp)obj;

		long primaryKey = esfOrganizationUnitservice.getPrimaryKey();

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
		sb.append(", esfOrganizationUnitserviceId=");
		sb.append(getEsfOrganizationUnitserviceId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", esfUnitserviceId=");
		sb.append(getEsfUnitserviceId());
		sb.append(", numberUnitservices=");
		sb.append(getNumberUnitservices());
		sb.append(", description=");
		sb.append(getDescription());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFOrganizationUnitservice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationUnitserviceId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationUnitserviceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUnitserviceId</column-name><column-value><![CDATA[");
		sb.append(getEsfUnitserviceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberUnitservices</column-name><column-value><![CDATA[");
		sb.append(getNumberUnitservices());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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
	private long _esfOrganizationUnitserviceId;
	private long _esfOrganizationId;
	private long _esfUnitserviceId;
	private long _numberUnitservices;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _esfOrganizationUnitserviceRemoteModel;
}