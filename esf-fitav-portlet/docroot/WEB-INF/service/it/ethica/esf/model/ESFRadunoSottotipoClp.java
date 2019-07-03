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
import it.ethica.esf.service.ESFRadunoSottotipoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoSottotipoClp extends BaseModelImpl<ESFRadunoSottotipo>
	implements ESFRadunoSottotipo {
	public ESFRadunoSottotipoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoSottotipo.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoSottotipo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_esf_raduno_sottotipo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_esf_raduno_sottotipo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_esf_raduno_sottotipo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_sottotipo", getId_esf_raduno_sottotipo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_sottotipo = (Long)attributes.get(
				"id_esf_raduno_sottotipo");

		if (id_esf_raduno_sottotipo != null) {
			setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public long getId_esf_raduno_sottotipo() {
		return _id_esf_raduno_sottotipo;
	}

	@Override
	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_id_esf_raduno_sottotipo = id_esf_raduno_sottotipo;

		if (_esfRadunoSottotipoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoSottotipoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_sottotipo",
						long.class);

				method.invoke(_esfRadunoSottotipoRemoteModel,
					id_esf_raduno_sottotipo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescrizione() {
		return _descrizione;
	}

	@Override
	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;

		if (_esfRadunoSottotipoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoSottotipoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_esfRadunoSottotipoRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoSottotipoRemoteModel() {
		return _esfRadunoSottotipoRemoteModel;
	}

	public void setESFRadunoSottotipoRemoteModel(
		BaseModel<?> esfRadunoSottotipoRemoteModel) {
		_esfRadunoSottotipoRemoteModel = esfRadunoSottotipoRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoSottotipoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoSottotipoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoSottotipoLocalServiceUtil.addESFRadunoSottotipo(this);
		}
		else {
			ESFRadunoSottotipoLocalServiceUtil.updateESFRadunoSottotipo(this);
		}
	}

	@Override
	public ESFRadunoSottotipo toEscapedModel() {
		return (ESFRadunoSottotipo)ProxyUtil.newProxyInstance(ESFRadunoSottotipo.class.getClassLoader(),
			new Class[] { ESFRadunoSottotipo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoSottotipoClp clone = new ESFRadunoSottotipoClp();

		clone.setId_esf_raduno_sottotipo(getId_esf_raduno_sottotipo());
		clone.setDescrizione(getDescrizione());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoSottotipo esfRadunoSottotipo) {
		long primaryKey = esfRadunoSottotipo.getPrimaryKey();

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

		if (!(obj instanceof ESFRadunoSottotipoClp)) {
			return false;
		}

		ESFRadunoSottotipoClp esfRadunoSottotipo = (ESFRadunoSottotipoClp)obj;

		long primaryKey = esfRadunoSottotipo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{id_esf_raduno_sottotipo=");
		sb.append(getId_esf_raduno_sottotipo());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoSottotipo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_sottotipo</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_sottotipo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_sottotipo;
	private String _descrizione;
	private BaseModel<?> _esfRadunoSottotipoRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}