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
import it.ethica.esf.service.ESFFieldESFElectronicLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFieldESFElectronicClp extends BaseModelImpl<ESFFieldESFElectronic>
	implements ESFFieldESFElectronic {
	public ESFFieldESFElectronicClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFieldESFElectronic.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFieldESFElectronic.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("brandId", getBrandId());
		attributes.put("electronicId", getElectronicId());
		attributes.put("fieldId", getFieldId());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long electronicId = (Long)attributes.get("electronicId");

		if (electronicId != null) {
			setElectronicId(electronicId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_esfFieldESFElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldESFElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_esfFieldESFElectronicRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBrandId() {
		return _brandId;
	}

	@Override
	public void setBrandId(long brandId) {
		_brandId = brandId;

		if (_esfFieldESFElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldESFElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setBrandId", long.class);

				method.invoke(_esfFieldESFElectronicRemoteModel, brandId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getElectronicId() {
		return _electronicId;
	}

	@Override
	public void setElectronicId(long electronicId) {
		_electronicId = electronicId;

		if (_esfFieldESFElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldESFElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setElectronicId", long.class);

				method.invoke(_esfFieldESFElectronicRemoteModel, electronicId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFieldId() {
		return _fieldId;
	}

	@Override
	public void setFieldId(long fieldId) {
		_fieldId = fieldId;

		if (_esfFieldESFElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldESFElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setFieldId", long.class);

				method.invoke(_esfFieldESFElectronicRemoteModel, fieldId);
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

		if (_esfFieldESFElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldESFElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfFieldESFElectronicRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFFieldESFElectronicRemoteModel() {
		return _esfFieldESFElectronicRemoteModel;
	}

	public void setESFFieldESFElectronicRemoteModel(
		BaseModel<?> esfFieldESFElectronicRemoteModel) {
		_esfFieldESFElectronicRemoteModel = esfFieldESFElectronicRemoteModel;
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

		Class<?> remoteModelClass = _esfFieldESFElectronicRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFieldESFElectronicRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFieldESFElectronicLocalServiceUtil.addESFFieldESFElectronic(this);
		}
		else {
			ESFFieldESFElectronicLocalServiceUtil.updateESFFieldESFElectronic(this);
		}
	}

	@Override
	public ESFFieldESFElectronic toEscapedModel() {
		return (ESFFieldESFElectronic)ProxyUtil.newProxyInstance(ESFFieldESFElectronic.class.getClassLoader(),
			new Class[] { ESFFieldESFElectronic.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFieldESFElectronicClp clone = new ESFFieldESFElectronicClp();

		clone.setId(getId());
		clone.setBrandId(getBrandId());
		clone.setElectronicId(getElectronicId());
		clone.setFieldId(getFieldId());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(ESFFieldESFElectronic esfFieldESFElectronic) {
		long primaryKey = esfFieldESFElectronic.getPrimaryKey();

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

		if (!(obj instanceof ESFFieldESFElectronicClp)) {
			return false;
		}

		ESFFieldESFElectronicClp esfFieldESFElectronic = (ESFFieldESFElectronicClp)obj;

		long primaryKey = esfFieldESFElectronic.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", brandId=");
		sb.append(getBrandId());
		sb.append(", electronicId=");
		sb.append(getElectronicId());
		sb.append(", fieldId=");
		sb.append(getFieldId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFieldESFElectronic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brandId</column-name><column-value><![CDATA[");
		sb.append(getBrandId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>electronicId</column-name><column-value><![CDATA[");
		sb.append(getElectronicId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldId</column-name><column-value><![CDATA[");
		sb.append(getFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _brandId;
	private long _electronicId;
	private long _fieldId;
	private String _description;
	private BaseModel<?> _esfFieldESFElectronicRemoteModel;
}