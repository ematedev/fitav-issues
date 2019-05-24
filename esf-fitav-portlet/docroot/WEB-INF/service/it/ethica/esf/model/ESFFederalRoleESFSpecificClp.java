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
import it.ethica.esf.service.ESFFederalRoleESFSpecificLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFederalRoleESFSpecificClp extends BaseModelImpl<ESFFederalRoleESFSpecific>
	implements ESFFederalRoleESFSpecific {
	public ESFFederalRoleESFSpecificClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFederalRoleESFSpecific.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFederalRoleESFSpecific.class.getName();
	}

	@Override
	public ESFFederalRoleESFSpecificPK getPrimaryKey() {
		return new ESFFederalRoleESFSpecificPK(_esfSpecificId, _esfFederalRoleId);
	}

	@Override
	public void setPrimaryKey(ESFFederalRoleESFSpecificPK primaryKey) {
		setEsfSpecificId(primaryKey.esfSpecificId);
		setEsfFederalRoleId(primaryKey.esfFederalRoleId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFFederalRoleESFSpecificPK(_esfSpecificId, _esfFederalRoleId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFFederalRoleESFSpecificPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfSpecificId", getEsfSpecificId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfSpecificId = (Long)attributes.get("esfSpecificId");

		if (esfSpecificId != null) {
			setEsfSpecificId(esfSpecificId);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfFederalRoleESFSpecificRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleESFSpecificRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfFederalRoleESFSpecificRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSpecificId() {
		return _esfSpecificId;
	}

	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecificId = esfSpecificId;

		if (_esfFederalRoleESFSpecificRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleESFSpecificRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSpecificId", long.class);

				method.invoke(_esfFederalRoleESFSpecificRemoteModel,
					esfSpecificId);
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

		if (_esfFederalRoleESFSpecificRemoteModel != null) {
			try {
				Class<?> clazz = _esfFederalRoleESFSpecificRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFederalRoleId",
						long.class);

				method.invoke(_esfFederalRoleESFSpecificRemoteModel,
					esfFederalRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFFederalRoleESFSpecificRemoteModel() {
		return _esfFederalRoleESFSpecificRemoteModel;
	}

	public void setESFFederalRoleESFSpecificRemoteModel(
		BaseModel<?> esfFederalRoleESFSpecificRemoteModel) {
		_esfFederalRoleESFSpecificRemoteModel = esfFederalRoleESFSpecificRemoteModel;
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

		Class<?> remoteModelClass = _esfFederalRoleESFSpecificRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFederalRoleESFSpecificRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFederalRoleESFSpecificLocalServiceUtil.addESFFederalRoleESFSpecific(this);
		}
		else {
			ESFFederalRoleESFSpecificLocalServiceUtil.updateESFFederalRoleESFSpecific(this);
		}
	}

	@Override
	public ESFFederalRoleESFSpecific toEscapedModel() {
		return (ESFFederalRoleESFSpecific)ProxyUtil.newProxyInstance(ESFFederalRoleESFSpecific.class.getClassLoader(),
			new Class[] { ESFFederalRoleESFSpecific.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFederalRoleESFSpecificClp clone = new ESFFederalRoleESFSpecificClp();

		clone.setUuid(getUuid());
		clone.setEsfSpecificId(getEsfSpecificId());
		clone.setEsfFederalRoleId(getEsfFederalRoleId());

		return clone;
	}

	@Override
	public int compareTo(ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		ESFFederalRoleESFSpecificPK primaryKey = esfFederalRoleESFSpecific.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFederalRoleESFSpecificClp)) {
			return false;
		}

		ESFFederalRoleESFSpecificClp esfFederalRoleESFSpecific = (ESFFederalRoleESFSpecificClp)obj;

		ESFFederalRoleESFSpecificPK primaryKey = esfFederalRoleESFSpecific.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfSpecificId=");
		sb.append(getEsfSpecificId());
		sb.append(", esfFederalRoleId=");
		sb.append(getEsfFederalRoleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFederalRoleESFSpecific");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSpecificId</column-name><column-value><![CDATA[");
		sb.append(getEsfSpecificId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFederalRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfFederalRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfSpecificId;
	private long _esfFederalRoleId;
	private BaseModel<?> _esfFederalRoleESFSpecificRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}