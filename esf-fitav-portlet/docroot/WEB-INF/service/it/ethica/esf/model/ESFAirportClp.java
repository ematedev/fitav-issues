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
import it.ethica.esf.service.ESFAirportLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFAirportClp extends BaseModelImpl<ESFAirport>
	implements ESFAirport {
	public ESFAirportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAirport.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAirport.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfAirportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfAirportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfAirportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfAirportId", getEsfAirportId());
		attributes.put("name", getName());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfAirportId = (Long)attributes.get("esfAirportId");

		if (esfAirportId != null) {
			setEsfAirportId(esfAirportId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	@Override
	public long getEsfAirportId() {
		return _esfAirportId;
	}

	@Override
	public void setEsfAirportId(long esfAirportId) {
		_esfAirportId = esfAirportId;

		if (_esfAirportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAirportRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfAirportId", long.class);

				method.invoke(_esfAirportRemoteModel, esfAirportId);
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

		if (_esfAirportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAirportRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfAirportRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_esfAirportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAirportRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_esfAirportRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_esfAirportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAirportRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_esfAirportRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFAirportRemoteModel() {
		return _esfAirportRemoteModel;
	}

	public void setESFAirportRemoteModel(BaseModel<?> esfAirportRemoteModel) {
		_esfAirportRemoteModel = esfAirportRemoteModel;
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

		Class<?> remoteModelClass = _esfAirportRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfAirportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFAirportLocalServiceUtil.addESFAirport(this);
		}
		else {
			ESFAirportLocalServiceUtil.updateESFAirport(this);
		}
	}

	@Override
	public ESFAirport toEscapedModel() {
		return (ESFAirport)ProxyUtil.newProxyInstance(ESFAirport.class.getClassLoader(),
			new Class[] { ESFAirport.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFAirportClp clone = new ESFAirportClp();

		clone.setEsfAirportId(getEsfAirportId());
		clone.setName(getName());
		clone.setCity(getCity());
		clone.setCountry(getCountry());

		return clone;
	}

	@Override
	public int compareTo(ESFAirport esfAirport) {
		long primaryKey = esfAirport.getPrimaryKey();

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

		if (!(obj instanceof ESFAirportClp)) {
			return false;
		}

		ESFAirportClp esfAirport = (ESFAirportClp)obj;

		long primaryKey = esfAirport.getPrimaryKey();

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

		sb.append("{esfAirportId=");
		sb.append(getEsfAirportId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAirport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfAirportId</column-name><column-value><![CDATA[");
		sb.append(getEsfAirportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfAirportId;
	private String _name;
	private String _city;
	private String _country;
	private BaseModel<?> _esfAirportRemoteModel;
}