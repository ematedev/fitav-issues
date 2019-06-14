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
import it.ethica.esf.service.ESFFornitureUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFornitureUserClp extends BaseModelImpl<ESFFornitureUser>
	implements ESFFornitureUser {
	public ESFFornitureUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFornitureUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFornitureUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfFornitureUserID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfFornitureUserID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfFornitureUserID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfIDForniture", getEsfIDForniture());
		attributes.put("esfIdUser", getEsfIdUser());
		attributes.put("esfQuantity", getEsfQuantity());
		attributes.put("esfDateAssign", getEsfDateAssign());
		attributes.put("esfFornitureUserID", getEsfFornitureUserID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfIDForniture = (Long)attributes.get("esfIDForniture");

		if (esfIDForniture != null) {
			setEsfIDForniture(esfIDForniture);
		}

		Long esfIdUser = (Long)attributes.get("esfIdUser");

		if (esfIdUser != null) {
			setEsfIdUser(esfIdUser);
		}

		Long esfQuantity = (Long)attributes.get("esfQuantity");

		if (esfQuantity != null) {
			setEsfQuantity(esfQuantity);
		}

		Date esfDateAssign = (Date)attributes.get("esfDateAssign");

		if (esfDateAssign != null) {
			setEsfDateAssign(esfDateAssign);
		}

		Long esfFornitureUserID = (Long)attributes.get("esfFornitureUserID");

		if (esfFornitureUserID != null) {
			setEsfFornitureUserID(esfFornitureUserID);
		}
	}

	@Override
	public long getEsfIDForniture() {
		return _esfIDForniture;
	}

	@Override
	public void setEsfIDForniture(long esfIDForniture) {
		_esfIDForniture = esfIDForniture;

		if (_esfFornitureUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfIDForniture", long.class);

				method.invoke(_esfFornitureUserRemoteModel, esfIDForniture);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfIdUser() {
		return _esfIdUser;
	}

	@Override
	public void setEsfIdUser(long esfIdUser) {
		_esfIdUser = esfIdUser;

		if (_esfFornitureUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfIdUser", long.class);

				method.invoke(_esfFornitureUserRemoteModel, esfIdUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfQuantity() {
		return _esfQuantity;
	}

	@Override
	public void setEsfQuantity(long esfQuantity) {
		_esfQuantity = esfQuantity;

		if (_esfFornitureUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfQuantity", long.class);

				method.invoke(_esfFornitureUserRemoteModel, esfQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfDateAssign() {
		return _esfDateAssign;
	}

	@Override
	public void setEsfDateAssign(Date esfDateAssign) {
		_esfDateAssign = esfDateAssign;

		if (_esfFornitureUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDateAssign", Date.class);

				method.invoke(_esfFornitureUserRemoteModel, esfDateAssign);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfFornitureUserID() {
		return _esfFornitureUserID;
	}

	@Override
	public void setEsfFornitureUserID(long esfFornitureUserID) {
		_esfFornitureUserID = esfFornitureUserID;

		if (_esfFornitureUserRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFornitureUserID",
						long.class);

				method.invoke(_esfFornitureUserRemoteModel, esfFornitureUserID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFFornitureUserRemoteModel() {
		return _esfFornitureUserRemoteModel;
	}

	public void setESFFornitureUserRemoteModel(
		BaseModel<?> esfFornitureUserRemoteModel) {
		_esfFornitureUserRemoteModel = esfFornitureUserRemoteModel;
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

		Class<?> remoteModelClass = _esfFornitureUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFornitureUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFornitureUserLocalServiceUtil.addESFFornitureUser(this);
		}
		else {
			ESFFornitureUserLocalServiceUtil.updateESFFornitureUser(this);
		}
	}

	@Override
	public ESFFornitureUser toEscapedModel() {
		return (ESFFornitureUser)ProxyUtil.newProxyInstance(ESFFornitureUser.class.getClassLoader(),
			new Class[] { ESFFornitureUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFornitureUserClp clone = new ESFFornitureUserClp();

		clone.setEsfIDForniture(getEsfIDForniture());
		clone.setEsfIdUser(getEsfIdUser());
		clone.setEsfQuantity(getEsfQuantity());
		clone.setEsfDateAssign(getEsfDateAssign());
		clone.setEsfFornitureUserID(getEsfFornitureUserID());

		return clone;
	}

	@Override
	public int compareTo(ESFFornitureUser esfFornitureUser) {
		long primaryKey = esfFornitureUser.getPrimaryKey();

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

		if (!(obj instanceof ESFFornitureUserClp)) {
			return false;
		}

		ESFFornitureUserClp esfFornitureUser = (ESFFornitureUserClp)obj;

		long primaryKey = esfFornitureUser.getPrimaryKey();

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

		sb.append("{esfIDForniture=");
		sb.append(getEsfIDForniture());
		sb.append(", esfIdUser=");
		sb.append(getEsfIdUser());
		sb.append(", esfQuantity=");
		sb.append(getEsfQuantity());
		sb.append(", esfDateAssign=");
		sb.append(getEsfDateAssign());
		sb.append(", esfFornitureUserID=");
		sb.append(getEsfFornitureUserID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFornitureUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfIDForniture</column-name><column-value><![CDATA[");
		sb.append(getEsfIDForniture());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfIdUser</column-name><column-value><![CDATA[");
		sb.append(getEsfIdUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfQuantity</column-name><column-value><![CDATA[");
		sb.append(getEsfQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfDateAssign</column-name><column-value><![CDATA[");
		sb.append(getEsfDateAssign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFornitureUserID</column-name><column-value><![CDATA[");
		sb.append(getEsfFornitureUserID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfIDForniture;
	private long _esfIdUser;
	private long _esfQuantity;
	private Date _esfDateAssign;
	private long _esfFornitureUserID;
	private BaseModel<?> _esfFornitureUserRemoteModel;
}