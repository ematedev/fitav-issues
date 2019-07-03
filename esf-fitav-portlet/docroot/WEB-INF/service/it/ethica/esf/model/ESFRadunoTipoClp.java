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
import it.ethica.esf.service.ESFRadunoTipoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoTipoClp extends BaseModelImpl<ESFRadunoTipo>
	implements ESFRadunoTipo {
	public ESFRadunoTipoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoTipo.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoTipo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_esf_raduno_tipo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_esf_raduno_tipo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_esf_raduno_tipo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_tipo", getId_esf_raduno_tipo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_tipo = (Long)attributes.get("id_esf_raduno_tipo");

		if (id_esf_raduno_tipo != null) {
			setId_esf_raduno_tipo(id_esf_raduno_tipo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public long getId_esf_raduno_tipo() {
		return _id_esf_raduno_tipo;
	}

	@Override
	public void setId_esf_raduno_tipo(long id_esf_raduno_tipo) {
		_id_esf_raduno_tipo = id_esf_raduno_tipo;

		if (_esfRadunoTipoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoTipoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_tipo",
						long.class);

				method.invoke(_esfRadunoTipoRemoteModel, id_esf_raduno_tipo);
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

		if (_esfRadunoTipoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoTipoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescrizione", String.class);

				method.invoke(_esfRadunoTipoRemoteModel, descrizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoTipoRemoteModel() {
		return _esfRadunoTipoRemoteModel;
	}

	public void setESFRadunoTipoRemoteModel(
		BaseModel<?> esfRadunoTipoRemoteModel) {
		_esfRadunoTipoRemoteModel = esfRadunoTipoRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoTipoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoTipoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoTipoLocalServiceUtil.addESFRadunoTipo(this);
		}
		else {
			ESFRadunoTipoLocalServiceUtil.updateESFRadunoTipo(this);
		}
	}

	@Override
	public ESFRadunoTipo toEscapedModel() {
		return (ESFRadunoTipo)ProxyUtil.newProxyInstance(ESFRadunoTipo.class.getClassLoader(),
			new Class[] { ESFRadunoTipo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoTipoClp clone = new ESFRadunoTipoClp();

		clone.setId_esf_raduno_tipo(getId_esf_raduno_tipo());
		clone.setDescrizione(getDescrizione());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoTipo esfRadunoTipo) {
		long primaryKey = esfRadunoTipo.getPrimaryKey();

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

		if (!(obj instanceof ESFRadunoTipoClp)) {
			return false;
		}

		ESFRadunoTipoClp esfRadunoTipo = (ESFRadunoTipoClp)obj;

		long primaryKey = esfRadunoTipo.getPrimaryKey();

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

		sb.append("{id_esf_raduno_tipo=");
		sb.append(getId_esf_raduno_tipo());
		sb.append(", descrizione=");
		sb.append(getDescrizione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoTipo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_tipo</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_tipo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descrizione</column-name><column-value><![CDATA[");
		sb.append(getDescrizione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_tipo;
	private String _descrizione;
	private BaseModel<?> _esfRadunoTipoRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}