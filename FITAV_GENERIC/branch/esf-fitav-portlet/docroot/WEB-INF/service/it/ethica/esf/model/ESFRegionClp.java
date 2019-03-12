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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFRegionPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRegionClp extends BaseModelImpl<ESFRegion> implements ESFRegion {
	public ESFRegionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRegion.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRegion.class.getName();
	}

	@Override
	public ESFRegionPK getPrimaryKey() {
		return new ESFRegionPK(_idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKey(ESFRegionPK primaryKey) {
		setIdRegion(primaryKey.idRegion);
		setIdCountry(primaryKey.idCountry);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFRegionPK(_idRegion, _idCountry);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFRegionPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idRegion = (String)attributes.get("idRegion");

		if (idRegion != null) {
			setIdRegion(idRegion);
		}

		String idCountry = (String)attributes.get("idCountry");

		if (idCountry != null) {
			setIdCountry(idCountry);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public String getIdRegion() {
		return _idRegion;
	}

	@Override
	public void setIdRegion(String idRegion) {
		_idRegion = idRegion;

		if (_esfRegionRemoteModel != null) {
			try {
				Class<?> clazz = _esfRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setIdRegion", String.class);

				method.invoke(_esfRegionRemoteModel, idRegion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdCountry() {
		return _idCountry;
	}

	@Override
	public void setIdCountry(String idCountry) {
		_idCountry = idCountry;

		if (_esfRegionRemoteModel != null) {
			try {
				Class<?> clazz = _esfRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setIdCountry", String.class);

				method.invoke(_esfRegionRemoteModel, idCountry);
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

		if (_esfRegionRemoteModel != null) {
			try {
				Class<?> clazz = _esfRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfRegionRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRegionRemoteModel() {
		return _esfRegionRemoteModel;
	}

	public void setESFRegionRemoteModel(BaseModel<?> esfRegionRemoteModel) {
		_esfRegionRemoteModel = esfRegionRemoteModel;
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

		Class<?> remoteModelClass = _esfRegionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRegionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRegionLocalServiceUtil.addESFRegion(this);
		}
		else {
			ESFRegionLocalServiceUtil.updateESFRegion(this);
		}
	}

	@Override
	public ESFRegion toEscapedModel() {
		return (ESFRegion)ProxyUtil.newProxyInstance(ESFRegion.class.getClassLoader(),
			new Class[] { ESFRegion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRegionClp clone = new ESFRegionClp();

		clone.setIdRegion(getIdRegion());
		clone.setIdCountry(getIdCountry());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(ESFRegion esfRegion) {
		int value = 0;

		value = getName().compareTo(esfRegion.getName());

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

		if (!(obj instanceof ESFRegionClp)) {
			return false;
		}

		ESFRegionClp esfRegion = (ESFRegionClp)obj;

		ESFRegionPK primaryKey = esfRegion.getPrimaryKey();

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

		sb.append("{idRegion=");
		sb.append(getIdRegion());
		sb.append(", idCountry=");
		sb.append(getIdCountry());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRegion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idRegion</column-name><column-value><![CDATA[");
		sb.append(getIdRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCountry</column-name><column-value><![CDATA[");
		sb.append(getIdCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _idRegion;
	private String _idCountry;
	private String _name;
	private BaseModel<?> _esfRegionRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}