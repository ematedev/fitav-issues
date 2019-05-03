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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFPublicAuthorityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFPublicAuthorityClp extends BaseModelImpl<ESFPublicAuthority>
	implements ESFPublicAuthority {
	public ESFPublicAuthorityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPublicAuthority.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPublicAuthority.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfPublicAuthorityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPublicAuthorityId", getEsfPublicAuthorityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPublicAuthorityId = (Long)attributes.get("esfPublicAuthorityId");

		if (esfPublicAuthorityId != null) {
			setEsfPublicAuthorityId(esfPublicAuthorityId);
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
	}

	@Override
	public long getEsfPublicAuthorityId() {
		return _esfPublicAuthorityId;
	}

	@Override
	public void setEsfPublicAuthorityId(long esfPublicAuthorityId) {
		_esfPublicAuthorityId = esfPublicAuthorityId;

		if (_esfPublicAuthorityRemoteModel != null) {
			try {
				Class<?> clazz = _esfPublicAuthorityRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPublicAuthorityId",
						long.class);

				method.invoke(_esfPublicAuthorityRemoteModel,
					esfPublicAuthorityId);
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

		if (_esfPublicAuthorityRemoteModel != null) {
			try {
				Class<?> clazz = _esfPublicAuthorityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfPublicAuthorityRemoteModel, createDate);
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

		if (_esfPublicAuthorityRemoteModel != null) {
			try {
				Class<?> clazz = _esfPublicAuthorityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfPublicAuthorityRemoteModel, modifiedDate);
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

		if (_esfPublicAuthorityRemoteModel != null) {
			try {
				Class<?> clazz = _esfPublicAuthorityRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfPublicAuthorityRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFPublicAuthorityRemoteModel() {
		return _esfPublicAuthorityRemoteModel;
	}

	public void setESFPublicAuthorityRemoteModel(
		BaseModel<?> esfPublicAuthorityRemoteModel) {
		_esfPublicAuthorityRemoteModel = esfPublicAuthorityRemoteModel;
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

		Class<?> remoteModelClass = _esfPublicAuthorityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfPublicAuthorityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFPublicAuthorityLocalServiceUtil.addESFPublicAuthority(this);
		}
		else {
			ESFPublicAuthorityLocalServiceUtil.updateESFPublicAuthority(this);
		}
	}

	@Override
	public ESFPublicAuthority toEscapedModel() {
		return (ESFPublicAuthority)ProxyUtil.newProxyInstance(ESFPublicAuthority.class.getClassLoader(),
			new Class[] { ESFPublicAuthority.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFPublicAuthorityClp clone = new ESFPublicAuthorityClp();

		clone.setEsfPublicAuthorityId(getEsfPublicAuthorityId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(ESFPublicAuthority esfPublicAuthority) {
		long primaryKey = esfPublicAuthority.getPrimaryKey();

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

		if (!(obj instanceof ESFPublicAuthorityClp)) {
			return false;
		}

		ESFPublicAuthorityClp esfPublicAuthority = (ESFPublicAuthorityClp)obj;

		long primaryKey = esfPublicAuthority.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{esfPublicAuthorityId=");
		sb.append(getEsfPublicAuthorityId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFPublicAuthority");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfPublicAuthorityId</column-name><column-value><![CDATA[");
		sb.append(getEsfPublicAuthorityId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfPublicAuthorityId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private BaseModel<?> _esfPublicAuthorityRemoteModel;
}