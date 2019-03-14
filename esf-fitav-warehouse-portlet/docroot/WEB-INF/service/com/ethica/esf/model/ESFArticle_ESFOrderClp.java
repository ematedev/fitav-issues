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
import com.ethica.esf.service.ESFArticle_ESFOrderLocalServiceUtil;
import com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK;

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
public class ESFArticle_ESFOrderClp extends BaseModelImpl<ESFArticle_ESFOrder>
	implements ESFArticle_ESFOrder {
	public ESFArticle_ESFOrderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle_ESFOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle_ESFOrder.class.getName();
	}

	@Override
	public ESFArticle_ESFOrderPK getPrimaryKey() {
		return new ESFArticle_ESFOrderPK(_esfArticleId, _esfOrderId);
	}

	@Override
	public void setPrimaryKey(ESFArticle_ESFOrderPK primaryKey) {
		setEsfArticleId(primaryKey.esfArticleId);
		setEsfOrderId(primaryKey.esfOrderId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFArticle_ESFOrderPK(_esfArticleId, _esfOrderId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFArticle_ESFOrderPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("xxxlQty", getXxxlQty());
		attributes.put("xxlQty", getXxlQty());
		attributes.put("xlQty", getXlQty());
		attributes.put("lQty", getLQty());
		attributes.put("mQty", getMQty());
		attributes.put("sQty", getSQty());
		attributes.put("xsQty", getXsQty());
		attributes.put("xxsQty", getXxsQty());
		attributes.put("otherQty", getOtherQty());
		attributes.put("totalQty", getTotalQty());
		attributes.put("price", getPrice());
		attributes.put("vat", getVat());
		attributes.put("sale", getSale());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
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

		Long totalQty = (Long)attributes.get("totalQty");

		if (totalQty != null) {
			setTotalQty(totalQty);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double vat = (Double)attributes.get("vat");

		if (vat != null) {
			setVat(vat);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, esfArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrderId() {
		return _esfOrderId;
	}

	@Override
	public void setEsfOrderId(long esfOrderId) {
		_esfOrderId = esfOrderId;

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrderId", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, esfOrderId);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setXxxlQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, xxxlQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setXxlQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, xxlQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setXlQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, xlQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setLQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, lQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setMQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, mQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setSQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, sQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setXsQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, xsQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setXxsQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, xxsQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, otherQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTotalQty() {
		return _totalQty;
	}

	@Override
	public void setTotalQty(long totalQty) {
		_totalQty = totalQty;

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalQty", long.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, totalQty);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVat() {
		return _vat;
	}

	@Override
	public void setVat(double vat) {
		_vat = vat;

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setVat", double.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, vat);
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

		if (_esfArticle_ESFOrderRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setSale", double.class);

				method.invoke(_esfArticle_ESFOrderRemoteModel, sale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFArticle_ESFOrderRemoteModel() {
		return _esfArticle_ESFOrderRemoteModel;
	}

	public void setESFArticle_ESFOrderRemoteModel(
		BaseModel<?> esfArticle_ESFOrderRemoteModel) {
		_esfArticle_ESFOrderRemoteModel = esfArticle_ESFOrderRemoteModel;
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

		Class<?> remoteModelClass = _esfArticle_ESFOrderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfArticle_ESFOrderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticle_ESFOrderLocalServiceUtil.addESFArticle_ESFOrder(this);
		}
		else {
			ESFArticle_ESFOrderLocalServiceUtil.updateESFArticle_ESFOrder(this);
		}
	}

	@Override
	public ESFArticle_ESFOrder toEscapedModel() {
		return (ESFArticle_ESFOrder)ProxyUtil.newProxyInstance(ESFArticle_ESFOrder.class.getClassLoader(),
			new Class[] { ESFArticle_ESFOrder.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFArticle_ESFOrderClp clone = new ESFArticle_ESFOrderClp();

		clone.setEsfArticleId(getEsfArticleId());
		clone.setEsfOrderId(getEsfOrderId());
		clone.setXxxlQty(getXxxlQty());
		clone.setXxlQty(getXxlQty());
		clone.setXlQty(getXlQty());
		clone.setLQty(getLQty());
		clone.setMQty(getMQty());
		clone.setSQty(getSQty());
		clone.setXsQty(getXsQty());
		clone.setXxsQty(getXxsQty());
		clone.setOtherQty(getOtherQty());
		clone.setTotalQty(getTotalQty());
		clone.setPrice(getPrice());
		clone.setVat(getVat());
		clone.setSale(getSale());

		return clone;
	}

	@Override
	public int compareTo(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		ESFArticle_ESFOrderPK primaryKey = esfArticle_ESFOrder.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticle_ESFOrderClp)) {
			return false;
		}

		ESFArticle_ESFOrderClp esfArticle_ESFOrder = (ESFArticle_ESFOrderClp)obj;

		ESFArticle_ESFOrderPK primaryKey = esfArticle_ESFOrder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", esfOrderId=");
		sb.append(getEsfOrderId());
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
		sb.append(", totalQty=");
		sb.append(getTotalQty());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", vat=");
		sb.append(getVat());
		sb.append(", sale=");
		sb.append(getSale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticle_ESFOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrderId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrderId());
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
			"<column><column-name>totalQty</column-name><column-value><![CDATA[");
		sb.append(getTotalQty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vat</column-name><column-value><![CDATA[");
		sb.append(getVat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sale</column-name><column-value><![CDATA[");
		sb.append(getSale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfArticleId;
	private long _esfOrderId;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
	private long _totalQty;
	private double _price;
	private double _vat;
	private double _sale;
	private BaseModel<?> _esfArticle_ESFOrderRemoteModel;
}