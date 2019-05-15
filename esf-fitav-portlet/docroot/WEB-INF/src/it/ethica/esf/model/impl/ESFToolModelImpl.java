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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
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

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.model.ESFToolModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ESFTool service. Represents a row in the &quot;ESFTool&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.ethica.esf.model.ESFToolModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFToolImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFToolImpl
 * @see it.ethica.esf.model.ESFTool
 * @see it.ethica.esf.model.ESFToolModel
 * @generated
 */
public class ESFToolModelImpl extends BaseModelImpl<ESFTool>
	implements ESFToolModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f tool model instance should use the {@link it.ethica.esf.model.ESFTool} interface instead.
	 */
	public static final String TABLE_NAME = "ESFTool";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "esfToolId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "type_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ESFTool (uuid_ VARCHAR(75) null,esfToolId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,code_ VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null,type_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ESFTool";
	public static final String ORDER_BY_JPQL = " ORDER BY esfTool.esfToolId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ESFTool.esfToolId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.it.ethica.esf.model.ESFTool"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.it.ethica.esf.model.ESFTool"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.ethica.esf.model.ESFTool"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long DESCRIPTION_COLUMN_BITMASK = 4L;
	public static long ESFTOOLID_COLUMN_BITMASK = 8L;
	public static long GROUPID_COLUMN_BITMASK = 16L;
	public static long NAME_COLUMN_BITMASK = 32L;
	public static long TYPE_COLUMN_BITMASK = 64L;
	public static long UUID_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.it.ethica.esf.model.ESFTool"));

	public ESFToolModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _esfToolId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfToolId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfToolId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTool.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTool.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfToolId", getEsfToolId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfToolId = (Long)attributes.get("esfToolId");

		if (esfToolId != null) {
			setEsfToolId(esfToolId);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getEsfToolId() {
		return _esfToolId;
	}

	@Override
	public void setEsfToolId(long esfToolId) {
		_columnBitmask |= ESFTOOLID_COLUMN_BITMASK;

		if (!_setOriginalEsfToolId) {
			_setOriginalEsfToolId = true;

			_originalEsfToolId = _esfToolId;
		}

		_esfToolId = esfToolId;
	}

	public long getOriginalEsfToolId() {
		return _originalEsfToolId;
	}

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

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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
		_columnBitmask |= DESCRIPTION_COLUMN_BITMASK;

		if (_originalDescription == null) {
			_originalDescription = _description;
		}

		_description = description;
	}

	public String getOriginalDescription() {
		return GetterUtil.getString(_originalDescription);
	}

	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFTool.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ESFTool.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ESFTool toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ESFTool)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ESFToolImpl esfToolImpl = new ESFToolImpl();

		esfToolImpl.setUuid(getUuid());
		esfToolImpl.setEsfToolId(getEsfToolId());
		esfToolImpl.setGroupId(getGroupId());
		esfToolImpl.setCompanyId(getCompanyId());
		esfToolImpl.setUserId(getUserId());
		esfToolImpl.setUserName(getUserName());
		esfToolImpl.setCreateDate(getCreateDate());
		esfToolImpl.setModifiedDate(getModifiedDate());
		esfToolImpl.setCode(getCode());
		esfToolImpl.setName(getName());
		esfToolImpl.setDescription(getDescription());
		esfToolImpl.setType(getType());

		esfToolImpl.resetOriginalValues();

		return esfToolImpl;
	}

	@Override
	public int compareTo(ESFTool esfTool) {
		long primaryKey = esfTool.getPrimaryKey();

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

		if (!(obj instanceof ESFTool)) {
			return false;
		}

		ESFTool esfTool = (ESFTool)obj;

		long primaryKey = esfTool.getPrimaryKey();

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
		ESFToolModelImpl esfToolModelImpl = this;

		esfToolModelImpl._originalUuid = esfToolModelImpl._uuid;

		esfToolModelImpl._originalEsfToolId = esfToolModelImpl._esfToolId;

		esfToolModelImpl._setOriginalEsfToolId = false;

		esfToolModelImpl._originalGroupId = esfToolModelImpl._groupId;

		esfToolModelImpl._setOriginalGroupId = false;

		esfToolModelImpl._originalCompanyId = esfToolModelImpl._companyId;

		esfToolModelImpl._setOriginalCompanyId = false;

		esfToolModelImpl._originalCode = esfToolModelImpl._code;

		esfToolModelImpl._originalName = esfToolModelImpl._name;

		esfToolModelImpl._originalDescription = esfToolModelImpl._description;

		esfToolModelImpl._originalType = esfToolModelImpl._type;

		esfToolModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ESFTool> toCacheModel() {
		ESFToolCacheModel esfToolCacheModel = new ESFToolCacheModel();

		esfToolCacheModel.uuid = getUuid();

		String uuid = esfToolCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			esfToolCacheModel.uuid = null;
		}

		esfToolCacheModel.esfToolId = getEsfToolId();

		esfToolCacheModel.groupId = getGroupId();

		esfToolCacheModel.companyId = getCompanyId();

		esfToolCacheModel.userId = getUserId();

		esfToolCacheModel.userName = getUserName();

		String userName = esfToolCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			esfToolCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			esfToolCacheModel.createDate = createDate.getTime();
		}
		else {
			esfToolCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			esfToolCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			esfToolCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		esfToolCacheModel.code = getCode();

		String code = esfToolCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			esfToolCacheModel.code = null;
		}

		esfToolCacheModel.name = getName();

		String name = esfToolCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			esfToolCacheModel.name = null;
		}

		esfToolCacheModel.description = getDescription();

		String description = esfToolCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			esfToolCacheModel.description = null;
		}

		esfToolCacheModel.type = getType();

		String type = esfToolCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			esfToolCacheModel.type = null;
		}

		return esfToolCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfToolId=");
		sb.append(getEsfToolId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTool");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfToolId</column-name><column-value><![CDATA[");
		sb.append(getEsfToolId());
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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ESFTool.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ESFTool.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _esfToolId;
	private long _originalEsfToolId;
	private boolean _setOriginalEsfToolId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _originalCode;
	private String _name;
	private String _originalName;
	private String _description;
	private String _originalDescription;
	private String _type;
	private String _originalType;
	private long _columnBitmask;
	private ESFTool _escapedModel;
}