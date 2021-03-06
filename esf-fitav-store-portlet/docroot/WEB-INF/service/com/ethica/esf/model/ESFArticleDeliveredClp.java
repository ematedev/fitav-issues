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
import com.ethica.esf.service.ESFArticleDeliveredLocalServiceUtil;

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
public class ESFArticleDeliveredClp extends BaseModelImpl<ESFArticleDelivered>
	implements ESFArticleDelivered {
	public ESFArticleDeliveredClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticleDelivered.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticleDelivered.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfArticleDeliveredId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfArticleDeliveredId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfArticleDeliveredId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleDeliveredId", getEsfArticleDeliveredId());
		attributes.put("data", getData());
		attributes.put("description", getDescription());
		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfShooterId", getEsfShooterId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleDeliveredId = (Long)attributes.get(
				"esfArticleDeliveredId");

		if (esfArticleDeliveredId != null) {
			setEsfArticleDeliveredId(esfArticleDeliveredId);
		}

		Date data = (Date)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfShooterId = (Long)attributes.get("esfShooterId");

		if (esfShooterId != null) {
			setEsfShooterId(esfShooterId);
		}

		Long xxxlQty = (Long)attributes.get("xxxlQty");

		if (xxxlQty != null) {
			setXxxlQty(xxxlQty);
		}

		Long xxlQty = (Long)attributes.get("xxlQty");

		if (xxlQty != null) {
			setXxlQty(xxlQty);
		}

		Long xlQty = (Long)attributes.get("xlQty");

		if (xlQty != null) {
			setXlQty(xlQty);
		}

		Long lQty = (Long)attributes.get("lQty");

		if (lQty != null) {
			setLQty(lQty);
		}

		Long mQty = (Long)attributes.get("mQty");

		if (mQty != null) {
			setMQty(mQty);
		}

		Long sQty = (Long)attributes.get("sQty");

		if (sQty != null) {
			setSQty(sQty);
		}

		Long xsQty = (Long)attributes.get("xsQty");

		if (xsQty != null) {
			setXsQty(xsQty);
		}

		Long xxsQty = (Long)attributes.get("xxsQty");

		if (xxsQty != null) {
			setXxsQty(xxsQty);
		}

		Long otherQty = (Long)attributes.get("otherQty");

		if (otherQty != null) {
			setOtherQty(otherQty);
		}
	}

	@Override
	public long getEsfArticleDeliveredId() {
		return _esfArticleDeliveredId;
	}

	@Override
	public void setEsfArticleDeliveredId(long esfArticleDeliveredId) {
		_esfArticleDeliveredId = esfArticleDeliveredId;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleDeliveredId",
						long.class);

				method.invoke(_esfArticleDeliveredRemoteModel,
					esfArticleDeliveredId);
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

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setData", Date.class);

				method.invoke(_esfArticleDeliveredRemoteModel, data);
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

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfArticleDeliveredRemoteModel, description);
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

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, esfArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfShooterId() {
		return _esfShooterId;
	}

	@Override
	public void setEsfShooterId(long esfShooterId) {
		_esfShooterId = esfShooterId;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterId", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, esfShooterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXxxlQty() {
		return _xxxlQty;
	}

	@Override
	public void setXxxlQty(long xxxlQty) {
		_xxxlQty = xxxlQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setXxxlQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, xxxlQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXxlQty() {
		return _xxlQty;
	}

	@Override
	public void setXxlQty(long xxlQty) {
		_xxlQty = xxlQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setXxlQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, xxlQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXlQty() {
		return _xlQty;
	}

	@Override
	public void setXlQty(long xlQty) {
		_xlQty = xlQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setXlQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, xlQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLQty() {
		return _lQty;
	}

	@Override
	public void setLQty(long lQty) {
		_lQty = lQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setLQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, lQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMQty() {
		return _mQty;
	}

	@Override
	public void setMQty(long mQty) {
		_mQty = mQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setMQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, mQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSQty() {
		return _sQty;
	}

	@Override
	public void setSQty(long sQty) {
		_sQty = sQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setSQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, sQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXsQty() {
		return _xsQty;
	}

	@Override
	public void setXsQty(long xsQty) {
		_xsQty = xsQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setXsQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, xsQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXxsQty() {
		return _xxsQty;
	}

	@Override
	public void setXxsQty(long xxsQty) {
		_xxsQty = xxsQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setXxsQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, xxsQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOtherQty() {
		return _otherQty;
	}

	@Override
	public void setOtherQty(long otherQty) {
		_otherQty = otherQty;

		if (_esfArticleDeliveredRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleDeliveredRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherQty", long.class);

				method.invoke(_esfArticleDeliveredRemoteModel, otherQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFArticleDeliveredRemoteModel() {
		return _esfArticleDeliveredRemoteModel;
	}

	public void setESFArticleDeliveredRemoteModel(
		BaseModel<?> esfArticleDeliveredRemoteModel) {
		_esfArticleDeliveredRemoteModel = esfArticleDeliveredRemoteModel;
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

		Class<?> remoteModelClass = _esfArticleDeliveredRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfArticleDeliveredRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticleDeliveredLocalServiceUtil.addESFArticleDelivered(this);
		}
		else {
			ESFArticleDeliveredLocalServiceUtil.updateESFArticleDelivered(this);
		}
	}

	@Override
	public ESFArticleDelivered toEscapedModel() {
		return (ESFArticleDelivered)ProxyUtil.newProxyInstance(ESFArticleDelivered.class.getClassLoader(),
			new Class[] { ESFArticleDelivered.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFArticleDeliveredClp clone = new ESFArticleDeliveredClp();

		clone.setEsfArticleDeliveredId(getEsfArticleDeliveredId());
		clone.setData(getData());
		clone.setDescription(getDescription());
		clone.setEsfArticleId(getEsfArticleId());
		clone.setEsfShooterId(getEsfShooterId());
		clone.setXxxlQty(getXxxlQty());
		clone.setXxlQty(getXxlQty());
		clone.setXlQty(getXlQty());
		clone.setLQty(getLQty());
		clone.setMQty(getMQty());
		clone.setSQty(getSQty());
		clone.setXsQty(getXsQty());
		clone.setXxsQty(getXxsQty());
		clone.setOtherQty(getOtherQty());

		return clone;
	}

	@Override
	public int compareTo(ESFArticleDelivered esfArticleDelivered) {
		long primaryKey = esfArticleDelivered.getPrimaryKey();

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

		if (!(obj instanceof ESFArticleDeliveredClp)) {
			return false;
		}

		ESFArticleDeliveredClp esfArticleDelivered = (ESFArticleDeliveredClp)obj;

		long primaryKey = esfArticleDelivered.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{esfArticleDeliveredId=");
		sb.append(getEsfArticleDeliveredId());
		sb.append(", data=");
		sb.append(getData());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", esfShooterId=");
		sb.append(getEsfShooterId());
		sb.append(", xxxlQty=");
		sb.append(getXxxlQty());
		sb.append(", xxlQty=");
		sb.append(getXxlQty());
		sb.append(", xlQty=");
		sb.append(getXlQty());
		sb.append(", lQty=");
		sb.append(getLQty());
		sb.append(", mQty=");
		sb.append(getMQty());
		sb.append(", sQty=");
		sb.append(getSQty());
		sb.append(", xsQty=");
		sb.append(getXsQty());
		sb.append(", xxsQty=");
		sb.append(getXxsQty());
		sb.append(", otherQty=");
		sb.append(getOtherQty());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticleDelivered");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleDeliveredId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleDeliveredId());
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
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxxlQty</column-name><column-value><![CDATA[");
		sb.append(getXxxlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxlQty</column-name><column-value><![CDATA[");
		sb.append(getXxlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xlQty</column-name><column-value><![CDATA[");
		sb.append(getXlQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lQty</column-name><column-value><![CDATA[");
		sb.append(getLQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mQty</column-name><column-value><![CDATA[");
		sb.append(getMQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sQty</column-name><column-value><![CDATA[");
		sb.append(getSQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xsQty</column-name><column-value><![CDATA[");
		sb.append(getXsQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xxsQty</column-name><column-value><![CDATA[");
		sb.append(getXxsQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherQty</column-name><column-value><![CDATA[");
		sb.append(getOtherQty());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfArticleDeliveredId;
	private Date _data;
	private String _description;
	private long _esfArticleId;
	private long _esfShooterId;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
	private BaseModel<?> _esfArticleDeliveredRemoteModel;
}