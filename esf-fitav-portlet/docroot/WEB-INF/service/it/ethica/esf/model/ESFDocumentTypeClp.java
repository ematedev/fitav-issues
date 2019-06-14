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
import it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFDocumentTypeClp extends BaseModelImpl<ESFDocumentType>
	implements ESFDocumentType {
	public ESFDocumentTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocumentType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocumentType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDocumentTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentTypeId", getEsfDocumentTypeId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("expirationMonthsNotice", getExpirationMonthsNotice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentTypeId = (Long)attributes.get("esfDocumentTypeId");

		if (esfDocumentTypeId != null) {
			setEsfDocumentTypeId(esfDocumentTypeId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer expirationMonthsNotice = (Integer)attributes.get(
				"expirationMonthsNotice");

		if (expirationMonthsNotice != null) {
			setExpirationMonthsNotice(expirationMonthsNotice);
		}
	}

	@Override
	public long getEsfDocumentTypeId() {
		return _esfDocumentTypeId;
	}

	@Override
	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentTypeId = esfDocumentTypeId;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDocumentTypeId",
						long.class);

				method.invoke(_esfDocumentTypeRemoteModel, esfDocumentTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfDocumentTypeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfDocumentTypeRemoteModel, modifiedDate);
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

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfDocumentTypeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getExpirationMonthsNotice() {
		return _expirationMonthsNotice;
	}

	@Override
	public void setExpirationMonthsNotice(int expirationMonthsNotice) {
		_expirationMonthsNotice = expirationMonthsNotice;

		if (_esfDocumentTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setExpirationMonthsNotice",
						int.class);

				method.invoke(_esfDocumentTypeRemoteModel,
					expirationMonthsNotice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFDocumentTypeRemoteModel() {
		return _esfDocumentTypeRemoteModel;
	}

	public void setESFDocumentTypeRemoteModel(
		BaseModel<?> esfDocumentTypeRemoteModel) {
		_esfDocumentTypeRemoteModel = esfDocumentTypeRemoteModel;
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

		Class<?> remoteModelClass = _esfDocumentTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfDocumentTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFDocumentTypeLocalServiceUtil.addESFDocumentType(this);
		}
		else {
			ESFDocumentTypeLocalServiceUtil.updateESFDocumentType(this);
		}
	}

	@Override
	public ESFDocumentType toEscapedModel() {
		return (ESFDocumentType)ProxyUtil.newProxyInstance(ESFDocumentType.class.getClassLoader(),
			new Class[] { ESFDocumentType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFDocumentTypeClp clone = new ESFDocumentTypeClp();

		clone.setEsfDocumentTypeId(getEsfDocumentTypeId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDescription(getDescription());
		clone.setExpirationMonthsNotice(getExpirationMonthsNotice());

		return clone;
	}

	@Override
	public int compareTo(ESFDocumentType esfDocumentType) {
		long primaryKey = esfDocumentType.getPrimaryKey();

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

		if (!(obj instanceof ESFDocumentTypeClp)) {
			return false;
		}

		ESFDocumentTypeClp esfDocumentType = (ESFDocumentTypeClp)obj;

		long primaryKey = esfDocumentType.getPrimaryKey();

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

		sb.append("{esfDocumentTypeId=");
		sb.append(getEsfDocumentTypeId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", expirationMonthsNotice=");
		sb.append(getExpirationMonthsNotice());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDocumentType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDocumentTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationMonthsNotice</column-name><column-value><![CDATA[");
		sb.append(getExpirationMonthsNotice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfDocumentTypeId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private int _expirationMonthsNotice;
	private BaseModel<?> _esfDocumentTypeRemoteModel;
}