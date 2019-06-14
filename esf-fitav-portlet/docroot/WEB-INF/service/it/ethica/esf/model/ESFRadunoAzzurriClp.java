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
import it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFRadunoAzzurriPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoAzzurriClp extends BaseModelImpl<ESFRadunoAzzurri>
	implements ESFRadunoAzzurri {
	public ESFRadunoAzzurriClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoAzzurri.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoAzzurri.class.getName();
	}

	@Override
	public ESFRadunoAzzurriPK getPrimaryKey() {
		return new ESFRadunoAzzurriPK(_id_esf_raduno_azzurri, _id_esf_raduno);
	}

	@Override
	public void setPrimaryKey(ESFRadunoAzzurriPK primaryKey) {
		setId_esf_raduno_azzurri(primaryKey.id_esf_raduno_azzurri);
		setId_esf_raduno(primaryKey.id_esf_raduno);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFRadunoAzzurriPK(_id_esf_raduno_azzurri, _id_esf_raduno);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFRadunoAzzurriPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_azzurri", getId_esf_raduno_azzurri());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("esf_national_id", getEsf_national_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_azzurri = (Long)attributes.get(
				"id_esf_raduno_azzurri");

		if (id_esf_raduno_azzurri != null) {
			setId_esf_raduno_azzurri(id_esf_raduno_azzurri);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long esf_national_id = (Long)attributes.get("esf_national_id");

		if (esf_national_id != null) {
			setEsf_national_id(esf_national_id);
		}
	}

	@Override
	public long getId_esf_raduno_azzurri() {
		return _id_esf_raduno_azzurri;
	}

	@Override
	public void setId_esf_raduno_azzurri(long id_esf_raduno_azzurri) {
		_id_esf_raduno_azzurri = id_esf_raduno_azzurri;

		if (_esfRadunoAzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoAzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_azzurri",
						long.class);

				method.invoke(_esfRadunoAzzurriRemoteModel,
					id_esf_raduno_azzurri);
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

		if (_esfRadunoAzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoAzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoAzzurriRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsf_national_id() {
		return _esf_national_id;
	}

	@Override
	public void setEsf_national_id(long esf_national_id) {
		_esf_national_id = esf_national_id;

		if (_esfRadunoAzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoAzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setEsf_national_id", long.class);

				method.invoke(_esfRadunoAzzurriRemoteModel, esf_national_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoAzzurriRemoteModel() {
		return _esfRadunoAzzurriRemoteModel;
	}

	public void setESFRadunoAzzurriRemoteModel(
		BaseModel<?> esfRadunoAzzurriRemoteModel) {
		_esfRadunoAzzurriRemoteModel = esfRadunoAzzurriRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoAzzurriRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoAzzurriRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoAzzurriLocalServiceUtil.addESFRadunoAzzurri(this);
		}
		else {
			ESFRadunoAzzurriLocalServiceUtil.updateESFRadunoAzzurri(this);
		}
	}

	@Override
	public ESFRadunoAzzurri toEscapedModel() {
		return (ESFRadunoAzzurri)ProxyUtil.newProxyInstance(ESFRadunoAzzurri.class.getClassLoader(),
			new Class[] { ESFRadunoAzzurri.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoAzzurriClp clone = new ESFRadunoAzzurriClp();

		clone.setId_esf_raduno_azzurri(getId_esf_raduno_azzurri());
		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setEsf_national_id(getEsf_national_id());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoAzzurri esfRadunoAzzurri) {
		ESFRadunoAzzurriPK primaryKey = esfRadunoAzzurri.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoAzzurriClp)) {
			return false;
		}

		ESFRadunoAzzurriClp esfRadunoAzzurri = (ESFRadunoAzzurriClp)obj;

		ESFRadunoAzzurriPK primaryKey = esfRadunoAzzurri.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_azzurri=");
		sb.append(getId_esf_raduno_azzurri());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", esf_national_id=");
		sb.append(getEsf_national_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoAzzurri");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_azzurri</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_azzurri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esf_national_id</column-name><column-value><![CDATA[");
		sb.append(getEsf_national_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_azzurri;
	private long _id_esf_raduno;
	private long _esf_national_id;
	private BaseModel<?> _esfRadunoAzzurriRemoteModel;
}