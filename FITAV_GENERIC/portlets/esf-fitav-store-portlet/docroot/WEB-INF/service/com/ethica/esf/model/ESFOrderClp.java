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
import com.ethica.esf.service.ESFOrderLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFOrderClp extends BaseModelImpl<ESFOrder> implements ESFOrder {
	public ESFOrderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrder.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfOrderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfOrderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfOrderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("code", getCode());
		attributes.put("data", getData());
		attributes.put("description", getDescription());
		attributes.put("esfStockistId", getEsfStockistId());
		attributes.put("qty", getQty());
		attributes.put("esfArticleId", getEsfArticleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfStockistId = (Long)attributes.get("esfStockistId");

		if (esfStockistId != null) {
			setEsfStockistId(esfStockistId);
		}

		Long qty = (Long)attributes.get("qty");

		if (qty != null) {
			setQty(qty);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}
	}

	@Override
	public long getEsfOrderId() {
		return _esfOrderId;
	}

	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfOrderId = esfOrderId;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrderId", long.class);

				method.invoke(_esfOrderRemoteModel, esfOrderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfOrderRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getData() {
		return _data;
	}

	@Override
	public void setData(Date data) {
		_data = data;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setData", Date.class);

				method.invoke(_esfOrderRemoteModel, data);
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

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfOrderRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfStockistId() {
		return _esfStockistId;
	}

	@Override
	public void setEsfStockistId(long esfStockistId) {
		_esfStockistId = esfStockistId;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStockistId", long.class);

				method.invoke(_esfOrderRemoteModel, esfStockistId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQty() {
		return _qty;
	}

	@Override
	public void setQty(long qty) {
		_qty = qty;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setQty", long.class);

				method.invoke(_esfOrderRemoteModel, qty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfArticleId() {
		return _esfArticleId;
	}

	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;

		if (_esfOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfOrderRemoteModel, esfArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFOrderRemoteModel() {
		return _esfOrderRemoteModel;
	}

	public void setESFOrderRemoteModel(BaseModel<?> esfOrderRemoteModel) {
		_esfOrderRemoteModel = esfOrderRemoteModel;
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

		Class<?> remoteModelClass = _esfOrderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfOrderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFOrderLocalServiceUtil.addESFOrder(this);
		}
		else {
			ESFOrderLocalServiceUtil.updateESFOrder(this);
		}
	}

	@Override
	public ESFOrder toEscapedModel() {
		return (ESFOrder)ProxyUtil.newProxyInstance(ESFOrder.class.getClassLoader(),
			new Class[] { ESFOrder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFOrderClp clone = new ESFOrderClp();

		clone.setEsfOrderId(getEsfOrderId());
		clone.setCode(getCode());
		clone.setData(getData());
		clone.setDescription(getDescription());
		clone.setEsfStockistId(getEsfStockistId());
		clone.setQty(getQty());
		clone.setEsfArticleId(getEsfArticleId());

		return clone;
	}

	@Override
	public int compareTo(ESFOrder esfOrder) {
		long primaryKey = esfOrder.getPrimaryKey();

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

		if (!(obj instanceof ESFOrderClp)) {
			return false;
		}

		ESFOrderClp esfOrder = (ESFOrderClp)obj;

		long primaryKey = esfOrder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{esfOrderId=");
		sb.append(getEsfOrderId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", data=");
		sb.append(getData());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", esfStockistId=");
		sb.append(getEsfStockistId());
		sb.append(", qty=");
		sb.append(getQty());
		sb.append(", esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfOrderId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfStockistId</column-name><column-value><![CDATA[");
		sb.append(getEsfStockistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qty</column-name><column-value><![CDATA[");
		sb.append(getQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfOrderId;
	private String _code;
	private Date _data;
	private String _description;
	private long _esfStockistId;
	private long _qty;
	private long _esfArticleId;
	private BaseModel<?> _esfOrderRemoteModel;
}