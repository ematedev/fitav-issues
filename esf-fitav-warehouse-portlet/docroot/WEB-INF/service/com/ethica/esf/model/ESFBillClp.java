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
import com.ethica.esf.service.ESFBillLocalServiceUtil;

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
public class ESFBillClp extends BaseModelImpl<ESFBill> implements ESFBill {
	public ESFBillClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFBill.class;
	}

	@Override
	public String getModelClassName() {
		return ESFBill.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfBillId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfBillId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfBillId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfBillId", getEsfBillId());
		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfOrderId", getEsfOrderId());
		attributes.put("billNumber", getBillNumber());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfBillId = (Long)attributes.get("esfBillId");

		if (esfBillId != null) {
			setEsfBillId(esfBillId);
		}

		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfOrderId = (Long)attributes.get("esfOrderId");

		if (esfOrderId != null) {
			setEsfOrderId(esfOrderId);
		}

		String billNumber = (String)attributes.get("billNumber");

		if (billNumber != null) {
			setBillNumber(billNumber);
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
	}

	@Override
	public long getEsfBillId() {
		return _esfBillId;
	}

	@Override
	public void setEsfBillId(long esfBillId) {
		_esfBillId = esfBillId;

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfBillId", long.class);

				method.invoke(_esfBillRemoteModel, esfBillId);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfBillRemoteModel, esfArticleId);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrderId", long.class);

				method.invoke(_esfBillRemoteModel, esfOrderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillNumber() {
		return _billNumber;
	}

	@Override
	public void setBillNumber(String billNumber) {
		_billNumber = billNumber;

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setBillNumber", String.class);

				method.invoke(_esfBillRemoteModel, billNumber);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setXxxlQty", long.class);

				method.invoke(_esfBillRemoteModel, xxxlQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setXxlQty", long.class);

				method.invoke(_esfBillRemoteModel, xxlQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setXlQty", long.class);

				method.invoke(_esfBillRemoteModel, xlQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setLQty", long.class);

				method.invoke(_esfBillRemoteModel, lQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setMQty", long.class);

				method.invoke(_esfBillRemoteModel, mQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setSQty", long.class);

				method.invoke(_esfBillRemoteModel, sQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setXsQty", long.class);

				method.invoke(_esfBillRemoteModel, xsQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setXxsQty", long.class);

				method.invoke(_esfBillRemoteModel, xxsQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherQty", long.class);

				method.invoke(_esfBillRemoteModel, otherQty);
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

		if (_esfBillRemoteModel != null) {
			try {
				Class<?> clazz = _esfBillRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalQty", long.class);

				method.invoke(_esfBillRemoteModel, totalQty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFBillRemoteModel() {
		return _esfBillRemoteModel;
	}

	public void setESFBillRemoteModel(BaseModel<?> esfBillRemoteModel) {
		_esfBillRemoteModel = esfBillRemoteModel;
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

		Class<?> remoteModelClass = _esfBillRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfBillRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFBillLocalServiceUtil.addESFBill(this);
		}
		else {
			ESFBillLocalServiceUtil.updateESFBill(this);
		}
	}

	@Override
	public ESFBill toEscapedModel() {
		return (ESFBill)ProxyUtil.newProxyInstance(ESFBill.class.getClassLoader(),
			new Class[] { ESFBill.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFBillClp clone = new ESFBillClp();

		clone.setEsfBillId(getEsfBillId());
		clone.setEsfArticleId(getEsfArticleId());
		clone.setEsfOrderId(getEsfOrderId());
		clone.setBillNumber(getBillNumber());
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

		return clone;
	}

	@Override
	public int compareTo(ESFBill esfBill) {
		long primaryKey = esfBill.getPrimaryKey();

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

		if (!(obj instanceof ESFBillClp)) {
			return false;
		}

		ESFBillClp esfBill = (ESFBillClp)obj;

		long primaryKey = esfBill.getPrimaryKey();

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

		sb.append("{esfBillId=");
		sb.append(getEsfBillId());
		sb.append(", esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", esfOrderId=");
		sb.append(getEsfOrderId());
		sb.append(", billNumber=");
		sb.append(getBillNumber());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFBill");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfBillId</column-name><column-value><![CDATA[");
		sb.append(getEsfBillId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrderId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billNumber</column-name><column-value><![CDATA[");
		sb.append(getBillNumber());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfBillId;
	private long _esfArticleId;
	private long _esfOrderId;
	private String _billNumber;
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
	private BaseModel<?> _esfBillRemoteModel;
}