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
import it.ethica.esf.service.ESFRadunoSottotipiRadunoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoSottotipiRadunoClp extends BaseModelImpl<ESFRadunoSottotipiRaduno>
	implements ESFRadunoSottotipiRaduno {
	public ESFRadunoSottotipiRadunoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoSottotipiRaduno.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoSottotipiRaduno.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_esf_raduno_sottotipi_raduno;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_esf_raduno_sottotipi_raduno(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_esf_raduno_sottotipi_raduno;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_sottotipi_raduno",
			getId_esf_raduno_sottotipi_raduno());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("id_esf_raduno_sottotipo", getId_esf_raduno_sottotipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_sottotipi_raduno = (Long)attributes.get(
				"id_esf_raduno_sottotipi_raduno");

		if (id_esf_raduno_sottotipi_raduno != null) {
			setId_esf_raduno_sottotipi_raduno(id_esf_raduno_sottotipi_raduno);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long id_esf_raduno_sottotipo = (Long)attributes.get(
				"id_esf_raduno_sottotipo");

		if (id_esf_raduno_sottotipo != null) {
			setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
		}
	}

	@Override
	public long getId_esf_raduno_sottotipi_raduno() {
		return _id_esf_raduno_sottotipi_raduno;
	}

	@Override
	public void setId_esf_raduno_sottotipi_raduno(
		long id_esf_raduno_sottotipi_raduno) {
		_id_esf_raduno_sottotipi_raduno = id_esf_raduno_sottotipi_raduno;

		if (_esfRadunoSottotipiRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoSottotipiRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_sottotipi_raduno",
						long.class);

				method.invoke(_esfRadunoSottotipiRadunoRemoteModel,
					id_esf_raduno_sottotipi_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;

		if (_esfRadunoSottotipiRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoSottotipiRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoSottotipiRadunoRemoteModel,
					id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_esf_raduno_sottotipo() {
		return _id_esf_raduno_sottotipo;
	}

	@Override
	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_id_esf_raduno_sottotipo = id_esf_raduno_sottotipo;

		if (_esfRadunoSottotipiRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoSottotipiRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_sottotipo",
						long.class);

				method.invoke(_esfRadunoSottotipiRadunoRemoteModel,
					id_esf_raduno_sottotipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoSottotipiRadunoRemoteModel() {
		return _esfRadunoSottotipiRadunoRemoteModel;
	}

	public void setESFRadunoSottotipiRadunoRemoteModel(
		BaseModel<?> esfRadunoSottotipiRadunoRemoteModel) {
		_esfRadunoSottotipiRadunoRemoteModel = esfRadunoSottotipiRadunoRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoSottotipiRadunoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoSottotipiRadunoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoSottotipiRadunoLocalServiceUtil.addESFRadunoSottotipiRaduno(this);
		}
		else {
			ESFRadunoSottotipiRadunoLocalServiceUtil.updateESFRadunoSottotipiRaduno(this);
		}
	}

	@Override
	public ESFRadunoSottotipiRaduno toEscapedModel() {
		return (ESFRadunoSottotipiRaduno)ProxyUtil.newProxyInstance(ESFRadunoSottotipiRaduno.class.getClassLoader(),
			new Class[] { ESFRadunoSottotipiRaduno.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoSottotipiRadunoClp clone = new ESFRadunoSottotipiRadunoClp();

		clone.setId_esf_raduno_sottotipi_raduno(getId_esf_raduno_sottotipi_raduno());
		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setId_esf_raduno_sottotipo(getId_esf_raduno_sottotipo());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		long primaryKey = esfRadunoSottotipiRaduno.getPrimaryKey();

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

		if (!(obj instanceof ESFRadunoSottotipiRadunoClp)) {
			return false;
		}

		ESFRadunoSottotipiRadunoClp esfRadunoSottotipiRaduno = (ESFRadunoSottotipiRadunoClp)obj;

		long primaryKey = esfRadunoSottotipiRaduno.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_sottotipi_raduno=");
		sb.append(getId_esf_raduno_sottotipi_raduno());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", id_esf_raduno_sottotipo=");
		sb.append(getId_esf_raduno_sottotipo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoSottotipiRaduno");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_sottotipi_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_sottotipi_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno_sottotipo</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_sottotipo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_sottotipi_raduno;
	private long _id_esf_raduno;
	private long _id_esf_raduno_sottotipo;
	private BaseModel<?> _esfRadunoSottotipiRadunoRemoteModel;
}