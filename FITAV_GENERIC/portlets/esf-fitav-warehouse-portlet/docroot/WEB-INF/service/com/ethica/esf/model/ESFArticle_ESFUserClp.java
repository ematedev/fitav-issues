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
import com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil;
import com.ethica.esf.service.persistence.ESFArticle_ESFUserPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFArticle_ESFUserClp extends BaseModelImpl<ESFArticle_ESFUser>
	implements ESFArticle_ESFUser {
	public ESFArticle_ESFUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticle_ESFUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticle_ESFUser.class.getName();
	}

	@Override
	public ESFArticle_ESFUserPK getPrimaryKey() {
		return new ESFArticle_ESFUserPK(_esfArticleId, _esfUserId);
	}

	@Override
	public void setPrimaryKey(ESFArticle_ESFUserPK primaryKey) {
		setEsfArticleId(primaryKey.esfArticleId);
		setEsfUserId(primaryKey.esfUserId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFArticle_ESFUserPK(_esfArticleId, _esfUserId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFArticle_ESFUserPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleId", getEsfArticleId());
		attributes.put("esfUserId", getEsfUserId());
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
		attributes.put("description", getDescription());
		attributes.put("deliveryDate", getDeliveryDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleId = (Long)attributes.get("esfArticleId");

		if (esfArticleId != null) {
			setEsfArticleId(esfArticleId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date deliveryDate = (Date)attributes.get("deliveryDate");

		if (deliveryDate != null) {
			setDeliveryDate(deliveryDate);
		}
	}

	@Override
	public long getEsfArticleId() {
		return _esfArticleId;
	}

	@Override
	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleId", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, esfArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public long getXxxlQty() {
		return _xxxlQty;
	}

	@Override
	public void setXxxlQty(long xxxlQty) {
		_xxxlQty = xxxlQty;

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setXxxlQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, xxxlQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setXxlQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, xxlQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setXlQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, xlQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, lQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setMQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, mQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, sQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setXsQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, xsQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setXxsQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, xxsQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, otherQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalQty", long.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, totalQty);
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

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDeliveryDate() {
		return _deliveryDate;
	}

	@Override
	public void setDeliveryDate(Date deliveryDate) {
		_deliveryDate = deliveryDate;

		if (_esfArticle_ESFUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticle_ESFUserRemoteModel.getClass();

				Method method = clazz.getMethod("setDeliveryDate", Date.class);

				method.invoke(_esfArticle_ESFUserRemoteModel, deliveryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFArticle_ESFUserRemoteModel() {
		return _esfArticle_ESFUserRemoteModel;
	}

	public void setESFArticle_ESFUserRemoteModel(
		BaseModel<?> esfArticle_ESFUserRemoteModel) {
		_esfArticle_ESFUserRemoteModel = esfArticle_ESFUserRemoteModel;
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

		Class<?> remoteModelClass = _esfArticle_ESFUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfArticle_ESFUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticle_ESFUserLocalServiceUtil.addESFArticle_ESFUser(this);
		}
		else {
			ESFArticle_ESFUserLocalServiceUtil.updateESFArticle_ESFUser(this);
		}
	}

	@Override
	public ESFArticle_ESFUser toEscapedModel() {
		return (ESFArticle_ESFUser)ProxyUtil.newProxyInstance(ESFArticle_ESFUser.class.getClassLoader(),
			new Class[] { ESFArticle_ESFUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFArticle_ESFUserClp clone = new ESFArticle_ESFUserClp();

		clone.setEsfArticleId(getEsfArticleId());
		clone.setEsfUserId(getEsfUserId());
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
		clone.setDescription(getDescription());
		clone.setDeliveryDate(getDeliveryDate());

		return clone;
	}

	@Override
	public int compareTo(ESFArticle_ESFUser esfArticle_ESFUser) {
		ESFArticle_ESFUserPK primaryKey = esfArticle_ESFUser.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticle_ESFUserClp)) {
			return false;
		}

		ESFArticle_ESFUserClp esfArticle_ESFUser = (ESFArticle_ESFUserClp)obj;

		ESFArticle_ESFUserPK primaryKey = esfArticle_ESFUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{esfArticleId=");
		sb.append(getEsfArticleId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", deliveryDate=");
		sb.append(getDeliveryDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticle_ESFUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliveryDate</column-name><column-value><![CDATA[");
		sb.append(getDeliveryDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfArticleId;
	private long _esfUserId;
	private String _esfUserUuid;
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
	private String _description;
	private Date _deliveryDate;
	private BaseModel<?> _esfArticle_ESFUserRemoteModel;
}