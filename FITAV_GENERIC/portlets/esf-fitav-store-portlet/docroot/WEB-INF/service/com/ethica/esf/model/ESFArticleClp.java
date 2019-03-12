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
import com.ethica.esf.service.ESFArticleLocalServiceUtil;

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
public class ESFArticleClp extends BaseModelImpl<ESFArticle>
	implements ESFArticle {
	public ESFArticleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfArticleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfArticleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("esfArticleTypeId", getEsfArticleTypeId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());
		attributes.put("price", getPrice());
		attributes.put("tax", getTax());
		attributes.put("sale", getSale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long esfArticleTypeId = (Long)attributes.get("esfArticleTypeId");

		if (esfArticleTypeId != null) {
			setEsfArticleTypeId(esfArticleTypeId);
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

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double tax = (Double)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		Double sale = (Double)attributes.get("sale");

		if (sale != null) {
			setSale(sale);
		}
	}

	@Override
	public long getEsfArticleId() {
		return _esfArticleId;
	}

	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfArticleRemoteModel, esfArticleId);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfArticleRemoteModel, code);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfArticleRemoteModel, name);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfArticleRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfArticleTypeId() {
		return _esfArticleTypeId;
	}

	@Override
	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticleTypeId = esfArticleTypeId;

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleTypeId",
						long.class);

				method.invoke(_esfArticleRemoteModel, esfArticleTypeId);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setXxxlQty", long.class);

				method.invoke(_esfArticleRemoteModel, xxxlQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setXxlQty", long.class);

				method.invoke(_esfArticleRemoteModel, xxlQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setXlQty", long.class);

				method.invoke(_esfArticleRemoteModel, xlQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setLQty", long.class);

				method.invoke(_esfArticleRemoteModel, lQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMQty", long.class);

				method.invoke(_esfArticleRemoteModel, mQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setSQty", long.class);

				method.invoke(_esfArticleRemoteModel, sQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setXsQty", long.class);

				method.invoke(_esfArticleRemoteModel, xsQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setXxsQty", long.class);

				method.invoke(_esfArticleRemoteModel, xxsQty);
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

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherQty", long.class);

				method.invoke(_esfArticleRemoteModel, otherQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_esfArticleRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTax() {
		return _tax;
	}

	@Override
	public void setTax(double tax) {
		_tax = tax;

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setTax", double.class);

				method.invoke(_esfArticleRemoteModel, tax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSale() {
		return _sale;
	}

	@Override
	public void setSale(double sale) {
		_sale = sale;

		if (_esfArticleRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setSale", double.class);

				method.invoke(_esfArticleRemoteModel, sale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFArticleRemoteModel() {
		return _esfArticleRemoteModel;
	}

	public void setESFArticleRemoteModel(BaseModel<?> esfArticleRemoteModel) {
		_esfArticleRemoteModel = esfArticleRemoteModel;
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

		Class<?> remoteModelClass = _esfArticleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfArticleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticleLocalServiceUtil.addESFArticle(this);
		}
		else {
			ESFArticleLocalServiceUtil.updateESFArticle(this);
		}
	}

	@Override
	public ESFArticle toEscapedModel() {
		return (ESFArticle)ProxyUtil.newProxyInstance(ESFArticle.class.getClassLoader(),
			new Class[] { ESFArticle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFArticleClp clone = new ESFArticleClp();

		clone.setEsfArticleId(getEsfArticleId());
		clone.setCode(getCode());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setEsfArticleTypeId(getEsfArticleTypeId());
		clone.setXxxlQty(getXxxlQty());
		clone.setXxlQty(getXxlQty());
		clone.setXlQty(getXlQty());
		clone.setLQty(getLQty());
		clone.setMQty(getMQty());
		clone.setSQty(getSQty());
		clone.setXsQty(getXsQty());
		clone.setXxsQty(getXxsQty());
		clone.setOtherQty(getOtherQty());
		clone.setPrice(getPrice());
		clone.setTax(getTax());
		clone.setSale(getSale());

		return clone;
	}

	@Override
	public int compareTo(ESFArticle esfArticle) {
		long primaryKey = esfArticle.getPrimaryKey();

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

		if (!(obj instanceof ESFArticleClp)) {
			return false;
		}

		ESFArticleClp esfArticle = (ESFArticleClp)obj;

		long primaryKey = esfArticle.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", esfArticleTypeId=");
		sb.append(getEsfArticleTypeId());
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
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", tax=");
		sb.append(getTax());
		sb.append(", sale=");
		sb.append(getSale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfArticleTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleTypeId());
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
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tax</column-name><column-value><![CDATA[");
		sb.append(getTax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sale</column-name><column-value><![CDATA[");
		sb.append(getSale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfArticleId;
	private String _code;
	private String _name;
	private String _description;
	private long _esfArticleTypeId;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
	private double _price;
	private double _tax;
	private double _sale;
	private BaseModel<?> _esfArticleRemoteModel;
}