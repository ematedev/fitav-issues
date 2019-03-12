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

package com.ethica.esf.model;

import com.ethica.esf.service.ClpSerializer;
import com.ethica.esf.service.ESFStockistLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFStockistClp extends BaseModelImpl<ESFStockist>
	implements ESFStockist {
	public ESFStockistClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFStockist.class;
	}

	@Override
	public String getModelClassName() {
		return ESFStockist.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfStockistId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfStockistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfStockistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStockistId", getEsfStockistId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("address", getAddress());
		attributes.put("nameReference", getNameReference());
		attributes.put("lastNameReference", getLastNameReference());
		attributes.put("emailReference", getEmailReference());
		attributes.put("phoneReference", getPhoneReference());
		attributes.put("description", getDescription());
		attributes.put("other", getOther());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String nameReference = (String)attributes.get("nameReference");

		if (nameReference != null) {
			setNameReference(nameReference);
		}

		String lastNameReference = (String)attributes.get("lastNameReference");

		if (lastNameReference != null) {
			setLastNameReference(lastNameReference);
		}

		String emailReference = (String)attributes.get("emailReference");

		if (emailReference != null) {
			setEmailReference(emailReference);
		}

		String phoneReference = (String)attributes.get("phoneReference");

		if (phoneReference != null) {
			setPhoneReference(phoneReference);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String other = (String)attributes.get("other");

		if (other != null) {
			setOther(other);
		}
	}

	@Override
	public long getEsfStockistId() {
		return _esfStockistId;
	}

	@Override
	public void setEsfStockistId(long esfStockistId) {
		_esfStockistId = esfStockistId;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStockistId", long.class);

				method.invoke(_esfStockistRemoteModel, esfStockistId);
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

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfStockistRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_esfStockistRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_esfStockistRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_esfStockistRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNameReference() {
		return _nameReference;
	}

	@Override
	public void setNameReference(String nameReference) {
		_nameReference = nameReference;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setNameReference", String.class);

				method.invoke(_esfStockistRemoteModel, nameReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastNameReference() {
		return _lastNameReference;
	}

	@Override
	public void setLastNameReference(String lastNameReference) {
		_lastNameReference = lastNameReference;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setLastNameReference",
						String.class);

				method.invoke(_esfStockistRemoteModel, lastNameReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailReference() {
		return _emailReference;
	}

	@Override
	public void setEmailReference(String emailReference) {
		_emailReference = emailReference;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailReference",
						String.class);

				method.invoke(_esfStockistRemoteModel, emailReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneReference() {
		return _phoneReference;
	}

	@Override
	public void setPhoneReference(String phoneReference) {
		_phoneReference = phoneReference;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneReference",
						String.class);

				method.invoke(_esfStockistRemoteModel, phoneReference);
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

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfStockistRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOther() {
		return _other;
	}

	@Override
	public void setOther(String other) {
		_other = other;

		if (_esfStockistRemoteModel != null) {
			try {
				Class<?> clazz = _esfStockistRemoteModel.getClass();

				Method method = clazz.getMethod("setOther", String.class);

				method.invoke(_esfStockistRemoteModel, other);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFStockistRemoteModel() {
		return _esfStockistRemoteModel;
	}

	public void setESFStockistRemoteModel(BaseModel<?> esfStockistRemoteModel) {
		_esfStockistRemoteModel = esfStockistRemoteModel;
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

		Class<?> remoteModelClass = _esfStockistRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfStockistRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFStockistLocalServiceUtil.addESFStockist(this);
		}
		else {
			ESFStockistLocalServiceUtil.updateESFStockist(this);
		}
	}

	@Override
	public ESFStockist toEscapedModel() {
		return (ESFStockist)ProxyUtil.newProxyInstance(ESFStockist.class.getClassLoader(),
			new Class[] { ESFStockist.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFStockistClp clone = new ESFStockistClp();

		clone.setEsfStockistId(getEsfStockistId());
		clone.setName(getName());
		clone.setEmail(getEmail());
		clone.setPhone(getPhone());
		clone.setAddress(getAddress());
		clone.setNameReference(getNameReference());
		clone.setLastNameReference(getLastNameReference());
		clone.setEmailReference(getEmailReference());
		clone.setPhoneReference(getPhoneReference());
		clone.setDescription(getDescription());
		clone.setOther(getOther());

		return clone;
	}

	@Override
	public int compareTo(ESFStockist esfStockist) {
		long primaryKey = esfStockist.getPrimaryKey();

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

		if (!(obj instanceof ESFStockistClp)) {
			return false;
		}

		ESFStockistClp esfStockist = (ESFStockistClp)obj;

		long primaryKey = esfStockist.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{esfStockistId=");
		sb.append(getEsfStockistId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", nameReference=");
		sb.append(getNameReference());
		sb.append(", lastNameReference=");
		sb.append(getLastNameReference());
		sb.append(", emailReference=");
		sb.append(getEmailReference());
		sb.append(", phoneReference=");
		sb.append(getPhoneReference());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", other=");
		sb.append(getOther());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFStockist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfStockistId</column-name><column-value><![CDATA[");
		sb.append(getEsfStockistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameReference</column-name><column-value><![CDATA[");
		sb.append(getNameReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastNameReference</column-name><column-value><![CDATA[");
		sb.append(getLastNameReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailReference</column-name><column-value><![CDATA[");
		sb.append(getEmailReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneReference</column-name><column-value><![CDATA[");
		sb.append(getPhoneReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>other</column-name><column-value><![CDATA[");
		sb.append(getOther());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfStockistId;
	private String _name;
	private String _email;
	private String _phone;
	private String _address;
	private String _nameReference;
	private String _lastNameReference;
	private String _emailReference;
	private String _phoneReference;
	private String _description;
	private String _other;
	private BaseModel<?> _esfStockistRemoteModel;
}