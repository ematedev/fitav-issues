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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFConfigurationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFConfiguration service. Represents a row in the &quot;ESFConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFConfigurationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFConfigurationImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFConfigurationImpl
 * @see it.ethica.esf.model.ESFConfiguration
 * @see it.ethica.esf.model.ESFConfigurationModel
 * @generated
 */
@JSON(strict = true)
public class ESFConfigurationModelImpl extends BaseModelImpl<ESFConfiguration>
	implements ESFConfigurationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f configuration model instance should use the {@link it.ethica.esf.model.ESFConfiguration} interface instead.
	 */
	public static final String TABLE_NAME = "ESFConfiguration";
	public static final Object[][] TABLE_COLUMNS = {
			{ "esfConfigurationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "key_", Types.VARCHAR },
			{ "value", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFConfiguration (esfConfigurationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,key_ VARCHAR(75) null,value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFConfiguration";
	public static final String ORDER_BY_JPQL = " ORDER BY esfConfiguration.esfConfigurationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFConfiguration.esfConfigurationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFConfiguration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFConfiguration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFConfiguration"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long KEY_COLUMN_BITMASK = 2L;
	public static long ESFCONFIGURATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFConfiguration"));

	public ESFConfigurationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfConfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfConfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfConfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ESFConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfConfigurationId", getEsfConfigurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfConfigurationId = (Long)attributes.get("esfConfigurationId");

		if (esfConfigurationId != null) {
			setEsfConfigurationId(esfConfigurationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@JSON
	@Override
	public long getEsfConfigurationId() {
		return _esfConfigurationId;
	}

	@Override
	public void setEsfConfigurationId(long esfConfigurationId) {
		_esfConfigurationId = esfConfigurationId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return StringPool.BLANK;
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFConfiguration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFConfiguration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFConfiguration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFConfigurationImpl esfConfigurationImpl = new ESFConfigurationImpl();

		esfConfigurationImpl.setEsfConfigurationId(getEsfConfigurationId());
		esfConfigurationImpl.setGroupId(getGroupId());
		esfConfigurationImpl.setCompanyId(getCompanyId());
		esfConfigurationImpl.setUserId(getUserId());
		esfConfigurationImpl.setUserName(getUserName());
		esfConfigurationImpl.setCreateDate(getCreateDate());
		esfConfigurationImpl.setModifiedDate(getModifiedDate());
		esfConfigurationImpl.setKey(getKey());
		esfConfigurationImpl.setValue(getValue());

		esfConfigurationImpl.resetOriginalValues();

		return esfConfigurationImpl;
	}

	@Override
	public int compareTo(ESFConfiguration esfConfiguration) {
		long primaryKey = esfConfiguration.getPrimaryKey();

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

		if (!(obj instanceof ESFConfiguration)) {
			return false;
		}

		ESFConfiguration esfConfiguration = (ESFConfiguration)obj;

		long primaryKey = esfConfiguration.getPrimaryKey();

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
		ESFConfigurationModelImpl esfConfigurationModelImpl = this;

		esfConfigurationModelImpl._originalGroupId = esfConfigurationModelImpl._groupId;

		esfConfigurationModelImpl._setOriginalGroupId = false;

		esfConfigurationModelImpl._originalKey = esfConfigurationModelImpl._key;

		esfConfigurationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFConfiguration> toCacheModel() {
		ESFConfigurationCacheModel esfConfigurationCacheModel = new ESFConfigurationCacheModel();

		esfConfigurationCacheModel.esfConfigurationId = getEsfConfigurationId();

		esfConfigurationCacheModel.groupId = getGroupId();

		esfConfigurationCacheModel.companyId = getCompanyId();

		esfConfigurationCacheModel.userId = getUserId();

		esfConfigurationCacheModel.userName = getUserName();

		String userName = esfConfigurationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfConfigurationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfConfigurationCacheModel.createDate = createDate.getTime();
		}
		else {
			esfConfigurationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfConfigurationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfConfigurationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfConfigurationCacheModel.key = getKey();

		String key = esfConfigurationCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			esfConfigurationCacheModel.key = null;
		}

		esfConfigurationCacheModel.value = getValue();

		String value = esfConfigurationCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			esfConfigurationCacheModel.value = null;
		}

		return esfConfigurationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{esfConfigurationId=");
		sb.append(getEsfConfigurationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfConfigurationId</column-name><column-value><![CDATA[");
		sb.append(getEsfConfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFConfiguration.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFConfiguration.class
		};
	private long _esfConfigurationId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _originalKey;
	private String _value;
	private long _columnBitmask;
	private ESFConfiguration _escapedModel;
}