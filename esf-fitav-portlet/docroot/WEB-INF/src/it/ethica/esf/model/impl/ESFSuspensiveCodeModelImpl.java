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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFSuspensiveCode;
import it.ethica.esf.model.ESFSuspensiveCodeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFSuspensiveCode service. Represents a row in the &quot;ESFSuspensiveCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFSuspensiveCodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFSuspensiveCodeImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveCodeImpl
 * @see it.ethica.esf.model.ESFSuspensiveCode
 * @see it.ethica.esf.model.ESFSuspensiveCodeModel
 * @generated
 */
public class ESFSuspensiveCodeModelImpl extends BaseModelImpl<ESFSuspensiveCode>
	implements ESFSuspensiveCodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f suspensive code model instance should use the {@link it.ethica.esf.model.ESFSuspensiveCode} interface instead.
	 */
	public static final String TABLE_NAME = "ESFSuspensiveCode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfSuspensiveCodeId", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFSuspensiveCode (esfSuspensiveCodeId LONG not null primary key,code_ VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFSuspensiveCode";
	public static final String ORDER_BY_JPQL = " ORDER BY esfSuspensiveCode.esfSuspensiveCodeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFSuspensiveCode.esfSuspensiveCodeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFSuspensiveCode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFSuspensiveCode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFSuspensiveCode"));

	public ESFSuspensiveCodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfSuspensiveCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSuspensiveCode.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSuspensiveCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfSuspensiveCodeId", getEsfSuspensiveCodeId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfSuspensiveCodeId = (Long)attributes.get("esfSuspensiveCodeId");

		if (esfSuspensiveCodeId != null) {
			setEsfSuspensiveCodeId(esfSuspensiveCodeId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getEsfSuspensiveCodeId() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setEsfSuspensiveCodeId(long esfSuspensiveCodeId) {
		_esfSuspensiveCodeId = esfSuspensiveCodeId;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_code = code;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ESFSuspensiveCode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFSuspensiveCode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFSuspensiveCode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFSuspensiveCodeImpl esfSuspensiveCodeImpl = new ESFSuspensiveCodeImpl();

		esfSuspensiveCodeImpl.setEsfSuspensiveCodeId(getEsfSuspensiveCodeId());
		esfSuspensiveCodeImpl.setCode(getCode());
		esfSuspensiveCodeImpl.setDescription(getDescription());

		esfSuspensiveCodeImpl.resetOriginalValues();

		return esfSuspensiveCodeImpl;
	}

	@Override
	public int compareTo(ESFSuspensiveCode esfSuspensiveCode) {
		long primaryKey = esfSuspensiveCode.getPrimaryKey();

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

		if (!(obj instanceof ESFSuspensiveCode)) {
			return false;
		}

		ESFSuspensiveCode esfSuspensiveCode = (ESFSuspensiveCode)obj;

		long primaryKey = esfSuspensiveCode.getPrimaryKey();

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ESFSuspensiveCode> toCacheModel() {
		ESFSuspensiveCodeCacheModel esfSuspensiveCodeCacheModel = new ESFSuspensiveCodeCacheModel();

		esfSuspensiveCodeCacheModel.esfSuspensiveCodeId = getEsfSuspensiveCodeId();

		esfSuspensiveCodeCacheModel.code = getCode();

		String code = esfSuspensiveCodeCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfSuspensiveCodeCacheModel.code = null;
		}

		esfSuspensiveCodeCacheModel.description = getDescription();

		String description = esfSuspensiveCodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfSuspensiveCodeCacheModel.description = null;
		}

		return esfSuspensiveCodeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfSuspensiveCodeId=");
		sb.append(getEsfSuspensiveCodeId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFSuspensiveCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfSuspensiveCodeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSuspensiveCodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFSuspensiveCode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFSuspensiveCode.class
		};
	private long _esfSuspensiveCodeId;
	private String _code;
	private String _description;
	private ESFSuspensiveCode _escapedModel;
}